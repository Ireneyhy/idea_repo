package service;

import heying.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

    List<PromotionSpace> findAll();
    void addPromotionSpace(PromotionSpace promotionSpace);
    PromotionSpace findSpaceById(int id);
    void updatePromotionSpace(PromotionSpace promotionSpace);
}
