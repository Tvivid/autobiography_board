package com.example.board.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_file_table")
//public class BoardFileEntity extends BaseEntity {
public class BoardFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    //BoardEntity boardEntity로 수정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") //db에 만들어지는 column 이름을 정함
    private BoardEntity boardEntity;

    //나중에 BoardEntity boardEntity로 수정하기 setBoardEntity(boardEntity)
    public static BoardFileEntity toBoardFileEntity(BoardEntity boardEntity, String originalFileName, String storedFileName){
        BoardFileEntity boardFileEntity = new BoardFileEntity();
        boardFileEntity.setOriginalFileName(originalFileName);
        boardFileEntity.setStoredFileName(storedFileName);
        boardFileEntity.setBoardEntity(boardEntity);
        return boardFileEntity;
    }



}
