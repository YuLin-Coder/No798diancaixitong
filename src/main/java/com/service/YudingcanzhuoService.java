package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YudingcanzhuoEntity;
import java.util.Map;

/**
 * 预定餐桌表 服务类
 * @since 2021-03-08
 */
public interface YudingcanzhuoService extends IService<YudingcanzhuoEntity> {

     PageUtils queryPage(Map<String, Object> params);

}