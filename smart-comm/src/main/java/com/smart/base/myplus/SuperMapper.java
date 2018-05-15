package com.smart.base.myplus;

/**
 * Created by 崔宗鲁 on 2018/5/15.
 *
 * @Description:
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 演示 mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface SuperMapper<T> extends BaseMapper<T> {

    // 这里可以放一些公共的方法
}