package com.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.domain.post.PostMapper;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setTitle("The title of first post");
        params.setContent("The content of first post");
        params.setWriter("Tester");
        params.setNoticeYn(false);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("Total number of the entire post is:" + posts.size() + "." );
    }

    @Test
    void findById(){
        PostResponse post = postMapper.findById(1L);
        try{
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void update() {
        PostRequest params = new PostRequest();
        params.setId(1L);
        params.setTitle("edit the title of the first post");
        params.setContent("edit the content of the first post");
        params.setWriter("yoni");
        params.setNoticeYn(true);
        postMapper.update(params);

        PostResponse post = postMapper.findById(1L);
        try{
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete(){
        System.out.println("The total number of the entire post before deleting is :"
                + postMapper.findAll().size() + ".");
        postMapper.deleteById(1L);
        System.out.println("The total number of the entire post after deleting is :"
                + postMapper.findAll().size() + ".");
    }

}
