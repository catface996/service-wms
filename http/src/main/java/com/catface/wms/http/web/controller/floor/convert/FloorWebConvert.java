package com.catface.wms.http.web.controller.floor.convert;

import com.catface.wms.http.web.controller.floor.request.SaveFloorRequest;
import com.catface.wms.repository.entity.Floor;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/20
 */
public class FloorWebConvert {

    private final static BeanCopier FLOOR_SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveFloorRequest.class, Floor.class, false);


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
}
