package dao;

import heying.domain.*;

import java.util.List;

public interface UserMapper {

    List<User> findAll(UserVo userVo);
    User login(User user);
    void allocateRole(User_role_relation urr);
    void clearRole(int userId);
    List<Role> findUserRole(int userId);
    List<Menu> getParentMenu(List<Integer> roleId);
    List<Menu> getSubMenu(int parentId);
    List<Resource> getResourceByRoleId(List<Integer> roleId);

}
