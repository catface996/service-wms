package com.catface.wms.http.web.controller.warehouse.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.PageVO;
import com.catface.wms.http.web.controller.warehouse.request.GetWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.request.SaveWarehouseRequest;
import com.catface.wms.http.web.controller.warehouse.response.WarehouseResponse;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/20
 */
public class WarehouseWebConvert {

    private static final BeanCopier SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveWarehouseRequest.class, Warehouse.class, false);

    private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(Warehouse.class, WarehouseResponse.class, false);


    public static Warehouse convert(SaveWarehouseRequest request) {
        Warehouse entity = new Warehouse();
        SAVE_REQUEST_2_ENTITY.copy(request, entity, null);
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

    public static QueryWarehouseParam convert(GetWarehouseRequest request) {
        QueryWarehouseParam param = new QueryWarehouseParam();
        param.setClientId(request.getCtxClientId());
        param.setWarehouseName(request.getWarehouseName());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static WarehouseResponse convert(Warehouse entity) {
        WarehouseResponse response = new WarehouseResponse();
        ENTITY_2_RESPONSE.copy(entity, response, null);
        return response;
    }

    public static List<WarehouseResponse> convert(List<Warehouse> entities) {
        List<WarehouseResponse> list = new ArrayList<>();
        for (Warehouse entity : entities) {
            list.add(convert(entity));
        }
        return list;
    }

    public static PageVO<WarehouseResponse> convert(Page<Warehouse> page) {
        PageVO<WarehouseResponse> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        List<WarehouseResponse> list = convert(page.getRecords());
        pageVO.setRecords(list);
        return pageVO;
    }


}
