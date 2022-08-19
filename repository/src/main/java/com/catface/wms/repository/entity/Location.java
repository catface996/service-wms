package com.catface.wms.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 库位
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Location对象", description = "库位")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库位ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "所属仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层ID")
    private Long floorId;

    @ApiModelProperty(value = "库区ID")
    private Long areaId;

    @ApiModelProperty(value = "行号")
    private Integer rowNo;

    @ApiModelProperty(value = "列号")
    private Integer columnNo;

    @ApiModelProperty(value = "库位编码")
    private String locationCode;

    @ApiModelProperty(value = "库位长度，单位：米")
    private Integer length;

    @ApiModelProperty(value = "库位宽度，单位：米")
    private Integer width;

    @ApiModelProperty(value = "库位高度，单位：米")
    private Integer height;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
