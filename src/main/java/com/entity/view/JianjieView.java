package com.entity.view;

import com.entity.JianjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 简介
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-04-01
 */
@TableName("jianjie")
public class JianjieView extends JianjieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public JianjieView() {

	}

	public JianjieView(JianjieEntity jianjieEntity) {
		try {
			BeanUtils.copyProperties(this, jianjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
