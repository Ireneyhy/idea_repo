package service.impl;

import dao.ResourceCategoryMapper;
import heying.domain.ResourceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ResourceCategoryService;

import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;


    @Override
    public List<ResourceCategory> findAll() {
        return resourceCategoryMapper.findAll();
    }
}
