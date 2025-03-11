package Board.crud.bbs.domain;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BbsVO {

    private int seq;
    private String id;
    private int ref;
    private int step;
    private int depth;
    private String title;
    private String content;
    private Timestamp createdAt;
    private int del;
    private int readCount;

}
