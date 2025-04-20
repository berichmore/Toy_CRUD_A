package board.crud.bbs.dto.param;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BbsLikeParam {
    private String id; //좋아요 누른 사용자 id
    private int bbsSeq;  //게시글 번호.
}
