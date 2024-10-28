package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 餐桌表
 *
 * @email
 * @date 2021-03-08
 */
@TableName("canzhuo")
public class CanzhuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public CanzhuoEntity() {

    }

    public CanzhuoEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 餐桌名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 餐桌位置
     */
    @TableField(value = "tableLocation")

    private String tableLocation;


    /**
     * 是否预定
     */
    @TableField(value = "sf_types")

    private Integer sfTypes;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：餐桌名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：餐桌名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：餐桌位置
	 */
    public String getTableLocation() {
        return tableLocation;
    }


    /**
	 * 获取：餐桌位置
	 */

    public void setTableLocation(String tableLocation) {
        this.tableLocation = tableLocation;
    }
    /**
	 * 设置：是否预定
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否预定
	 */

    public void setSfTypes(Integer sfTypes) {
        this.sfTypes = sfTypes;
    }

    @Override
    public String toString() {
    return "Canzhuo{" +
            "id=" + id +
            ", name=" + name +
            ", tableLocation=" + tableLocation +
            ", sfTypes=" + sfTypes +
    "}";
    }
    }
