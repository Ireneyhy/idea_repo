package dao;

import heying.domain.Resource;
import heying.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper {
    List<Resource> findAllResource(ResourceVo resourceVo);
}
