package com.catface.wms.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Warehouse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
public class QueryWarehouseParam extends Page<Warehouse> {

    @ApiModelProperty(value ="待查询的仓库名称")
    private String warehouseName;

    @ApiModelProperty(value ="仓库所属客户ID")
    private Long clientId;
}
