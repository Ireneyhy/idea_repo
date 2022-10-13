package dao;

import heying.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    List<PromotionAd> findAll();
    void updateStatus(PromotionAd promotionAd);
}
