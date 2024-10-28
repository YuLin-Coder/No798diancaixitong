package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiushuiEntity;
import java.util.Map;

/**
 * 流水表 服务类
 * @since 2021-03-08
 */
public interface LiushuiService extends IService<LiushuiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}