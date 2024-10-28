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
 * 预定餐桌表
 *
 * @email
 * @date 2021-03-08
 */
@TableName("yudingcanzhuo")
public class YudingcanzhuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YudingcanzhuoEntity() {

    }

    public YudingcanzhuoEntity(T t) {
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
    @TableField(value = "cz_types")
    private Integer czTypes;


    /**
     * 预定用户
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


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
    public Integer getCzTypes() {
        return czTypes;
    }


    /**
	 * 获取：餐桌名称
	 */

    public void setCzTypes(Integer czTypes) {
        this.czTypes = czTypes;
    }
    /**
	 * 设置：预定用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：预定用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
    return "Yudingcanzhuo{" +
            "id=" + id +
            ", czTypes=" + czTypes +
            ", yhTypes=" + yhTypes +
            ", createTime=" + createTime +
    "}";
    }
    }
