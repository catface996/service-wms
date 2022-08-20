package com.catface.wms.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.mapper.AreaMapper;
import com.catface.wms.repository.param.QueryAreaParam;
import com.catface.wms.repository.service.AreaRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 库区 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Slf4j
@Service
public class AreaRpServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaRpService {

    /**
     * 检查指定的仓库下是否存在库区
     *
     * @param warehouseId 指定的仓库ID
     * @return true:存在库区;false:不存在库区;
     */
    public boolean existAreaByWarehouse(Long warehouseId) {
        Area entity = baseMapper.existAreaByWarehouse(warehouseId);
        return entity != null;
    }

    /**
     * 检查指定楼层下是否存在库区
     *
     * @param floorId 指定楼层ID
     * @return true:存在库区;false:不存在库区;
     */
    @Override
    public boolean existAreaByFloor(Long floorId) {
        Area entity = baseMapper.existAreaByFloor(floorId);
        return entity != null;
    }

    /**
     * 分页查询库区
     *
     * @param param 客户ID
     * @return 库区列表
     */
    @Override
    public Page<Area> queryOnePage(QueryAreaParam param) {
        List<Area> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }
}
