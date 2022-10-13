package service.impl;

import dao.PromotionSpaceMapper;
import heying.domain.PromotionSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PromotionSpaceService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findAll() {
        return promotionSpaceMapper.findAll();
    }

    @Override
    public void addPromotionSpace(PromotionSpace promotionSpace) {

        promotionSpace.setCreateTime(new Date());
        promotionSpace.setUpdateTime(new Date());
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        promotionSpace.setIsDel(0);
        promotionSpaceMapper.addPromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findSpaceById(int id) {

        return promotionSpaceMapper.findSpaceById(id);
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {

        promotionSpace.setUpdateTime(new Date());
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
