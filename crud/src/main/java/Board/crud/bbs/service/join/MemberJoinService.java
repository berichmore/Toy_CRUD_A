package board.crud.bbs.service.join;

import board.crud.bbs.domain.Member;
import board.crud.bbs.mapper.MemberMapper;
import board.crud.bbs.service.encrypt.PasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {
    private final MemberMapper memberMapper;
    private final PasswordEncryptor passwordEncryptor;

    public MemberJoinService(MemberMapper memberMapper, PasswordEncryptor passwordEncryptor) {
        this.memberMapper = memberMapper;
        this.passwordEncryptor = passwordEncryptor;
    }

    public void join(Member member){
        String rawPwd = member.getPwd();
        String hashedPwd = passwordEncryptor.encode(rawPwd);
        member.setPwd(hashedPwd);
        memberMapper.insertMember(member);
    }

}
