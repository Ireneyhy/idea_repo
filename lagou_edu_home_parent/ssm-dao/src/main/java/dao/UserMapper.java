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
    List<Resource> getResourceByRoleId2(List<Integer> roleId);
    
    void test5();
    void test6();
    void test7();
    void test8();

    void test1();
    void test2();
    void test3();
    void test4();


}
