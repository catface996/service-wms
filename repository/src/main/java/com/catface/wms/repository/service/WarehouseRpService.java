package com.catface.wms.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;

/**
 * <p>
 * 仓库 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
public interface WarehouseRpService extends IService<Warehouse> {

    /**
     * 分页查询仓库列表
     *
     * @param param 仓库名称,所属客户ID
     * @return 仓库列表
     */
    Page<Warehouse> queryOnePage(QueryWarehouseParam param);
}
