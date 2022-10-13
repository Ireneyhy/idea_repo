package controller;

import heying.domain.Menu;
import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findSubMenuList")
    public ResponseResult findSubMenuList(){
        List<Menu> list = menuService.findSubMenuList(-1);
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList", list);
        return new ResponseResult(true, 200, "查找成功", map);
    }

    @RequestMapping("/getRoleMenus")
    public ResponseResult getRoleMenus(int roleId){
        List<Integer> list = menuService.getRoleMenus(roleId);
        return new ResponseResult(true, 200, "查找成功", list);
    }

    @RequestMapping("/findAll")
    public ResponseResult findAll(){
        List<Menu> list = menuService.findAll();
        return new ResponseResult(true, 200, "查找成功", list);
    }

    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(int id){

        if (id == -1) {
            List<Menu> list = menuService.findSubMenuList(-1);
            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo", null);
            map.put("parentMenuList", list);
            return new ResponseResult(true, 200, "添加操作回显成功", map);
        } else {
            Menu menu = menuService.findMenuInfo(id);
            List<Menu> list = menuService.findSubMenuList(id);

            Map<String, Object> map = new HashMap<>();
            map.put("menuInfo", menu);
            map.put("parentMenuList", list);
            return new ResponseResult(true, 200, "编辑操作回显成功", map);        }

    }
}
