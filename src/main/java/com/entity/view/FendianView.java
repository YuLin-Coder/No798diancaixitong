package com.entity.view;

import com.entity.FendianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 分店
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-04-01
 */
@TableName("fendian")
public class FendianView extends FendianEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public FendianView() {

	}

	public FendianView(FendianEntity fendianEntity) {
		try {
			BeanUtils.copyProperties(this, fendianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
