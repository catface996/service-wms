package com.catface.wms.service.warehouse.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;
import com.catface.wms.repository.service.WarehouseRpService;
import com.catface.wms.service.warehouse.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/20
 */
@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRpService warehouseRpService;

    public WarehouseServiceImpl(WarehouseRpService warehouseRpService) {
        this.warehouseRpService = warehouseRpService;
    }


    /**
     * 保存仓库
     *
     * @param entity 待保存的仓库实体
     */
    @Override
    public void save(Warehouse entity) {
        // 如果是更新,检查clientId是否一致
        if (entity.getId() != null) {
            Warehouse entityExist = warehouseRpService.getById(entity.getId());
            Assert.state(entityExist.getClientId().equals(entity.getClientId()), "禁止修改其他客户的仓库信息");
        }
        warehouseRpService.saveOrUpdate(entity);
    }

    /**
     * 删除仓库
     *
     * @param warehouseId 待删除仓库ID
     * @param clientId    执行删除动作的用户所属客户
     */
    @Override
    public void delete(Long warehouseId, Long clientId) {

    }

    /**
     * 分页查询仓库
     *
     * @param param 仓库名称,客户ID,分页信息
     * @return 仓库分页列表
     */
    @Override
    public Page<Warehouse> getOnePage(QueryWarehouseParam param) {
        return warehouseRpService.queryOnePage(param);
    }
}
