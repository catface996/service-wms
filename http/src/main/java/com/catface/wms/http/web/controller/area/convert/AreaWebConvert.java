package com.catface.wms.http.web.controller.area.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.PageVO;
import com.catface.wms.http.web.controller.area.request.GetAreaRequest;
import com.catface.wms.http.web.controller.area.request.SaveAreaRequest;
import com.catface.wms.http.web.controller.area.response.AreaResponse;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.param.QueryAreaParam;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/20
 */
public class AreaWebConvert {

    private static final BeanCopier SAVE_AREA_REQUEST_2_ENTITY = BeanCopier.create(SaveAreaRequest.class, Area.class, false);

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(Area.class, AreaResponse.class, false);

    public static Area convert(SaveAreaRequest request) {
        Area entity = new Area();
        SAVE_AREA_REQUEST_2_ENTITY.copy(request, entity, null);
        Date date = DateTime.now().toDate();
        if (entity.getId() == null) {
            entity.setCreated(date);
            entity.setCreator(request.getCtxUserId());
        }
        entity.setModifier(request.getCtxUserId());
        entity.setUpdated(date);
        entity.setClientId(request.getCtxClientId());
        return entity;
    }

    public static QueryAreaParam convert(GetAreaRequest request) {
        QueryAreaParam param = new QueryAreaParam();
        param.setClientId(request.getCtxClientId());
        param.setWarehouseId(request.getWarehouseId());
        param.setFloorId(request.getFloorId());
        param.setAreaName(request.getAreaName());
        param.setAreaCode(request.getAreaCode());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static AreaResponse convert(Area entity) {
        AreaResponse response = new AreaResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<AreaResponse> convert(List<Area> entities) {
        List<AreaResponse> list = new ArrayList<>();
        for (Area entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<AreaResponse> convert(Page<Area> page) {
        PageVO<AreaResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<AreaResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }

}
