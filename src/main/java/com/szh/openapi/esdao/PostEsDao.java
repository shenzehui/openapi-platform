package com.szh.openapi.esdao;

import com.szh.openapi.model.dto.post.PostEsDTO;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 帖子 ES 操作
 *
 * @author szh
 */
public interface PostEsDao extends ElasticsearchRepository<PostEsDTO, Long> {

    List<PostEsDTO> findByUserId(Long userId);
}