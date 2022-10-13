package dao;

import heying.domain.Role;
import heying.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll(Role role);
    void clearRoleMenu(int roleId);
    void updateRoleMenu(Role_menu_relation rmr);
    void deleteRole(int roleId);
}
