package com.datehoer.blog.model.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "blog_comment", createIndex = true)
public class EsBlogComment {
    @Id
    private Integer id;
    @Field(type = FieldType.Integer)
    private Integer blogId;
    @Field(type = FieldType.Text)
    private String content;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Text)
    private String email;
    @Field(type = FieldType.Text)
    private String ip;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private String createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private String updateTime;
}
