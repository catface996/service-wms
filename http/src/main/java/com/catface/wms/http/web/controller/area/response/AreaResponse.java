package com.catface.wms.http.web.controller.area.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "库区模型")
public class AreaResponse {

    @ApiModelProperty(value = "库区ID，主键")
    private Long id;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "所属仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层ID")
    private Long floorId;

    @ApiModelProperty(value = "库区名称")
    private String areaName;

    @ApiModelProperty(value = "库区编码")
    private String areaCode;

    @ApiModelProperty(value = "库区面积大小，单位：平方米")
    private Integer areaSize;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;
}
