package com.datehoer.blog.model.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("blog_comment")
public class EsBlogComment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 文章id
    private Integer blogId;
    // 父评论id, 默认为0, 共2级评论
    private Integer parentId;
    private String content;
    private String author;
    private String email;
    private String ip;
    private Date createTime;
    private Date updateTime;
}