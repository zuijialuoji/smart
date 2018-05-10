package com.smart.service.impl;

import com.smart.core.service.Impl.ServiceImpl;
import com.smart.dao.sso.MenuDao;
import com.smart.domain.sys.Menu;
import com.smart.service.MenuService;
import com.smart.utils.BuildTree;
import com.smart.utils.Tree;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu, Long> implements MenuService {

    @Autowired
    public void setDao(MenuDao dao) {
        this.dao = dao;
    }


    public List<Tree<Menu>> listMenuTree(Long id) {
        List<Tree<Menu>> trees = new ArrayList<Tree<Menu>>();
        List<Menu> Menus = dao.listMenuByUserId(id);
        for (Menu sysMenu : Menus) {
            Tree<Menu> tree = new Tree<Menu>();
            tree.setId(sysMenu.getId().toString());
            tree.setParentId(sysMenu.getParentId().toString());
            tree.setText(sysMenu.getName());
            Map<String, Object> attributes = new HashMap<>(16);
            attributes.put("url", sysMenu.getUrl());
            attributes.put("icon", sysMenu.getIcon());
            tree.setAttributes(attributes);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        List<Tree<Menu>> list = BuildTree.buildList(trees, "0");
        return list;
    }
}
