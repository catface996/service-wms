package com.catface.wms.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Area;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
public class QueryAreaParam extends Page<Area> {

    @ApiModelProperty(value = "客户ID")
    private Long clientId;

    @ApiModelProperty(value = "仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层ID")
    private Long floorId;

    @ApiModelProperty(value = "库区名称")
    private String areaName;

    @ApiModelProperty(value = "库区编码")
    private String areaCode;

}
