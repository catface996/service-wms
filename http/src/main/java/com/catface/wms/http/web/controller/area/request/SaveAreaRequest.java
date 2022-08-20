package com.catface.wms.http.web.controller.area.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "保存库区请求")
public class SaveAreaRequest {

    @ApiModelProperty(value = "库区ID，主键")
    private Long id;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "所属仓库ID", required = true, example = "121212")
    @NotNull(message = "所属仓库ID不能为空")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层ID")
    private Long floorId;

    @ApiModelProperty(value = "库区名称", required = true, example = "东1区")
    @NotBlank(message = "库区名称不能为空")
    private String areaName;

    @ApiModelProperty(value = "库区编码", required = true, example = "E1")
    @NotBlank(message = "库区编码不能为空")
    private String areaCode;

    @ApiModelProperty(value = "库区面积大小，单位：平方米")
    private Integer areaSize;

    @ApiModelProperty(value = "备注")
    private String remark;
}
