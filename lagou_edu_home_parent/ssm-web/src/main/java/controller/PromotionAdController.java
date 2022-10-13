package controller;

import com.github.pagehelper.PageInfo;
import heying.domain.PromotionAd;
import heying.domain.PromotionAdVo;
import heying.domain.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PromotionAdService;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAll")
    public ResponseResult findAll(PromotionAdVo promotionAdVo){

        PageInfo<PromotionAd> list = promotionAdService.findAll(promotionAdVo);
        return new ResponseResult(true,200,"查询成功", list);
    }

    @RequestMapping("/updateStatus")
    public ResponseResult updateStatus(int id, int status){
        promotionAdService.updateStatus(id, status);
        return new ResponseResult(true,200,"updated", null);
    }
}
