package com.study.domain.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    /**
     * Save post
     * @param params - information of post
     */
    void save (PostRequest params);

    /**
     * Check the detail information of post
     * @param id -PK
     * @return detail information of post
     */
    PostResponse findById(Long id);

    /**
     * Edit post
     * @param params - information of post
     */
    void update(PostRequest params);

    /**
     * Delete post
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * Search post list
     * @return post list
     */
    List<PostResponse> findAll();

    /**
     * Count posts
     * @return number of post
     */
    int count();
}
