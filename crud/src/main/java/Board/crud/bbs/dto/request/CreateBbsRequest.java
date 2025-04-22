package board.crud.bbs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CreateBbsRequest {
    private String title;
    private String content;
}
