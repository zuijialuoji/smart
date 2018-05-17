package com.smart.comm.enums;

/**
 * Created by 崔宗鲁 on 2018/5/17.
 *
 * @Description:键值对存储模型
 */
public class Item implements Itemable {

    private String label;
    private Object value;

    public Item() {
    }

    public Item(String label, Object value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
