package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.PromotionAdMapper;
import heying.domain.PromotionAd;
import heying.domain.PromotionAdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PromotionAdService;

import java.util.Date;
import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findAll(PromotionAdVo promotionAdVo) {

        PageHelper.startPage(promotionAdVo.getCurrentPage(), promotionAdVo.getPageSize());
        List<PromotionAd> list = promotionAdMapper.findAll();

        return new PageInfo<>(list);
    }

    @Override
    public void updateStatus(int id, int status) {

        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setUpdateTime(new Date());
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAdMapper.updateStatus(promotionAd);
    }
}
