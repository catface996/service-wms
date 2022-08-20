package com.catface.wms.service.floor.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryFloorParam;
import com.catface.wms.repository.service.AreaRpService;
import com.catface.wms.repository.service.FloorRpService;
import com.catface.wms.repository.service.LocationRpService;
import com.catface.wms.repository.service.WarehouseRpService;
import com.catface.wms.service.floor.FloorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/20
 */
@Slf4j
@Service
public class FloorServiceImpl implements FloorService {

    private final WarehouseRpService warehouseRpService;

    private final FloorRpService floorRpService;

    private final AreaRpService areaRpService;

    private final LocationRpService locationRpService;

    public FloorServiceImpl(WarehouseRpService warehouseRpService, FloorRpService floorRpService,
                            AreaRpService areaRpService, LocationRpService locationRpService) {
        this.warehouseRpService = warehouseRpService;
        this.floorRpService = floorRpService;
        this.areaRpService = areaRpService;
        this.locationRpService = locationRpService;
    }

    /**
     * 保存楼层
     *
     * @param entity 待保存的楼层
     */
    @Override
    public void save(Floor entity) {

        if (entity.getId() != null) {
            Floor entityExist = floorRpService.getById(entity.getId());
            // 如果是更新操作,检查原楼层所属客户ID与当前客户ID是否一致
            Assert.state(entityExist.getClientId().equals(entity.getClientId()), "禁止修改其他客户的楼层");
        }

        // 检查所属仓库的客户ID是否与当前客户ID一致
        if (entity.getWarehouseId() != null) {
            Warehouse warehouse = warehouseRpService.getById(entity.getWarehouseId());
            Assert.notNull(warehouse,"楼层所属仓库不存在");
            Assert.state(warehouse.getClientId().equals(entity.getClientId()), "禁止使用其他客户的仓库");
        }

        // 执行保存动作
        floorRpService.saveOrUpdate(entity);
    }

    /**
     * 删除楼层
     *
     * @param floorId  待删除的楼层ID
     * @param clientId 执行删除的客户ID
     */
    @Override
    public void delete(Long floorId, Long clientId) {

    }

    /**
     * 分页查询楼层
     *
     * @param param 客户ID,仓库ID,楼层名称,分页信息
     * @return 楼层列表
     */
    @Override
    public Page<Floor> queryOnePage(QueryFloorParam param) {
        return null;
    }
}
