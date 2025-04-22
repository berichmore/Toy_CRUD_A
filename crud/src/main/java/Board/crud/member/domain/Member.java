package board.crud.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;
    private String pwd;
    private String name;
    private String email;

}
