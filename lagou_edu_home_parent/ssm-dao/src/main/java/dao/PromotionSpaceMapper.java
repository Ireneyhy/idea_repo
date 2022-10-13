package dao;

import heying.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    List<PromotionSpace> findAll();
    void addPromotionSpace(PromotionSpace promotionSpace);
    PromotionSpace findSpaceById(int id);
    void updatePromotionSpace(PromotionSpace ps);
}
