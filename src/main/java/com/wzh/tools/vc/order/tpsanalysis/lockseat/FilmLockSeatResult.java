package com.wzh.tools.vc.order.tpsanalysis.lockseat;

import java.util.List;

/**
 * @author wangzehui
 * @date 2018/6/25 20:37
 */

public class FilmLockSeatResult {


    /**
     * time : 1529926872
     * errno : 300001
     * error :
     * data : []
     */

    private int time;
    private int errno;
    private String error;
    private List<?> data;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
