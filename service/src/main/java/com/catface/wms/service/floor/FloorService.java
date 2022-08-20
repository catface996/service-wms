package com.catface.wms.service.floor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.param.QueryFloorParam;

/**
 * @author catface
 * @since 2022/8/20
 */
public interface FloorService {

    /**
     * 保存楼层
     *
     * @param entity 待保存的楼层
     */
    void save(Floor entity);

    /**
     * 删除楼层
     *
     * @param floorId  待删除的楼层ID
     * @param clientId 执行删除的客户ID
     */
    void delete(Long floorId, Long clientId);

    /**
     * 分页查询楼层
     *
     * @param param 客户ID,仓库ID,楼层名称,分页信息
     * @return 楼层列表
     */
    Page<Floor> queryOnePage(QueryFloorParam param);
}
