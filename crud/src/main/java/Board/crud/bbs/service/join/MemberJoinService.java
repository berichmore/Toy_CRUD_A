package board.crud.bbs.service.join;

import board.crud.member.domain.Member;
import board.crud.member.dao.MemberDao;
import board.crud.security.encrypt.PasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {
    private final MemberDao memberDao;
    private final PasswordEncryptor passwordEncryptor;

    public MemberJoinService(MemberDao memberDao, PasswordEncryptor passwordEncryptor) {
        this.memberDao = memberDao;
        this.passwordEncryptor = passwordEncryptor;
    }

    public void join(Member member){
        String rawPwd = member.getPwd();
        String hashedPwd = passwordEncryptor.encode(rawPwd);
        member.setPwd(hashedPwd);
        memberDao.insertMember(member);
    }

}
