package com.catface.wms.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.wms.repository.entity.Location;

/**
 * <p>
 * 库位 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
public interface LocationRpService extends IService<Location> {

    /**
     * 检查指定仓库下是否存在库位
     *
     * @param warehouseId 指定的仓库ID
     * @return 库位
     */
    boolean existLocationByWarehouse(Long warehouseId);

    /**
     * 检查指定楼层是否存在库位
     *
     * @param floorId 指定的楼层
     * @return 库位
     */
    boolean existLocationByFloor(Long floorId);

    /**
     * 检查指定库区是否存在库位
     *
     * @param areaId 指定的库区ID
     * @return 库位
     */
    boolean existLocationByArea(Long areaId);

}
