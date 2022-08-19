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
 * 库区
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Area对象", description = "库区")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库区ID，主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "所属仓库ID")
    private Long warehouseId;

    @ApiModelProperty(value = "楼层ID")
    private Long floorId;

    @ApiModelProperty(value = "库区名称")
    private String areaName;

    @ApiModelProperty(value = "库区编码")
    private String areaCode;

    @ApiModelProperty(value = "库区面积大小，单位：平方米")
    private Integer areaSize;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
