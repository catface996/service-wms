package com.catface.wms.service.area;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.wms.repository.entity.Area;
import com.catface.wms.repository.param.QueryAreaParam;

/**
 * @author catface
 * @since 2022/8/20
 */
public interface AreaService {

    /**
     * 保存库区
     *
     * @param entity 待保存的库区
     */
    void save(Area entity);

    /**
     * 删除库区
     *
     * @param areaId   待删除的库区ID
     * @param clientId 执行删除动作的客户ID
     */
    void delete(Long areaId, Long clientId);

    /**
     * 分页查询库区
     *
     * @param param 客户ID,仓库ID,楼层ID,库区名称,库区编码,分页信息
     * @return 分区列表
     */
    Page<Area> queryOnePage(QueryAreaParam param);
}
