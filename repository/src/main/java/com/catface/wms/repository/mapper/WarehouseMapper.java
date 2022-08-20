package com.catface.wms.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 仓库 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    /**
     * 分页查询仓库列表
     *
     * @param param 仓库名称,客户ID,分页信息
     * @return 仓库列表
     */
    List<Warehouse> selectOnePage(@Param("param") QueryWarehouseParam param);
}
