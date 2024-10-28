package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanxiangqingEntity;
import java.util.Map;

/**
 * 订单详情 服务类
 * @since 2021-03-09
 */
public interface DingdanxiangqingService extends IService<DingdanxiangqingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}