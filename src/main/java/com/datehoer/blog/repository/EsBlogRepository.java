package com.datehoer.blog.repository;

import com.datehoer.blog.model.elasticsearch.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, Integer> {

}
