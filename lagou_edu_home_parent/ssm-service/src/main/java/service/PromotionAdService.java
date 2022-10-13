package service;

import com.github.pagehelper.PageInfo;
import heying.domain.PromotionAd;
import heying.domain.PromotionAdVo;

public interface PromotionAdService {

    PageInfo<PromotionAd> findAll(PromotionAdVo promotionAdVo);
    void updateStatus(int id, int status);
}
