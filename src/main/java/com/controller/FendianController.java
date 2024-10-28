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

import com.entity.FendianEntity;

import com.service.FendianService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 分店
 * 后端接口
 * @author
 * @email
 * @date 2021-04-01
*/
@RestController
@Controller
@RequestMapping("/fendian")
public class FendianController {
    private static final Logger logger = LoggerFactory.getLogger(FendianController.class);

    @Autowired
    private FendianService fendianService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = fendianService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        FendianEntity fendian = fendianService.selectById(id);
        if(fendian!=null){
            return R.ok().put("data", fendian);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FendianEntity fendian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<FendianEntity> queryWrapper = new EntityWrapper<FendianEntity>()
            .eq("name", fendian.getName())
            .eq("dizhi", fendian.getDizhi())
            .eq("dianzhang", fendian.getDianzhang())
            .eq("phoen", fendian.getPhoen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FendianEntity fendianEntity = fendianService.selectOne(queryWrapper);
        if("".equals(fendian.getImgPhoto()) || "null".equals(fendian.getImgPhoto())){
            fendian.setImgPhoto(null);
        }
        if(fendianEntity==null){
            fendianService.insert(fendian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FendianEntity fendian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<FendianEntity> queryWrapper = new EntityWrapper<FendianEntity>()
            .notIn("id",fendian.getId())
            .eq("name", fendian.getName())
            .eq("dizhi", fendian.getDizhi())
            .eq("dianzhang", fendian.getDianzhang())
            .eq("phoen", fendian.getPhoen())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FendianEntity fendianEntity = fendianService.selectOne(queryWrapper);
        if("".equals(fendian.getImgPhoto()) || "null".equals(fendian.getImgPhoto())){
                fendian.setImgPhoto(null);
        }
        if(fendianEntity==null){
            fendianService.updateById(fendian);//根据id更新
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
        fendianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

