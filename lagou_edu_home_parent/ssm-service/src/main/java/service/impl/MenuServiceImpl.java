package service.impl;

import dao.MenuMapper;
import heying.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuList(int parentId) {
        return menuMapper.findSubMenuList(parentId);
    }

    @Override
    public List<Integer> getRoleMenus(int roleId) {
        return menuMapper.getRoleMenus(roleId);
    }

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    @Override
    public Menu findMenuInfo(int id) {

        return menuMapper.findMenuInfo(id);
    }


}
