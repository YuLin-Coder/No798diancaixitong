package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.CanzhuoEntity;
import com.service.CanzhuoService;
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

import com.entity.YudingcanzhuoEntity;

import com.service.YudingcanzhuoService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 预定餐桌表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-08
*/
@RestController
@Controller
@RequestMapping("/yudingcanzhuo")
public class YudingcanzhuoController {
    private static final Logger logger = LoggerFactory.getLogger(YudingcanzhuoController.class);

    @Autowired
    private CanzhuoService canzhuoService;

    @Autowired
    private YudingcanzhuoService yudingcanzhuoService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(!request.getSession().getAttribute("role").equals("管理员")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = yudingcanzhuoService.queryPage(params);
        }else{
            page = yudingcanzhuoService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YudingcanzhuoEntity yudingcanzhuo = yudingcanzhuoService.selectById(id);
        if(yudingcanzhuo!=null){
            return R.ok().put("data", yudingcanzhuo);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YudingcanzhuoEntity yudingcanzhuo, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YudingcanzhuoEntity> queryWrapper = new EntityWrapper<YudingcanzhuoEntity>()
            .eq("cz_types", yudingcanzhuo.getCzTypes())
            .eq("yh_types", yudingcanzhuo.getYhTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YudingcanzhuoEntity yudingcanzhuoEntity = yudingcanzhuoService.selectOne(queryWrapper);
        if(yudingcanzhuoEntity==null){
            yudingcanzhuoService.insert(yudingcanzhuo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YudingcanzhuoEntity yudingcanzhuo, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YudingcanzhuoEntity> queryWrapper = new EntityWrapper<YudingcanzhuoEntity>()
            .notIn("id",yudingcanzhuo.getId())
            .eq("cz_types", yudingcanzhuo.getCzTypes())
            .eq("yh_types", yudingcanzhuo.getYhTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YudingcanzhuoEntity yudingcanzhuoEntity = yudingcanzhuoService.selectOne(queryWrapper);
        if(yudingcanzhuoEntity==null){
            yudingcanzhuoService.updateById(yudingcanzhuo);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    //canzhuoService

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(Integer ids){
        YudingcanzhuoEntity yudingcanzhuoEntity = yudingcanzhuoService.selectById(ids);
        if(yudingcanzhuoEntity == null){
            return R.error();
        }
        CanzhuoEntity canzhuoEntity = canzhuoService.selectById(yudingcanzhuoEntity.getCzTypes());
        if(canzhuoEntity == null){
            return R.error();
        }
        canzhuoEntity.setSfTypes(2);
        canzhuoService.updateById(canzhuoEntity);
        yudingcanzhuoService.deleteById(ids);
        return R.ok();
    }
}

