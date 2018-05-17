package com.smart.comm.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/5/17.
 *
 * @Description:枚举工具类
 */

public class EnumHelper {
    public static <E extends EnumItemable<?>> E get(Class<E> enumType, String label) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getLabel().equals(label)) {
                return e;
            }
        }
        return null;
    }

    public static <E extends EnumItemable<?>> String getValue(Class<E> enumType, String label) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getLabel().equals(label)) {
                return e.getValue().toString();
            }
        }
        return null;
    }

    public static <E extends EnumItemable<?>> String getLabel(Class<E> enumType, Object value) {
        for (E e : enumType.getEnumConstants()) {
            if (e.getValue().equals(value)) {
                return e.getLabel();
            }
        }
        return null;
    }

    public static <E extends EnumItemable<?>> List<Item> getSelectItemList(Class<E> enumType) {
        List<Item> list = new ArrayList<Item>();
        for (E e : enumType.getEnumConstants()) {
            list.add(new Item(e.getLabel(), e.getValue()));
        }
        return list;
    }
}
