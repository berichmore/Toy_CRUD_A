package board.crud.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinRequest {
    private String id;
    private String pwd;
    private String name;
    private String email;


}
