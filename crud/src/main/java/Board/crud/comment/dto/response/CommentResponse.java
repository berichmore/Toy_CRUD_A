package board.crud.comment.dto.response;

import board.crud.comment.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class CommentResponse {
    private Integer seq;
    private String id;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp createdAt;


    //VO((domain)댓글)을 DTO로 변환
    public CommentResponse(Comment comment){
        this.seq = comment.getSeq();
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }
}
