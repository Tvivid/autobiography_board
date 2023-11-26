package com.example.board.entity;


import com.example.board.dto.MypageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//DB의 테이블 역할을 하는 클래스
//service와 repository에서만 사용한다는 설정
@Entity
@Getter
@Setter
@Table(name="mypage_table")
public class MypageEntity extends BaseEntity{
    @Id //pk 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 20, nullable = false)//false로 설정하면 null일 수 없다)//크기 20
    private String nickname;

    @Column(length = 500)
    private String introduce;

    private int fileAttached; // 1 or 0

    //BoardFileEntity의 이름과 맞춰줌
    @OneToMany(mappedBy = "mypageEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MypageFileEntity> mypageFileEntityList = new ArrayList<>(); //board 하나에 boardfile 여러개가 올 수 있음

//    @OneToMany(mappedBy = "mypageEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CommentEntity> commentEntityList = new ArrayList<>();


    public static  MypageEntity toSaveMyEntity(MypageDTO mypageDTO){

        MypageEntity mypageEntity = new MypageEntity();
        mypageEntity.setNickname(mypageDTO.getNickname());
        mypageEntity.setIntroduce(mypageDTO.getIntroduce());
        mypageEntity.setFileAttached(0); //파일 없음
        return mypageEntity;
    }


    public static MypageEntity toUpdateMyEntity(MypageDTO mypageDTO) {

        MypageEntity mypageEntity = new MypageEntity();
        mypageEntity.setId(mypageDTO.getId());
        mypageEntity.setNickname(mypageDTO.getNickname());
        mypageEntity.setIntroduce(mypageDTO.getIntroduce());

        return mypageEntity;
    }

    public static MypageEntity toSaveFileEntity(MypageDTO mypageDTO) {

        MypageEntity mypageEntity = new MypageEntity();
        mypageEntity.setNickname(mypageDTO.getNickname());
        mypageEntity.setIntroduce(mypageDTO.getIntroduce());
        mypageEntity.setFileAttached(1);

        return mypageEntity;
    }
}
