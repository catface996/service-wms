package com.catface.wms.http.web.controller.warehouse.request;

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
@ApiModel(description = "保存仓库请求")
public class SaveWarehouseRequest {

    @ApiModelProperty(value = "仓库ID，主键")
    private Long id;

    @ApiModelProperty(value = "当前会话中的客户ID", required = true, example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "当前会话中的用户ID", required = true, example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "仓库名称", required = true, example = "中心一号仓")
    @NotBlank(message = "仓库名称不能为空")
    private String warehouseName;

    @ApiModelProperty(value = "省份编码")
    private String provinceCode;

    @ApiModelProperty(value = "省份名称")
    private String provinceName;

    @ApiModelProperty(value = "城市编码")
    private String cityCode;

    @ApiModelProperty(value = "城市名称")
    private String cityName;

    @ApiModelProperty(value = "县区编码")
    private String countyCode;

    @ApiModelProperty(value = "县区名称")
    private String countyName;

    @ApiModelProperty(value = "街道编码")
    private String streetCode;

    @ApiModelProperty(value = "街道名称")
    private String streetName;

    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "备注")
    private String remark;

}
