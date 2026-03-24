package board.crud.member.service;


import board.crud.member.dao.MemberDao;
import board.crud.member.domain.Member;
import board.crud.member.dto.request.JoinRequest;
import board.crud.member.dto.request.LoginRequest;
import board.crud.security.encrypt.PasswordEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;
    private final PasswordEncryptor passwordEncryptor;

    public MemberServiceImpl(MemberDao memberDao, PasswordEncryptor passwordEncryptor) {
        this.memberDao = memberDao;
        this.passwordEncryptor = passwordEncryptor;
    }


    @Override
    public Member login(LoginRequest loginRequest) {
        Member loginMember = memberDao.selectMemberById(loginRequest.getId());
        if(loginMember != null && passwordEncryptor.matches(loginRequest.getPwd(), loginMember.getPwd())) {
            return loginMember;
        }
        return null;
    }





    @Transactional
    @Override
    public void join(JoinRequest joinRequest) {
        Member joinMember = new Member();
        joinMember.setId(joinRequest.getId());
        joinMember.setPwd(passwordEncryptor.encode(joinRequest.getPwd()));
        joinMember.setName(joinRequest.getName());
        joinMember.setEmail(joinRequest.getEmail());
        memberDao.insertMember(joinMember);
    }

    @Override
    public boolean existsById(String id) {
        return memberDao.selectMemberById(id) != null;
    }
}