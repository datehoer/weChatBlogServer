package com.datehoer.blog;

import com.datehoer.blog.model.EsBlog;
import com.datehoer.blog.repository.EsBlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private EsBlogRepository esBlogRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Test
    void contextLoads() {
    }
    @Test
    void testEsBlogRepository() {
        EsBlog esBlog = new EsBlog();
        esBlog.setId("1");
        esBlog.setTitle("title");
        esBlog.setSummary("summary");
        esBlog.setContent("content");
        esBlog.setAuthor("author");
        esBlogRepository.save(esBlog);
    }
}
