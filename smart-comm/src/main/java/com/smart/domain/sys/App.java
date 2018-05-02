package com.smart.domain.sys;

import com.smart.core.domin.PersistentObject;
import lombok.Data;

import java.util.Date;

/**
 * Created by 崔宗鲁 on 2018/4/28.
 *
 * @Description:
 */
@Data
public class App extends PersistentObject {
    /** 名称 */
    private String name;
    /** 编码  */
    private String code;
    /** 排序 */
    private Integer sort = Integer.valueOf(1);
    /** 创建时间 */

    private Date createTime;
    /** 是否启用 */
    private Boolean isEnable = Boolean.valueOf(true);
}
