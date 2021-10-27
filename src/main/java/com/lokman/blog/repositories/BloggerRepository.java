package com.lokman.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.lokman.blog.models.Blogger;

@Repository
@EnableJpaRepositories
public interface BloggerRepository extends JpaRepository<Blogger, Long> {

	Optional<Blogger> findByfirstName(String firstName);
	
}
