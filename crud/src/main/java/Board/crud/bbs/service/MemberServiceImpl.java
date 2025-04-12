package board.crud.bbs.service;

import board.crud.bbs.domain.Member;
import board.crud.bbs.mapper.BbsMapper;
import board.crud.bbs.mapper.MemberMapper;
import board.crud.bbs.service.encrypt.PasswordEncryptor;
import board.crud.bbs.service.join.MemberJoinService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final MemberJoinService memberJoinService;
    private final PasswordEncryptor passwordEncryptor;
    private final BbsMapper bbsMapper;

    public MemberServiceImpl(MemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder, MemberJoinService memberJoinService, PasswordEncryptor passwordEncryptor, BbsMapper bbsMapper) {
        this.memberMapper = memberMapper;
        this.memberJoinService = memberJoinService;
        this.passwordEncryptor = passwordEncryptor;
        this.bbsMapper = bbsMapper;
    }




    //로그인
    @Override
    public Member login(String id, String pwd) {
        //먼저 아이디를 통해 회원 정보를 조회
        Member member = memberMapper.selectMemberById(id);
        // 실제로는 암호화가 필요하지만 일단 단순비교로 만들어보기

        //기존 평문로직
//        if(member != null && member.getPwd().equals(pwd)){
//            return member;
//        }

        //BCrypt 로그인 로직
        if(member != null && passwordEncryptor.matches(pwd, member.getPwd())){
            return member;
        }

        return null;
    }



//    회원가입
    @Override
    public void join(Member member) {
        memberJoinService.join(member);   //내부 위임
    }



    @Override
    public boolean existsById(String id) {
        return memberMapper.selectMemberById(id) != null;
    }

}
