package handsoft.crud.domain;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BoardVO {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private int count;
    private Timestamp createdAt;

}
