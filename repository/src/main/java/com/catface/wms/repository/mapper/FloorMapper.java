package com.catface.wms.repository.mapper;

import com.catface.wms.repository.entity.Floor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 仓库楼层 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
public interface FloorMapper extends BaseMapper<Floor> {

    /**
     * 检查是否在指定仓库下存在漏乘
     *
     * @param warehouseId 仓库ID
     * @return 楼层
     */
    Floor existFloor(@Param("warehouseId") Long warehouseId);
}
