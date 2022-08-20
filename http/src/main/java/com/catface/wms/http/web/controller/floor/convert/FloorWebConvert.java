package com.catface.wms.http.web.controller.floor.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.PageVO;
import com.catface.wms.http.web.controller.floor.request.GetFloorRequest;
import com.catface.wms.http.web.controller.floor.request.SaveFloorRequest;
import com.catface.wms.http.web.controller.floor.response.FloorResponse;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.param.QueryFloorParam;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/20
 */
public class FloorWebConvert {

    private final static BeanCopier FLOOR_SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveFloorRequest.class, Floor.class, false);

    private final static BeanCopier FLOOR_ENTITY_2_RESPONSE = BeanCopier.create(Floor.class, FloorResponse.class, false);

    public static Floor convert(SaveFloorRequest request) {
        Floor entity = new Floor();
        FLOOR_SAVE_REQUEST_2_ENTITY.copy(request, entity, null);
        Date date = DateTime.now().toDate();
        if (entity.getId() == null) {
            entity.setCreator(request.getCtxUserId());
            entity.setCreated(date);
        }
        entity.setModifier(request.getCtxUserId());
        entity.setUpdated(date);
        entity.setClientId(request.getCtxClientId());
        return entity;
    }

    public static QueryFloorParam convert(GetFloorRequest request) {
        QueryFloorParam param = new QueryFloorParam();
        param.setClientId(request.getCtxClientId());
        param.setWarehouseId(request.getWarehouseId());
        param.setFloorName(request.getFloorName());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static FloorResponse convert(Floor entity) {
        FloorResponse response = new FloorResponse();
        FLOOR_ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<FloorResponse> convert(List<Floor> entities) {
        List<FloorResponse> list = new ArrayList<>();
        for (Floor entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<FloorResponse> convert(Page<Floor> page) {
        PageVO<FloorResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<FloorResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }
}
