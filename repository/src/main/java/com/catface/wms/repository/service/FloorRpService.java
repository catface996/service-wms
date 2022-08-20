package com.catface.wms.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.wms.repository.entity.Floor;

/**
 * <p>
 * 仓库楼层 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
public interface FloorRpService extends IService<Floor> {

    /**
     * 检查是否在指定仓库下创建了楼层
     *
     * @param warehouseId 仓库ID
     * @return 是否存在楼层
     */
    boolean existFloor(Long warehouseId);
}
