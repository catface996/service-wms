package com.catface.wms.http.web.controller.floor.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "删除楼层请求")
public class DeleteFloorRequest {

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "9876543210")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "待删除的楼层ID", required = true, example = "121212121212")
    @NotNull(message = "楼层ID不能为空")
    private Long floorId;
}
