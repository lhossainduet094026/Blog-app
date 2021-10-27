package com.lokman.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.lokman.blog.models.Post;

@Repository
@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post, Long> {

}
