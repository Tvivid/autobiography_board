package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import com.example.board.entity.BoardFileEntity;
import com.example.board.entity.MypageEntity;
import com.example.board.entity.MypageFileEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// DTO(Data Transfer Object), VO, Bean, Entity
@Getter
@Setter
@ToString
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class MypageDTO {
    private Long id;
    private String nickname;
    private String introduce;

    private List<MultipartFile> profile;//실제 파일을 담아줄 수 있음 save.html -> Controller 파일 담는 용도
    private List<String> originalFileName;//원본 파일 이름
    private List<String> storedFileName;//서버 저장용 파일 이름, 파일 이름이 같으면 구분을 못하게 돼서 원본이랑 구분을 해줌
    private int fileAttached;//파일 첨부 여부(첨부 1, 미첨부 0)

    //alt+insert constructor
    public MypageDTO(Long id, String nickname ) {
        this.id = id;
        this.nickname=nickname;
    }

    public static MypageDTO toMypageDTO(MypageEntity mypageEntity){
        MypageDTO mypageDTO = new MypageDTO();
        mypageDTO.setId(mypageEntity.getId());
        mypageDTO.setIntroduce(mypageEntity.getIntroduce());
        mypageDTO.setNickname(mypageEntity.getNickname());

        if(mypageEntity.getFileAttached()==0){
            mypageDTO.setFileAttached(mypageEntity.getFileAttached()); // 0
        } else {
            List<String> originalFileNameList = new ArrayList<>();
            List<String> storedFileNameList = new ArrayList<>();
            mypageDTO.setFileAttached(mypageEntity.getFileAttached()); // 1
            // 파일 이름을 가져가야 함
            // orginalFileName, storedFileName : board_file_table(BoardFileEntity)
            // join
            // select * from board_table b, board_file_table bf where b.id=bf.board_id
            // and where b.id=?;                      //board_file_table에 있던 정보를 entityLsit로 가져와서 get(0)로 첫번째 index에 접근
            for (MypageFileEntity mypageFileEntity : mypageEntity.getMypageFileEntityList()) {
                originalFileNameList.add(mypageFileEntity.getOriginalFileName());
                storedFileNameList.add(mypageFileEntity.getStoredFileName());
            }
            mypageDTO.setOriginalFileName(originalFileNameList);
            mypageDTO.setStoredFileName(storedFileNameList);

        }

        return mypageDTO;
    }


}
