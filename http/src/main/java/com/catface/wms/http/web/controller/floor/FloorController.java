package com.catface.wms.http.web.controller.floor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.JsonResult;
import com.catface.common.model.PageVO;
import com.catface.wms.http.config.swagger.SwaggerTagConst;
import com.catface.wms.http.web.controller.floor.convert.FloorWebConvert;
import com.catface.wms.http.web.controller.floor.request.DeleteFloorRequest;
import com.catface.wms.http.web.controller.floor.request.GetFloorRequest;
import com.catface.wms.http.web.controller.floor.request.SaveFloorRequest;
import com.catface.wms.http.web.controller.floor.response.FloorResponse;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.param.QueryFloorParam;
import com.catface.wms.service.floor.FloorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/20
 */
@Api(tags = {SwaggerTagConst.FLOOR})
@Slf4j
@RestController
public class FloorController {

    private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @ApiOperation(value = "保存楼层")
    @PostMapping(value = "/public/floor/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveFloorRequest request) {
        Floor entity = FloorWebConvert.convert(request);
        floorService.save(entity);
        return JsonResult.success(true);
    }


    @ApiOperation(value = "分页查询楼层")
    @PostMapping(value = "/public/floor/getOnePage")
    public JsonResult<PageVO<FloorResponse>> getOnePage(@RequestBody @Valid GetFloorRequest request) {
        QueryFloorParam param = FloorWebConvert.convert(request);
        Page<Floor> page = floorService.queryOnePage(param);
        PageVO<FloorResponse> pageVO = FloorWebConvert.convert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "删除楼层")
    @PostMapping(value = "/public/floor/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid DeleteFloorRequest request) {
        return JsonResult.success(true);
    }

}
