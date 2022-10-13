package controller;

import com.github.pagehelper.PageInfo;
import heying.domain.Resource;
import heying.domain.ResourceVo;
import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    public ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVo resourceVo) {

//        List<Resource> list = resourceService.findAllResource(resourceVo);

        PageInfo<Resource> resourcePageInfo = resourceService.findAllResource(resourceVo);
        return new ResponseResult(true,200,"查找成功", resourcePageInfo);
    }
}
