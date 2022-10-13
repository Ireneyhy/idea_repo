package service;

import com.github.pagehelper.PageInfo;
import heying.domain.*;

import java.util.List;

public interface UserService {

    PageInfo findAll(UserVo userVo);

    User login(User user) throws Exception;
    List<Role> findUserRole(int userId);
    void allocateRole(UserRoleVo userRoleVo);
    ResponseResult getUserPermissions(int userId);
}
