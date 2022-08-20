package com.catface.wms.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.wms.repository.entity.Floor;
import com.catface.wms.repository.param.QueryFloorParam;

/**
 * <p>
 * 仓库楼层 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
public interface FloorRpService extends IService<Floor> {

    /**
     * 检查是否在指定仓库下创建了楼层
     *
     * @param warehouseId 仓库ID
     * @return 是否存在楼层
     */
    boolean existFloor(Long warehouseId);

    /**
     * 分页查询楼层
     *
     * @param param 客户ID,仓库ID,楼层名称,分页信息
     * @return 楼层列表
     */
    Page<Floor> queryOnePage(QueryFloorParam param);

}
