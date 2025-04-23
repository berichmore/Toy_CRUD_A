package board.crud.bbs.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UpdateBbsRequest {
    private int seq;        //수정할 때 URI에서 전달받아서 Set으로 주입시키기
    private String title;
    private String content;

}
