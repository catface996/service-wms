package com.catface.wms.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.mapper.FloorMapper;
import com.catface.wms.repository.service.FloorRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库楼层 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Slf4j
@Service
public class FloorRpServiceImpl extends ServiceImpl<FloorMapper, Floor> implements FloorRpService {

    /**
     * 检查是否在指定仓库下创建了楼层
     *
     * @param warehouseId 仓库ID
     * @return 是否存在楼层
     */
    @Override
    public boolean existFloor(Long warehouseId) {
        Floor entity = baseMapper.existFloor(warehouseId);
        return entity != null;
    }
}
