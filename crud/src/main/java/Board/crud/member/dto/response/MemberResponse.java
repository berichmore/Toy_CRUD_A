package board.crud.member.dto.response;

import board.crud.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MemberResponse {
    private  String id;
    private  String name;
    private  String email;

    public MemberResponse(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
