package com.entity.view;

import com.entity.LiushuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 流水表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-08
 */
@TableName("liushui")
public class LiushuiView extends LiushuiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public LiushuiView() {

	}

	public LiushuiView(LiushuiEntity liushuiEntity) {
		try {
			BeanUtils.copyProperties(this, liushuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
