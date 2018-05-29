package com.smart.domain.sys;

import com.smart.core.domin.PersistentObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by 崔宗鲁 on 2018/5/4.
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class UserRole  extends PersistentObject {
    private Long userId;
    private Long roleId;
    private String appCode;

}
