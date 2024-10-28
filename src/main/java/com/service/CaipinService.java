package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaipinEntity;
import java.util.Map;

/**
 * 菜品表 服务类
 * @since 2021-03-08
 */
public interface CaipinService extends IService<CaipinEntity> {

     PageUtils queryPage(Map<String, Object> params);

}