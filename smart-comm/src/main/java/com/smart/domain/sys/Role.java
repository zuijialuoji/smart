package com.smart.domain.sys;

import com.smart.core.domin.PersistentObject;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 崔宗鲁 on 2018/4/28.
 *
 * @Description:
 */
@Data
public class Role extends PersistentObject{

    private String roleName;
    private String roleSign;
    private String remark;
    private Long userIdCreate;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private List<Long> menuIds;

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + getId() +
                ", roleName='" + roleName + '\'' +
                ", roleSign='" + roleSign + '\'' +
                ", remark='" + remark + '\'' +
                ", userIdCreate=" + userIdCreate +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", menuIds=" + menuIds +
                '}';
    }
}
