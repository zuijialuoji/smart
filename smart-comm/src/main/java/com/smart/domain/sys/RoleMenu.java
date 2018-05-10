package com.smart.domain.sys;
import com.smart.core.domin.PersistentObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * Created by 崔宗鲁 on 2018/5/10.
 *
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class RoleMenu extends PersistentObject {

    public Long menuId;
    public Long roleId;


}

