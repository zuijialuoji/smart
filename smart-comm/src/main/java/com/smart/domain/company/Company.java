package com.smart.domain.company;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.util.Date;

/**
 * Created by 崔宗鲁 on 2018/5/17.
 *
 * @Description:
 */
@SuppressWarnings("serial")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("com_company")
public class Company {


    /**
     * 编码
     */
    private String code;

    /**
     *
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 法人证件号码
     */
    private String legalNumber;

    /**
     * 证件照片
     */
    private String documentPhoto;

    /**
     * 营业执照号码
     */
    private String busLiceNumber;

    /**
     * 营业执照号码
     */
    private String busLicePhoto;

    /**
     * 企业电话
     */
    private String enterprisePhone;

    /**
     * 接入方式
     */
    private String accessMode;

    /**
     * 区域编码
     */
    private String regionCoding;

    /**
     * 企业名
     */
    private String enterpriseName;

    /**
     * 企业地址
     */
    private String enterpriseAddress;

    /**
     * 企业联系人
     */
    private String contacts;

    /**
     * 企业联系人地址
     */
    private String contactsAddress;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 审核未通过原因
     */
    private String theReason;

    /**
     * 审核人
     */
    private String auditPerson;

    /**
     * 审核时间
     */
    private Date auditTime;

    /**
     * 描述
     */
    private String describe;

    /**
     * 首页
     */
    private String homePage;

    /**
     * 是否有效
     */
    private String isItValid;

    /**
     * 状态 0:禁用，1:正常
     */
    private String status;

    /**
     * 创建人
     */
    private String creUser;

    /**
     * 修改人
     */
    private String updUser;

    /**
     * 创建时间
     */
    private Date creDate;

    /**
     * 修改时间
     */
    private Date updDate;
}
