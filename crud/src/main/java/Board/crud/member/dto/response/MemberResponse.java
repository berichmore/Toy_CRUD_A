package board.crud.member.dto.response;

import board.crud.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MemberResponse {
    private final String id;
    private final String name;
    private final String email;

    public MemberResponse(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
