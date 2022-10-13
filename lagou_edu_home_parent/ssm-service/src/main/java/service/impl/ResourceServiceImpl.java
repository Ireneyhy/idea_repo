package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.ResourceMapper;
import heying.domain.Resource;
import heying.domain.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ResourceService;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {

        PageHelper.startPage(resourceVo.getCurrentPage(), resourceVo.getPageSize());
        List<Resource> list = resourceMapper.findAllResource(resourceVo);
//        return list;
        return new PageInfo<>(list);
    }
}
