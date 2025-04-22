package board.crud.member.service;

import board.crud.member.dao.MemberDao;
import board.crud.member.domain.Member;
import board.crud.member.dto.request.JoinRequest;
import board.crud.member.dto.request.LoginRequest;
import board.crud.member.dto.response.MemberResponse;
import board.crud.security.encrypt.PasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;
    private final PasswordEncryptor passwordEncryptor;

    public MemberServiceImpl(MemberDao memberDao, PasswordEncryptor passwordEncryptor){
        this.memberDao = memberDao;
        this.passwordEncryptor = passwordEncryptor;
    }

//    로그인 처리
    @Override
    public MemberResponse login(LoginRequest request) {
        Member member = memberDao.selectMemberById(request.getId());

        if (member != null && passwordEncryptor.matches(request.getPwd(), member.getPwd())){
            return new MemberResponse(member);
        }
        return null;//로그인 실패
    }

//    회원가입 처리

    @Override
    public void join(JoinRequest request) {
        String hashedPwd = passwordEncryptor.encode(request.getPwd());
        Member member = new Member();
        member.setId(request.getId());
        member.setPwd(hashedPwd);
        member.setName(request.getName());
        member.setEmail(request.getEmail());

        memberDao.insertMember(member);

    }
    //아이디 중복 체크
    @Override
    public boolean existsById(String id) {
        return memberDao.selectMemberById(id) != null;
    }
}

//
//
//private final MemberDao memberDao;
//private final MemberJoinService memberJoinService;
//private final PasswordEncryptor passwordEncryptor;
//private final BbsDao bbsDao;
//
//public MemberServiceImpl(MemberDao memberDao, BCryptPasswordEncoder bCryptPasswordEncoder, MemberJoinService memberJoinService, PasswordEncryptor passwordEncryptor, BbsDao bbsDao) {
//    this.memberDao = memberDao;
//    this.memberJoinService = memberJoinService;
//    this.passwordEncryptor = passwordEncryptor;
//    this.bbsDao = bbsDao;
//}
//
//
//
//
////로그인
//@Override
//public Member login(String id, String pwd) {
//    //먼저 아이디를 통해 회원 정보를 조회
//    Member member = memberDao.selectMemberById(id);
//    // 실제로는 암호화가 필요하지만 일단 단순비교로 만들어보기
//
//    //기존 평문로직
////        if(member != null && member.getPwd().equals(pwd)){
////            return member;
////        }
//
//    //BCrypt 로그인 로직
//    if(member != null && passwordEncryptor.matches(pwd, member.getPwd())){
//        return member;
//    }
//
//    return null;
//}
//
//
//
////    회원가입
//@Override
//public void join(Member member) {
//    memberJoinService.join(member);   //내부 위임
//}
//
//
//
//@Override
//public boolean existsById(String id) {
//    return memberDao.selectMemberById(id) != null;
//}
