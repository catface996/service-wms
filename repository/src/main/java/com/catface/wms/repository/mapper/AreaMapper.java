package com.catface.wms.repository.mapper;

import com.catface.wms.repository.entity.Area;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 库区 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
public interface AreaMapper extends BaseMapper<Area> {

    /**
     * 检查指定仓库下是否存在库区
     * @param warehouseId 指定的仓库ID
     * @return 库区
     */
    Area existArea(@Param("warehouseId") Long warehouseId);
}
