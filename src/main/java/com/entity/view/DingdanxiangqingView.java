package com.entity.view;

import com.entity.DingdanxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 订单详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-09
 */
@TableName("dingdanxiangqing")
public class DingdanxiangqingView extends DingdanxiangqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public DingdanxiangqingView() {

	}

	public DingdanxiangqingView(DingdanxiangqingEntity dingdanxiangqingEntity) {
		try {
			BeanUtils.copyProperties(this, dingdanxiangqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
