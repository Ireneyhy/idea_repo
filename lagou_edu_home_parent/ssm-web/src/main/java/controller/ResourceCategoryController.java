package controller;

import heying.domain.ResourceCategory;
import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ResourceCategoryService;

import java.util.List;

@RequestMapping("/resourceCategory")
@RestController
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService service;

    @RequestMapping("/findAll")
    public ResponseResult findAll(){
        List<ResourceCategory> list = service.findAll();
        return new ResponseResult(true,200,"查找成功", list);
    }
}
