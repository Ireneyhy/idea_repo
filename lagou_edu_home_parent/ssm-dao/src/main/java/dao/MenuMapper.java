package dao;

import heying.domain.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> findSubMenuList(int pid);
    List<Integer> getRoleMenus(int roleId);
    List<Menu> findAll();
    Menu findMenuInfo(int id);

}
