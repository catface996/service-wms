package com.catface.wms.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Floor;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
public class QueryFloorParam extends Page<Floor> {

    @ApiModelProperty(value = "客户ID")
    private Long clientId;

    @ApiModelProperty(value = "仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层名称")
    private String floorName;
}
