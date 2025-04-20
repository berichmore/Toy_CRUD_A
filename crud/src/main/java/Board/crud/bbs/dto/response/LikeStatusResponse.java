package board.crud.bbs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class LikeStatusResponse {
    private boolean liked;  //true : 눌림 , false : 취소
    private int likeCount;  //게시글 좋아요 총 개수
}
