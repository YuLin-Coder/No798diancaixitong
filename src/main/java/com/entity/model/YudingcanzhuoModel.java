package com.entity.model;

import com.entity.YudingcanzhuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预定餐桌表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-08
 */
public class YudingcanzhuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 餐桌名称
     */
    private Integer czTypes;


    /**
     * 预定用户
     */
    private Integer yhTypes;


    /**
     * 预定时间 Search
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 设置：预定时间 Search
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预定时间 Search
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
