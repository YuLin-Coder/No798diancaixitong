package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YonghuEntity;
import java.util.Map;

/**
 * 用户表 服务类
 * @since 2021-03-08
 */
public interface YonghuService extends IService<YonghuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}