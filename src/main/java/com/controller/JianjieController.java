package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JianjieEntity;

import com.service.JianjieService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 简介
 * 后端接口
 * @author
 * @email
 * @date 2021-04-01
*/
@RestController
@Controller
@RequestMapping("/jianjie")
public class JianjieController {
    private static final Logger logger = LoggerFactory.getLogger(JianjieController.class);

    @Autowired
    private JianjieService jianjieService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = jianjieService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JianjieEntity jianjie = jianjieService.selectById(id);
        if(jianjie!=null){
            return R.ok().put("data", jianjie);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JianjieEntity jianjie, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<JianjieEntity> queryWrapper = new EntityWrapper<JianjieEntity>()
            .eq("name", jianjie.getName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianjieEntity jianjieEntity = jianjieService.selectOne(queryWrapper);
        if(jianjieEntity==null){
            jianjieService.insert(jianjie);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianjieEntity jianjie, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JianjieEntity> queryWrapper = new EntityWrapper<JianjieEntity>()
            .notIn("id",jianjie.getId())
            .eq("name", jianjie.getName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianjieEntity jianjieEntity = jianjieService.selectOne(queryWrapper);
        if(jianjieEntity==null){
            jianjieService.updateById(jianjie);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        jianjieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

