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
 * 仓库楼层
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Floor对象", description = "仓库楼层")
public class Floor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼层ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "创建时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
