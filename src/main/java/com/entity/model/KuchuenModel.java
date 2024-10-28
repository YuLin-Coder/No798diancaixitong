package com.entity.model;

import com.entity.KuchuenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 库存表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-08
 */
public class KuchuenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 菜品名称 Search
     */
    private String name;


    /**
     * 库存数量
     */
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
