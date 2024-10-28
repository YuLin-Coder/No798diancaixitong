package com.entity.vo;

import com.entity.KuchuenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 库存表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-08
 */
@TableName("kuchuen")
public class KuchuenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 菜品名称 Search
     */

    @TableField(value = "name")
    private String name;


    /**
     * 库存数量
     */

    @TableField(value = "number")
    private Integer number;


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
	 * 设置：菜品名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：菜品名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：库存数量
	 */
    public Integer getNumber() {
        return number;
    }


    /**
	 * 获取：库存数量
	 */

    public void setNumber(Integer number) {
        this.number = number;
    }

}
