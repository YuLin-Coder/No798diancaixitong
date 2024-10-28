package com.entity.vo;

import com.entity.CanzhuoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 餐桌表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-08
 */
@TableName("canzhuo")
public class CanzhuoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 餐桌名称 Search
     */

    @TableField(value = "name")
    private String name;


    /**
     * 餐桌位置
     */

    @TableField(value = "tableLocation")
    private String tableLocation;


    /**
     * 是否预定 Search
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
	 * 设置：餐桌名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：餐桌名称 Search
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
	 * 设置：是否预定 Search
	 */
    public Integer getSfTypes() {
        return sfTypes;
    }


    /**
	 * 获取：是否预定 Search
	 */

    public void setSfTypes(Integer sfTypes) {
        this.sfTypes = sfTypes;
    }

}
