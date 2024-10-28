package com.entity.view;

import com.entity.KuchuenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 库存表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-08
 */
@TableName("kuchuen")
public class KuchuenView extends KuchuenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KuchuenView() {

	}

	public KuchuenView(KuchuenEntity kuchuenEntity) {
		try {
			BeanUtils.copyProperties(this, kuchuenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
