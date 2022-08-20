package com.catface.wms.service.warehouse;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;

/**
 * @author catface
 * @since 2022/8/20
 */
public interface WarehouseService {

    /**
     * 保存仓库
     *
     * @param entity 待保存的仓库实体
     */
    void save(Warehouse entity);

    /**
     * 删除仓库
     *
     * @param warehouseId 待删除仓库ID
     * @param clientId    执行删除动作的用户所属客户
     */
    void delete(Long warehouseId, Long clientId);

    /**
     * 分页查询仓库
     *
     * @param param 仓库名称,客户ID,分页信息
     * @return 仓库分页列表
     */
    Page<Warehouse> getOnePage(QueryWarehouseParam param);
}
