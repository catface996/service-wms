package com.catface.wms.http.web.controller.area.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "分页查询库区请求")
public class GetAreaRequest extends PageRequest {

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "仓库ID", example = "121212")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层ID", example = "343434")
    private Long floorId;

}
