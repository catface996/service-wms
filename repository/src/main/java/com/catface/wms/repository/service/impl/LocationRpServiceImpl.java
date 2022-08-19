package com.catface.wms.repository.service.impl;

import com.catface.wms.repository.entity.Location;
import com.catface.wms.repository.mapper.LocationMapper;
import com.catface.wms.repository.service.LocationRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库位 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-19
 */
@Service
public class LocationRpServiceImpl extends ServiceImpl<LocationMapper, Location> implements LocationRpService {

}
