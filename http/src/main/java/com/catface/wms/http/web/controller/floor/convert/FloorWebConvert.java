package com.catface.wms.http.web.controller.floor.convert;

import com.catface.wms.http.web.controller.floor.request.SaveFloorRequest;
import com.catface.wms.repository.entity.Floor;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author catface
 * @since 2022/8/20
 */
public class FloorWebConvert {

    private final static BeanCopier SAVE_REQUEST_2_ENTITY = BeanCopier.create(SaveFloorRequest.class, Floor.class, false);


}
