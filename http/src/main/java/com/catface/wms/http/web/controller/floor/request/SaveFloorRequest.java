package com.catface.wms.http.web.controller.floor.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "保存楼层请求")
public class SaveFloorRequest {

    @ApiModelProperty(value = "楼层ID")
    private Long id;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "仓库ID", required = true, example = "121212")
    @NotNull(message = "仓库ID不能为空")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层名称",required = true,example = "第一层")
    @NotBlank(message = "楼层名称不能为空")
    private String floorName;

    @ApiModelProperty(value = "楼层编码",required = true,example = "L1")
    @NotBlank(message = "楼层编码不能为空")
    private String floorCode;

    @ApiModelProperty(value = "楼层面积，单位：平方米")
    private Integer areaSize;

    @ApiModelProperty(value = "高度，单位：米")
    private Integer height;

    @ApiModelProperty(value = "备注")
    private String remark;
}
