package com.catface.wms.http.web.controller.warehouse;

import com.catface.common.model.JsonResult;
import com.catface.common.model.PageVO;
import com.catface.wms.http.config.swagger.SwaggerTagConst;
import com.catface.wms.http.web.controller.warehouse.request.DeleteWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.request.GetWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.request.SaveWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.response.WarehouseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author catface
 * @since 2022/8/20
 */
@Api(tags = {SwaggerTagConst.WAREHOUSE})
@Slf4j
@RestController
public class WarehouseController {

    @ApiOperation(value = "保存仓库")
    @PostMapping(value = "/public/warehouse/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveWarehouseRequest request) {
        return null;
    }

    @ApiOperation(value = "分页查询仓库列表")
    @PostMapping(value = "/public/warehouse/getOnePage")
    public JsonResult<PageVO<WarehouseResponse>> getOnePage(@RequestBody @Valid GetWarehouseRequest request) {
        return null;
    }

    @ApiOperation(value = "删除仓库")
    @PostMapping(value = "/public/warehouse/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid DeleteWarehouseRequest requests) {
        return null;
    }

}
