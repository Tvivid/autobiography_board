package com.example.board.dto;

import com.example.board.entity.CommentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private LocalDateTime commentCreatedTime;

    public static CommentDTO toCommentDTO(CommentEntity commentEntity, Long boardId) {
        CommentDTO commentDTO =new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentWriter(commentEntity.getCommentWriter());
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        commentDTO.setCommentCreatedTime(commentEntity.getBoardEntity().getCreatedTime());
//        commentDTO.setBoardId(commentEntity.getBoardEntity().getId()); //Service 메서드에 @Transactionl을 붙여야 제대로 돌아감
        commentDTO.setBoardId(boardId);
        return commentDTO;
    }
}
