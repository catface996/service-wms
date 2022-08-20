package com.catface.wms.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.wms.repository.entity.Area;

/**
 * <p>
 * 库区 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
public interface AreaRpService extends IService<Area> {

    /**
     * 检查指定的仓库下是否存在库区
     *
     * @param warehouseId 指定的仓库ID
     * @return true:存在库区;false:不存在库区;
     */
    boolean existArea(Long warehouseId);
}
