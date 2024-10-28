package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.DingdanxiangqingDao;
import com.entity.DingdanxiangqingEntity;
import com.service.DingdanxiangqingService;
import com.entity.view.DingdanxiangqingView;

/**
 * 订单详情 服务实现类
 * @since 2021-03-09
 */
@Service("dingdanxiangqingService")
@Transactional
public class DingdanxiangqingServiceImpl extends ServiceImpl<DingdanxiangqingDao, DingdanxiangqingEntity> implements DingdanxiangqingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<DingdanxiangqingView> page =new Query<DingdanxiangqingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
