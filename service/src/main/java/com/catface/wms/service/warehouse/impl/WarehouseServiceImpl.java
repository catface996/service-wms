package com.catface.wms.service.warehouse.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryWarehouseParam;
import com.catface.wms.repository.service.AreaRpService;
import com.catface.wms.repository.service.FloorRpService;
import com.catface.wms.repository.service.LocationRpService;
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

    private final FloorRpService floorRpService;

    private final AreaRpService areaRpService;

    private final LocationRpService locationRpService;

    public WarehouseServiceImpl(WarehouseRpService warehouseRpService, FloorRpService floorRpService,
                                AreaRpService areaRpService, LocationRpService locationRpService) {
        this.warehouseRpService = warehouseRpService;
        this.floorRpService = floorRpService;
        this.areaRpService = areaRpService;
        this.locationRpService = locationRpService;
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

        // 检查待删除的仓库是否属于执行删除的客户
        Warehouse entity = warehouseRpService.getById(warehouseId);
        if (entity==null){
            log.warn("待删除的仓库不存在,仓库ID:{}",warehouseId);
            return;
        }
        Assert.state(entity.getClientId().equals(clientId),"禁止删除其他客户的仓库");

        // 检查仓库是否有创建楼层
        boolean existFloor = floorRpService.existFloor(warehouseId);
        Assert.state(!existFloor,"需删除仓库的楼层后,再进行仓库的删除");

        // 检查仓库是否有创建库区
        boolean existArea = areaRpService.existAreaByWarehouse(warehouseId);
        Assert.state(!existArea,"需删除仓库的库区后,再进行仓库的删除");

        // 检查仓库是否有创建库位
        boolean existLocation = locationRpService.existLocationByWarehouse(warehouseId);
        Assert.state(!existLocation,"需删除仓库的库位后,再进行仓库的删除");

        // 执行仓库删除动作
        warehouseRpService.removeById(warehouseId);

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
