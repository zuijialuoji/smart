package com.smart.service;

import com.smart.core.service.Service;
import com.smart.domain.sys.Menu;
import com.smart.utils.Tree;

import java.util.List;

public interface  MenuService  extends Service<Menu, Long> {

    /**
     *
     * @param id
     * @return
     */
    List<Tree<Menu>> listMenuTree(Long id);
    Tree<Menu> getTree();
    Tree<Menu> getTree(Long id);
}
