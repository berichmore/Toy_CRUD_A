package board.crud.bbs.service;

import board.crud.bbs.domain.MemberVO;
import board.crud.bbs.mapper.MemberMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MemberServiceImpl(MemberMapper memberMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberMapper = memberMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }




    //로그인
    @Override
    public MemberVO login(String id, String pwd) {
        //먼저 아이디를 통해 회원 정보를 조회
        MemberVO member = memberMapper.selectMemberId(id);
        // 실제로는 암호화가 필요하지만 일단 단순비교로 만들어보기
        if(member != null && member.getPwd().equals(pwd)){
            return member;

            //=--------------------------member로 리턴한다는게 뭐지?
        }
        return null;
    }



//    회원가입
    @Override
    public void join(MemberVO member) {


    }
}
