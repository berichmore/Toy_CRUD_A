package board.crud.bbs.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BbsLike {
    private String id;      // 사용자id
    private int bbsSeq;    //게시글 번호
    private Timestamp created;
}
