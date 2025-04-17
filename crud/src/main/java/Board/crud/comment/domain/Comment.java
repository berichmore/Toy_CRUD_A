package board.crud.comment.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Comment {
    private int seq;
    private int bbsSeq;
    private String id;
    private String content;
    private Timestamp createdAt;
    private int del; // 0: 정상 , 1: 삭제됨

}
