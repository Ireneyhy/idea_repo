package service;

import com.github.pagehelper.PageInfo;
import heying.domain.Resource;
import heying.domain.ResourceVo;

import java.util.List;

public interface ResourceService {

    PageInfo<Resource> findAllResource(ResourceVo resourceVo);

}
