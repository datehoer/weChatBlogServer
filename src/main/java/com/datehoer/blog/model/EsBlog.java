package com.datehoer.blog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "blog", createIndex = true)
public class EsBlog {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String summary;
    @Field(type = FieldType.Text)
    private String content;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date updateTime;
}
