package controller;

import heying.domain.ResponseResult;
import heying.domain.Role;
import heying.domain.RoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ResponseResult findAll(@RequestBody Role role){

        List<Role> list = roleService.findAll(role);
        return new ResponseResult(true, 200, "查找成功", list);
    }

    @RequestMapping("/updateRoleMenus")
    public ResponseResult updateRoleMenus(@RequestBody RoleMenuVo rmv){

        roleService.updateRoleMenus(rmv);
        return new ResponseResult(true, 200, "更新成功", null);
    }

    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(int roleId){

        roleService.deleteRole(roleId);
        return new ResponseResult(true, 200, "删除成功", null);
    }
}
