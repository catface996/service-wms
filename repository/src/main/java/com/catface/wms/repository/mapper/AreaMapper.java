package com.catface.wms.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.param.QueryAreaParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     *
     * @param warehouseId 指定的仓库ID
     * @return 库区
     */
    Area existAreaByWarehouse(@Param("warehouseId") Long warehouseId);

    /**
     * 检查指定楼层下是否存在库区
     *
     * @param floorId 指定楼层ID
     * @return 库区
     */
    Area existAreaByFloor(@Param("floorId") Long floorId);

    /**
     * 分页查询库区
     *
     * @param param 客户ID,仓库ID,楼层ID,库区名称,库区编码,分页信息
     * @return 库区列表
     */
    List<Area> selectOnePage(@Param("param") QueryAreaParam param);
}
