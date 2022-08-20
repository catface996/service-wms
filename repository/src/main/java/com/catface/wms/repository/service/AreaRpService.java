package com.catface.wms.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.param.QueryAreaParam;

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
    boolean existAreaByWarehouse(Long warehouseId);

    /**
     * 检查指定楼层下是否存在库区
     *
     * @param floorId 指定楼层ID
     * @return true:存在库区;false:不存在库区;
     */
    boolean existAreaByFloor(Long floorId);

    /**
     * 分页查询库区
     *
     * @param param 客户ID
     * @return 库区列表
     */
    Page<Area> queryOnePage(QueryAreaParam param);

}
