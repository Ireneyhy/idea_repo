package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserMapper;
import heying.domain.*;
import utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAll(UserVo userVo) {

        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> list = userMapper.findAll(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public User login(User user) throws Exception {

        User user2 = userMapper.login(user);
        if (user2 != null && Md5.verify(user.getPassword(),"heying",user2.getPassword())) {
            return user2;
        } else {
            return null;
        }
    }

    @Override
    public List<Role> findUserRole(int userId) {

        return userMapper.findUserRole(userId);
    }

    @Override
    public void allocateRole(UserRoleVo userRoleVo) {

        userMapper.clearRole(userRoleVo.getUserId());

        List<Integer> roleIdList = userRoleVo.getRoleIdList();

        for (Integer integer : roleIdList) {
            User_role_relation urr = new User_role_relation();
            urr.setCreatedTime(new Date());
            urr.setUpdatedTime(new Date());
            urr.setUpdatedBy("system");
            urr.setCreatedBy("system");
            urr.setUserId(userRoleVo.getUserId());
            urr.setRoleId(integer);
            userMapper.allocateRole(urr);
        }
    }

    @Override
    public ResponseResult getUserPermissions(int userId) {

        List<Role> roles = userMapper.findUserRole(userId);
        List<Integer> roleIdList = new ArrayList<>();
        for (Role role : roles) {
            roleIdList.add(role.getId());
        }

        List<Menu> parentMenu = userMapper.getParentMenu(roleIdList);

        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.getSubMenu(menu.getId());
            menu.setSubMenuList(subMenu);
        }

        List<Resource> resourceList = userMapper.getResourceByRoleId(roleIdList);

        Map<String, Object> map = new HashMap<>();

        map.put("menuList", parentMenu);
        map.put("resourceList", resourceList);

        return new ResponseResult(true, 200, "获取权限信息成功", map);
    }
}
