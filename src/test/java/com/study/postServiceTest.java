package com.study;

import com.study.domain.post.PostRequest;
import com.study.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class postServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save(){
        PostRequest params = new PostRequest();
        params.setTitle("The title of the first post");
        params.setContent("The content of the first post");
        params.setWriter("Tester");
        params.setNoticeYn(false);
        Long id = postService.savePost(params);
        System.out.println("The id of generated post :" + id);
    }
}
