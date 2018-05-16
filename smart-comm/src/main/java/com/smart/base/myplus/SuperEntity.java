package com.smart.base.myplus;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * Created by 崔宗鲁 on 2018/5/15.
 *
 * @Description:
 */
public class SuperEntity<T extends Model> extends Model<T> {
    /**
     * 主键ID , 这里故意演示注解可以无
     */
    @TableId("id")
    private Long id;



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
