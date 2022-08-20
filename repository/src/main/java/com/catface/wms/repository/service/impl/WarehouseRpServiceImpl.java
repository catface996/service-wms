package com.catface.wms.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.wms.repository.entity.Warehouse;
import com.catface.wms.repository.mapper.WarehouseMapper;
import com.catface.wms.repository.param.QueryWarehouseParam;
import com.catface.wms.repository.service.WarehouseRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 仓库 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
@Slf4j
@Service
public class WarehouseRpServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseRpService {

    /**
     * 分页查询仓库列表
     *
     * @param param 仓库名称,所属客户ID
     * @return 仓库列表
     */
    @Override
    public Page<Warehouse> queryOnePage(QueryWarehouseParam param) {
        List<Warehouse> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }
}
