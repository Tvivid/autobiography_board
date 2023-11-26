package com.example.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "mypage_file_table")
//public class BoardFileEntity extends BaseEntity {
public class MypageFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    //BoardEntity boardEntity로 수정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mypage_id") //db에 만들어지는 column 이름을 정함
    private MypageEntity mypageEntity;

    //나중에 BoardEntity boardEntity로 수정하기 setBoardEntity(boardEntity)
    public static MypageFileEntity toBoardFileEntity(MypageEntity mypageEntity, String originalFileName, String storedFileName){
        MypageFileEntity mypageFileEntity = new MypageFileEntity();
        mypageFileEntity.setOriginalFileName(originalFileName);
        mypageFileEntity.setStoredFileName(storedFileName);
        mypageFileEntity.setMypageEntity(mypageEntity);
        return mypageFileEntity;
    }



}
