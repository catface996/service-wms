package com.catface.wms.http.web.controller.warehouse;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.JsonResult;
import com.catface.common.model.PageVO;
import com.catface.wms.http.config.swagger.SwaggerTagConst;
import com.catface.wms.http.web.controller.warehouse.convert.WarehouseWebConvert;
import com.catface.wms.http.web.controller.warehouse.request.DeleteWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.request.GetWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.request.SaveWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.response.WarehouseResponse;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;
import com.catface.wms.service.warehouse.WarehouseService;
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

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @ApiOperation(value = "保存仓库")
    @PostMapping(value = "/public/warehouse/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveWarehouseRequest request) {
        Warehouse entity = WarehouseWebConvert.convert(request);
        warehouseService.save(entity);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "分页查询仓库列表")
    @PostMapping(value = "/public/warehouse/getOnePage")
    public JsonResult<PageVO<WarehouseResponse>> getOnePage(@RequestBody @Valid GetWarehouseRequest request) {
        QueryWarehouseParam param = WarehouseWebConvert.convert(request);
        Page<Warehouse> page = warehouseService.getOnePage(param);
        PageVO<WarehouseResponse> pageVO = WarehouseWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "删除仓库")
    @PostMapping(value = "/public/warehouse/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid DeleteWarehouseRequest requests) {
        warehouseService.delete(requests.getWarehouseId(),requests.getCtxClientId());
        return JsonResult.success(true);
    }

}
