package com.dao;

import com.entity.DingdanxiangqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanxiangqingView;

/**
 * 订单详情 Dao 接口
 *
 * @since 2021-03-09
 */
public interface DingdanxiangqingDao extends BaseMapper<DingdanxiangqingEntity> {

   List<DingdanxiangqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
