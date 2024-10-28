package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CanzhuoEntity;
import java.util.Map;

/**
 * 餐桌表 服务类
 * @since 2021-03-08
 */
public interface CanzhuoService extends IService<CanzhuoEntity> {

     PageUtils queryPage(Map<String, Object> params);

}