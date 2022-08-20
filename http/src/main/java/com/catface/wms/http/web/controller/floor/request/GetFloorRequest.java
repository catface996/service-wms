package com.catface.wms.http.web.controller.floor.request;

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
@ApiModel(description = "分页查询楼层")
public class GetFloorRequest extends PageRequest {

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "1234567890")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "仓库ID",example = "12121212")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层名称",example = "第一层")
    private String floorName;

}
