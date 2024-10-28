package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FendianEntity;
import java.util.Map;

/**
 * 分店 服务类
 * @since 2021-04-01
 */
public interface FendianService extends IService<FendianEntity> {

     PageUtils queryPage(Map<String, Object> params);

}