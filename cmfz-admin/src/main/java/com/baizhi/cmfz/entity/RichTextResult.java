package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 文章编辑时，用于图片的上传的实体类，包含上传成功状况、上传的图片内容
 * Created by 邵迪 on 2018/7/8.
 */
@Component
public class RichTextResult implements Serializable{

    private Integer errno;

    private List<String> data;

    public RichTextResult() {
    }

    public RichTextResult(Integer errno, List<String> data) {
        this.errno = errno;
        this.data = data;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RichTextResult{" +
                "errno=" + errno +
                ", data=" + data +
                '}';
    }
}
