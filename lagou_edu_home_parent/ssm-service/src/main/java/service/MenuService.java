package service;

import heying.domain.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findSubMenuList(int parentId);
    List<Integer> getRoleMenus(int roleId);
    List<Menu> findAll();
    Menu findMenuInfo(int id);
}