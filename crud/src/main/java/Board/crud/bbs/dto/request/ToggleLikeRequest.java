package board.crud.bbs.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToggleLikeRequest {
    private int bbsSeq; //게시글 번호

    //로그인 유저 id는 세션에서 꺼내니까 여긴 없어도 됨

}
