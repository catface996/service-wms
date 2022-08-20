package com.catface.wms.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.mapper.AreaMapper;
import com.catface.wms.repository.service.AreaRpService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库区 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Service
public class AreaRpServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaRpService {

    /**
     * 检查指定的仓库下是否存在库区
     *
     * @param warehouseId 指定的仓库ID
     * @return true:存在库区;false:不存在库区;
     */
    public boolean existArea(Long warehouseId) {
        Area entity = baseMapper.existArea(warehouseId);
        return entity != null;
    }
}
