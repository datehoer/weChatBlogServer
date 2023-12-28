package com.datehoer.blog.model.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("blog")
public class EsBlog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String summary;
    private String content;
    private Integer readSize;
    private Integer commentSize;
    private String tags;
    private String author;
    private Date createTime;
    private Date updateTime;
}