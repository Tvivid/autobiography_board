package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import com.example.board.entity.MypageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MypageRepository extends JpaRepository<MypageEntity, Long> { //entity class이름과 entity class가 가지고 있는 pk의 타입
    // update board_table set board_hits = board_hits+1 where id = ?
//    @Modifying
//    @Query(value = "update BoardEntity b set b.boardHits = b.boardHits+1 where b.id=:id")
//    void updateHits(@Param("id") Long id);
}