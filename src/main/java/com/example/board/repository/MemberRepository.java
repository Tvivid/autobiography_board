//package com.example.board.repository;
//
//import com.example.board.entity.MemberEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
//
//    Optional<MemberEntity> findUserByEmailAndProvider(String email, String provider);
//}