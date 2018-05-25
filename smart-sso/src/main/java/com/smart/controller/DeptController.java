package com.smart.controller;

import com.smart.core.domin.R;
import com.smart.domain.sys.Dept;
import com.smart.service.DeptService;
import com.smart.utils.Constant;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    private String prefix = "system/dept";

    @GetMapping()
    String dept() {
        return prefix + "/dept";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Dept> list() {
        Map<String, Object> query = new HashMap<>(16);
        List<Dept> sysDeptList = deptService.condition(query);
        return sysDeptList;
    }


    @GetMapping("/add/{pId}")
    String add(@PathVariable("pId") Long pId, Model model) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "总部门");
        } else {
            model.addAttribute("pName", deptService.get(pId).getName());
        }
        return  prefix + "/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        Dept sysDept = deptService.get(id);
        model.addAttribute("sysDept", sysDept);
        if(Constant.DEPT_ROOT_ID.equals(sysDept.getParentId())) {
            model.addAttribute("parentDeptName", "无");
        }else {
            Dept parDept = deptService.get(sysDept.getParentId());
            model.addAttribute("parentDeptName", parDept.getName());
        }
        return  prefix + "/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(Dept sysDept) {
      /*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (deptService.save(sysDept) > 0) {
            return R.ok();
        }
        return R.error();
    }


    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(Dept sysDept) {
      /*  if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        if (deptService.update(sysDept) > 0) {
            return R.ok();
        }
        return R.error();
    }
    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
  /*      if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("parentId", id);
        if(deptService.count(map)>0) {
            return R.error(1, "包含下级部门,不允许修改");
        }
        if(deptService.checkDeptHasUser(id)) {
            if (deptService.remove(id) > 0) {
                return R.ok();
            }
        }else {
            return R.error(1, "部门包含用户,不允许修改");
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] deptIds) {
     /*   if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }*/
        deptService.batchRemove(deptIds);
        return R.ok();
    }

    @GetMapping("/tree")
    @ResponseBody
    public Tree<Dept> tree() {
        Tree<Dept> tree = new Tree<Dept>();
        tree = deptService.getTree();
        return tree;
    }

    @GetMapping("/treeView")
    String treeView() {
        return  prefix + "/deptTree";
    }
}
