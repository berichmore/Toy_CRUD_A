package board.crud.bbs.dto.response;

import board.crud.bbs.domain.Bbs;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
public class BbsResponse {
    private final int seq;
    private final String id;
    private final String title;
    private final String content;
    private final Timestamp createdAt;
    private final int readCount;
    private final int likeCount;


    public BbsResponse(Bbs bbs){
        this.seq = bbs.getSeq();
        this.id = bbs.getId();
        this.title = bbs.getTitle();
        this.content = bbs.getContent();
        this.createdAt = bbs.getCreatedAt();
        this.readCount = bbs.getReadCount();
        this.likeCount = bbs.getLikeCount();
    }

}
