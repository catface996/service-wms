package com.catface.wms.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.wms.repository.entity.Location;
import com.catface.wms.repository.mapper.LocationMapper;
import com.catface.wms.repository.service.LocationRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库位 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Slf4j
@Service
public class LocationRpServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationRpService {


    /**
     * 检查指定仓库下是否存在库位
     *
     * @param warehouseId 指定的仓库ID
     * @return 库位
     */
    @Override
    public boolean existLocationByWarehouse(Long warehouseId) {
        Location entity = baseMapper.existLocationByWarehouse(warehouseId);
        return entity != null;
    }

    /**
     * 检查指定楼层是否存在库位
     *
     * @param floorId 指定的楼层
     * @return 库位
     */
    @Override
    public boolean existLocationByFloor(Long floorId) {
        Location entity = baseMapper.existLocationByFloor(floorId);
        return entity != null;
    }

    /**
     * 检查指定库区是否存在库位
     *
     * @param areaId 指定的库区ID
     * @return 库位
     */
    @Override
    public boolean existLocationByArea(Long areaId) {
        Location entity = baseMapper.existLocationByArea(areaId);
        return entity != null;
    }


}
