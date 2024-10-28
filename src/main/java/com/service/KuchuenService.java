package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuchuenEntity;
import java.util.Map;

/**
 * 库存表 服务类
 * @since 2021-03-08
 */
public interface KuchuenService extends IService<KuchuenEntity> {

     PageUtils queryPage(Map<String, Object> params);

}