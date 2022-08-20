package com.catface.wms.http.web.controller.area;

import com.catface.common.model.JsonResult;
import com.catface.common.model.PageVO;
import com.catface.wms.http.config.swagger.SwaggerTagConst;
import com.catface.wms.http.web.controller.area.request.DeleteAreaRequest;
import com.catface.wms.http.web.controller.area.request.GetAreaRequest;
import com.catface.wms.http.web.controller.area.request.SaveAreaRequest;
import com.catface.wms.http.web.controller.area.response.AreaResponse;
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
@Api(tags = {SwaggerTagConst.AREA})
@Slf4j
@RestController
public class AreaController {

    @ApiOperation(value = "保存库区")
    @PostMapping(value = "/public/area/save")
    public JsonResult<Boolean> save(@RequestBody @Valid SaveAreaRequest request) {
        return JsonResult.success();
    }

    @ApiOperation(value = "分页查询库区")
    @PostMapping(value = "/public/area/getOnePage")
    public JsonResult<PageVO<AreaResponse>> getOnePage(@RequestBody @Valid GetAreaRequest request) {
        return JsonResult.success();
    }

    @ApiOperation(value = "删除库区")
    @PostMapping(value = "/public/area/delete")
    public JsonResult<Boolean> delete(@RequestBody @Valid DeleteAreaRequest request) {
        return JsonResult.success();
    }
}
