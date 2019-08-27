package com.wzh.tools.utils.operatingbean;

import org.springframework.cglib.beans.BeanCopier;

public class BeanCopyUtils {
    /**
     * Java Bean 属性复制
     *
     * @param src
     * @param target
     */
    public static void cglibBeanCopier(Object src, Object target) {
        BeanCopier copier = BeanCopier.create(src.getClass(), target.getClass(), false);
        copier.copy(src, target, null);
    }


}
