package com.study.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * Save post
     * @param params the information of post
     * @return Generated PK
     */
    @Transactional
    public Long savePost (final PostRequest params){
        postMapper.save(params);
        return params.getId();
    }

    /**
     * Search the detail information of post
     * @param id -PK
     * @return the detail information
     */
    public PostResponse findPostById(final Long id){
        return postMapper.findById(id);
    }

    /**
     * Edit post
     * @param params -the information of post
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params){
        postMapper.update(params);
        return params.getId();
    }

    /**
     * Delete post
     * @param id -PK
     * @return PK
     */
    @Transactional
    public Long deletePost(final Long id){
        postMapper.deleteById(id);
        return id;
    }

    /**
     * Search the list of post
     * @return post list
     */
    @Transactional
    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    };
    }
