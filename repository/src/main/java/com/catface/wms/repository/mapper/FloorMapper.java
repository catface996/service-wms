package com.catface.wms.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.param.QueryFloorParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询楼层
     *
     * @param param 客户ID,仓库ID,楼层名称,分页信息
     * @return 楼层列表
     */
    List<Floor> selectOnePage(@Param("param") QueryFloorParam param);
}
