package controller;

import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){

        String header = request.getHeader("Authorization");
        HttpSession session = request.getSession();
        String accessToken = (String)session.getAttribute("access_token");

        if (header.equals(accessToken)){
            int userId = (Integer)session.getAttribute("user_id");
            return userService.getUserPermissions(userId);
        } else {
            return new ResponseResult(false,400,"Error",null);
        }
    }
}
