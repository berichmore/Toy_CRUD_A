package board.crud.comment.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {
    private Integer bbsSeq;
    private String content;

}
