package com.wzh.tools.utils.resultdata;

import java.io.Serializable;
import java.util.List;

/**
 * Created by VC.
 * 集合返回对象
 */
public class CollectionParam<T> extends ObjectParam  implements Serializable {
    private static final long serialVersionUID = -7643531561211268454L;
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
