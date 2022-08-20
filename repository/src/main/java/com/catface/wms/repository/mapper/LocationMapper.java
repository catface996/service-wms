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
    Location existLocation(@Param("warehouseId") Long warehouseId);
}
