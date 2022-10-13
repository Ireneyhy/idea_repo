package service;

import heying.domain.Role;
import heying.domain.RoleMenuVo;

import java.util.List;

public interface RoleService {

    List<Role> findAll(Role role);
    void updateRoleMenus(RoleMenuVo rmv);

    void deleteRole(int roleId);
}
