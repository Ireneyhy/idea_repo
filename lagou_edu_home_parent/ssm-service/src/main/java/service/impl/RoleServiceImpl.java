package service.impl;

import dao.RoleMapper;
import heying.domain.Role;
import heying.domain.RoleMenuVo;
import heying.domain.Role_menu_relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll(Role role) {

        return roleMapper.findAll(role);
    }

    @Override
    public void updateRoleMenus(RoleMenuVo rmv) {

        roleMapper.clearRoleMenu(rmv.getRoleId());

        List<Integer> menuIdList = rmv.getMenuIdList();

        for (Integer integer : menuIdList) {
            Role_menu_relation rmr = new Role_menu_relation();
            rmr.setRoleId(rmv.getRoleId());
            rmr.setCreatedTime(new Date());
            rmr.setUpdatedTime(new Date());
            rmr.setMenuId(integer);
            rmr.setUpdatedBy("system");
            rmr.setCreatedBy("system");
            roleMapper.updateRoleMenu(rmr);
        }
    }

    @Override
    public void deleteRole(int roleId) {
        roleMapper.clearRoleMenu(roleId);
        roleMapper.deleteRole(roleId);
    }
}
