package controller;

import heying.domain.PromotionSpace;
import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PromotionSpaceService;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAll")
    public ResponseResult findAll(){

        List<PromotionSpace> list = promotionSpaceService.findAll();
        return new ResponseResult(true, 200, "Successful", list);
    }

    @RequestMapping("/addOrUpdatePromotionSpace")
    public ResponseResult addOrUpdatePromotionSpace(@RequestBody PromotionSpace ps){

        if (ps.getId() == 0) {
            promotionSpaceService.addPromotionSpace(ps);
            return new ResponseResult(true, 200, "Added", null);
        } else {
            promotionSpaceService.updatePromotionSpace(ps);
            return new ResponseResult(true, 200, "Updated", null);
        }
    }

    @RequestMapping("/findSpaceById")
    public ResponseResult findSpaceById(int id) {

        PromotionSpace space = promotionSpaceService.findSpaceById(id);
        return new ResponseResult(true,200,"查找成功", space);
    }

}
