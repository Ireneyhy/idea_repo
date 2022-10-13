package controller;

import com.github.pagehelper.PageInfo;
import heying.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ResponseResult findAll(@RequestBody UserVo userVo){

        PageInfo pageInfo = userService.findAll(userVo);
        return new ResponseResult(true, 200, "查找成功", pageInfo);
    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user1 = userService.login(user);
        if (user1 != null){
            HttpSession session = request.getSession();
            String s = UUID.randomUUID().toString();
            session.setAttribute("access_token", s);
            session.setAttribute("user_id", user1.getId());
            Map<Object, Object> map = new HashMap<>();
            map.put("access_token", s);
            map.put("user_id", user1.getId());
            return new ResponseResult(true,200,"登录成功",map);
        } else {
            return new ResponseResult(false,400,"用户名密码错误",null);
        }
    }

    @RequestMapping("/findUserRole")
    public ResponseResult findUserRole(int userId){

        List<Role> list = userService.findUserRole(userId);
        return new ResponseResult(true,200,"查找成功", list);
    }

    @RequestMapping("/allocateRole")
    public ResponseResult allocateRole(@RequestBody UserRoleVo userRoleVo){

        userService.allocateRole(userRoleVo);
        return new ResponseResult(true,200,"更新成功", null);
    }
}
