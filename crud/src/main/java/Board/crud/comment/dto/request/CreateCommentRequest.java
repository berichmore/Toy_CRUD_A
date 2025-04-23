package board.crud.comment.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {
    private Integer bbsSeq;
    private String content;
}
