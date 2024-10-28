package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.YudingcanzhuoDao;
import com.entity.YudingcanzhuoEntity;
import com.service.YudingcanzhuoService;
import com.entity.view.YudingcanzhuoView;

/**
 * 预定餐桌表 服务实现类
 * @since 2021-03-08
 */
@Service("yudingcanzhuoService")
@Transactional
public class YudingcanzhuoServiceImpl extends ServiceImpl<YudingcanzhuoDao, YudingcanzhuoEntity> implements YudingcanzhuoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YudingcanzhuoView> page =new Query<YudingcanzhuoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
