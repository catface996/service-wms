package com.catface.wms.repository.service;

import com.catface.wms.repository.entity.Location;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库位 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
public interface LocationRpService extends IService<Location> {

    /**
     * 检查指定仓库下是否存在库位
     * @param warehouseId 指定的仓库ID
     * @return 库位
     */
    boolean existLocation(Long warehouseId);
}
