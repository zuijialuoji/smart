package com.smart.domain.sys;

import com.smart.core.domin.PersistentObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by 崔宗鲁 on 2018/4/28.
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Menu extends PersistentObject {
    // 父菜单ID，一级菜单为0
    private Long parentId;
    // 菜单名称
    private String name;
    // 菜单URL
    private String url;
    // 授权(多个用逗号分隔，如：user:list,user:create)
    private String perms;
    // 类型 0：目录 1：菜单 2：按钮
    private Integer type;
    /**
     * 功能
     */
    private String  functionId;
    // 菜单图标
    private String icon;
    // 排序
    private Integer orderNum;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    //是否是隐藏按钮 0否，1隐藏
    private Integer hide;
}
