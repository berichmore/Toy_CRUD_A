package board.crud.bbs.dto.response;

import board.crud.bbs.domain.Bbs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class BbsResponse {
    private int seq;
    private String id;
    private String title;
    private String content;
    private Timestamp createdAt;
    private int readCount;
    private int likeCount;


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
