package com.smart.domain.customer;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.smart.base.myplus.SuperEntity;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/4/28.
 *
 * @Description:
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("cus_customer")
public class Customer extends SuperEntity<Customer> {


    // 用户名
    @TableField("customer_name")
    private String customerName;
    // 用户真实姓名
    private String name;
    // 密码
    private String password;
    // 部门
    @TableField("dept_id")
    private Long deptId;

  //  private String deptName;
    // 邮箱
    private String email;
    // 手机号
    private String mobile;
    // 状态 0:禁用，1:正常
    private Integer status;
    // 创建用户id
    @TableField("user_id_create")
    private Long userIdCreate;
    // 创建时间

    @TableField("gmt_create")
    private Date gmtCreate;
    // 修改时间

    @TableField("gmt_modified")
    private Date gmtModified;
    //角色
   // private List<Long> roleIds;
    //性别
    private Long sex;
    //出身日期

    private Date birth;
    //图片ID
    private Long picId;
    //现居住地

    @TableField("live_address")
    private String liveAddress;
    //爱好
    private String hobby;
    //省份
    private String province;
    //所在城市
    private String city;
    //所在地区
    private String district;

}
