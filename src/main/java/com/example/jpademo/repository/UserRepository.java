package com.example.jpademo.repository;

import com.example.jpademo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // 可以添加自定义的查询方法，Spring Data JPA 会根据方法名自动生成查询
}
