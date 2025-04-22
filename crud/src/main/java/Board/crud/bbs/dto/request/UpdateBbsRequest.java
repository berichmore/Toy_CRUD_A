package board.crud.bbs.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateBbsRequest {
    private int seq;
    private String title;
    private String content;

}
