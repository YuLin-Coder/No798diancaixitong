package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianjieEntity;
import java.util.Map;

/**
 * 简介 服务类
 * @since 2021-04-01
 */
public interface JianjieService extends IService<JianjieEntity> {

     PageUtils queryPage(Map<String, Object> params);

}