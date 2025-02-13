package com.sushant.SecurityApp.SecurityApplication.repositories;

import com.sushant.SecurityApp.SecurityApplication.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
