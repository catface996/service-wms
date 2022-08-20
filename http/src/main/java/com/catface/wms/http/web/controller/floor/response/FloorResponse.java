package com.catface.wms.http.web.controller.floor.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "楼层模型")
public class FloorResponse {

    @ApiModelProperty(value = "楼层ID")
    private Long id;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层名称")
    private String floorName;

    @ApiModelProperty(value = "楼层编码")
    private String floorCode;

    @ApiModelProperty(value = "楼层面积，单位：平方米")
    private Integer areaSize;

    @ApiModelProperty(value = "高度，单位：米")
    private Integer height;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "创建时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;
}
