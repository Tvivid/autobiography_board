package com.example.board.repository;

import com.example.board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// DAO
// 자동으로 bean등록이 된다.
// @Repository // 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {
    // SELECT * FROM user WHERE username = 1?;
    Optional<User> findByUsername(String username);
}
