package com.entity.view;

import com.entity.CaipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 菜品表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-08
 */
@TableName("caipin")
public class CaipinView extends CaipinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public CaipinView() {

	}
	private String name;
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CaipinView(CaipinEntity caipinEntity) {
		try {
			BeanUtils.copyProperties(this, caipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
