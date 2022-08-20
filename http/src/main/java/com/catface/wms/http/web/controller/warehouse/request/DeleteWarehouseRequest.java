package com.catface.wms.http.web.controller.warehouse.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "删除仓库请求")
public class DeleteWarehouseRequest {

    @ApiModelProperty(value = "仓库ID", required = true, example = "121212121")
    @NotNull(message = "待删除的仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

}
