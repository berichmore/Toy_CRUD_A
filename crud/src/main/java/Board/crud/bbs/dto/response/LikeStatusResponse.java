package board.crud.bbs.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class LikeStatusResponse {
    private final boolean liked;  //true : 눌림 , false : 취소
    private final int likeCount;  //게시글 좋아요 총 개수
}


//java 16부터 record 타입이 도입되었는데
//지금 내가 하는 lombok dto 타입과는
//설정이 좀 다르고 현업에서는 지금 하는대로를 거의 사용하니
// 이대로 두기