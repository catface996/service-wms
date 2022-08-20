package com.catface.wms.service.area.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.param.QueryAreaParam;
import com.catface.wms.repository.service.AreaRpService;
import com.catface.wms.repository.service.FloorRpService;
import com.catface.wms.repository.service.LocationRpService;
import com.catface.wms.repository.service.WarehouseRpService;
import com.catface.wms.service.area.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/20
 */
@Slf4j
@Service
public class AreaServiceImpl implements AreaService {

    private final WarehouseRpService warehouseRpService;

    private final FloorRpService floorRpService;

    private final AreaRpService areaRpService;

    private final LocationRpService locationRpService;

    public AreaServiceImpl(WarehouseRpService warehouseRpService, FloorRpService floorRpService,
                           AreaRpService areaRpService, LocationRpService locationRpService) {
        this.warehouseRpService = warehouseRpService;
        this.floorRpService = floorRpService;
        this.areaRpService = areaRpService;
        this.locationRpService = locationRpService;
    }


    /**
     * 保存库区
     *
     * @param entity 待保存的库区
     */
    @Override
    public void save(Area entity) {

        // 检查所属仓库是否是属于当前客户
        Warehouse warehouse = warehouseRpService.getById(entity.getWarehouseId());
        Assert.notNull(warehouse, "库区所属仓库不存在");
        Assert.state(warehouse.getClientId().equals(entity.getClientId()), "禁止在其他客户的仓库中创建库区");

        // 检查楼层是否属于当前的客户
        if (entity.getFloorId() != null) {
            Floor floor = floorRpService.getById(entity.getFloorId());
            Assert.notNull(floor, "库区所属楼层不存在");
            Assert.state(floor.getClientId().equals(entity.getClientId()), "禁止在其他客户的楼层中创建库区");
            Assert.state(floor.getWarehouseId().equals(warehouse.getId()), "楼层所属仓库与所选仓库不一致");
        }

        // 检查区域所属客户是否与已经存在的区域的客户一致
        if (entity.getId() != null) {
            Area areaExist = areaRpService.getById(entity.getId());
            Assert.notNull(areaExist, "待更新的库区不存在");
            Assert.state(areaExist.getClientId().equals(entity.getClientId()), "禁止修改其他客户的库区");
        }

        // 执行保存或者更新库区
        areaRpService.saveOrUpdate(entity);
    }

    /**
     * 删除库区
     *
     * @param areaId   待删除的库区ID
     * @param clientId 执行删除动作的客户ID
     */
    @Override
    public void delete(Long areaId, Long clientId) {

        // 检查库区是否存在
        Area areaExist = areaRpService.getById(areaId);
        if (areaExist==null){
            log.warn("待删除的库区不存在,库区ID:{}",areaId);
            return;
        }

        // 检查待删除的库区是否属于当前操作的客户
        Assert.state(areaExist.getClientId().equals(clientId), "禁止删除其他客户的库区");

        // 检查当前库区是否有库位存在
        boolean existLocation = locationRpService.existLocationByArea(areaId);
        Assert.state(!existLocation, "删除库区上的库位后,再删除库区");

        // 执行删除动作
        areaRpService.removeById(areaId);
    }

    /**
     * 分页查询库区
     *
     * @param param 客户ID,仓库ID,楼层ID,库区名称,库区编码,分页信息
     * @return 分区列表
     */
    @Override
    public Page<Area> queryOnePage(QueryAreaParam param) {
        return areaRpService.queryOnePage(param);
    }
}
