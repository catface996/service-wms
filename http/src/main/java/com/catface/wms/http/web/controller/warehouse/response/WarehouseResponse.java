package com.catface.wms.http.web.controller.warehouse.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/20
 */
@Data
@ApiModel(description = "仓库模型")
public class WarehouseResponse {

    @ApiModelProperty(value = "仓库ID，主键")
    private Long id;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "仓库名称")
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

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;
}
