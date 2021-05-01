package com.graphql.sample.boot;

import static java.util.Collections.singletonList;

import graphql.kickstart.tools.GraphQLResolver;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class PostResolver implements GraphQLResolver<Post> {

  private final Map<Long, List<Comment>> comments = new HashMap<>();

  PostResolver() {
    comments.put(1L, singletonList(new Comment(1L, "Some comment")));
  }

  @SneakyThrows
  public List<Comment> getComments(Post post) {
    Thread.sleep(1000);
    log.info("Return comments");
    return Optional.ofNullable(comments.get(post.getId())).orElseGet(Collections::emptyList);
  }
}
