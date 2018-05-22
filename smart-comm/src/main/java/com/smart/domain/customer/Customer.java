package com.smart.domain.customer;

import com.smart.core.domin.PersistentObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class Customer  extends PersistentObject{


    /**
     * 用户名
     */
    private String customerName;

    /**
     *
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     *
     */
    private Long deptId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态 0:禁用，1:正常
     */
    private  Integer   status;

    /**
     * 创建用户id
     */
    private Long userIdCreate;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 性别
     */
    private Long sex;

    /**
     * 出身日期
     */
    private Date birth;

    /**
     *
     */
    private Long picId;

    /**
     * 现居住地
     */
    private String liveAddress;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在地区
     */
    private String district;

    /**
     *
     */
    private Long tenantId;
}
