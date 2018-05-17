package com.smart.comm.enums;

/**
 * Created by 崔宗鲁 on 2018/5/17.
 *
 * @Description:
 */
public enum TrueFalseEnum implements EnumItemable<TrueFalseEnum> {

    TRUE("是", true),
    FALSE("否", false);

    private String label;
    private Boolean value;

    private TrueFalseEnum(String label, Boolean value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return this.label;
    }

    public Boolean getValue() {
        return this.value;
    }
}
