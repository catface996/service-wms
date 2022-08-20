package com.catface.wms.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.wms.repository.entity.Location;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 库位 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
public interface LocationMapper extends BaseMapper<Location> {

    /**
     * 检查指定仓库下是否存在库位
     *
     * @param warehouseId 指定仓库的ID
     * @return 库位
     */
    Location existLocationByWarehouse(@Param("warehouseId") Long warehouseId);

    /**
     * 检查指定楼层下是否存在库位
     *
     * @param floorId 指定的楼层ID
     * @return 库位
     */
    Location existLocationByFloor(@Param("floorId") Long floorId);

    /**
     * 检查指定库区下是否存在库位
     *
     * @param areaId 指定库区ID
     * @return 库位
     */
    Location existLocationByArea(@Param("areaId") Long areaId);

}
