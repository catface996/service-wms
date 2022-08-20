package com.catface.wms.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.mapper.FloorMapper;
import com.catface.wms.repository.param.QueryFloorParam;
import com.catface.wms.repository.service.FloorRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 仓库楼层 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
@Slf4j
@Service
public class FloorRpServiceImpl extends ServiceImpl<FloorMapper, Floor> implements FloorRpService {

    /**
     * 检查是否在指定仓库下创建了楼层
     *
     * @param warehouseId 仓库ID
     * @return 是否存在楼层
     */
    @Override
    public boolean existFloor(Long warehouseId) {
        Floor entity = baseMapper.existFloor(warehouseId);
        return entity != null;
    }

    /**
     * 分页查询楼层
     *
     * @param param 客户ID,仓库ID,楼层名称,分页信息
     * @return 楼层列表
     */
    @Override
    public Page<Floor> queryOnePage(QueryFloorParam param) {
        List<Floor> list = baseMapper.selectOnePage(param);
        param.setRecords(list);
        return param;
    }
}
