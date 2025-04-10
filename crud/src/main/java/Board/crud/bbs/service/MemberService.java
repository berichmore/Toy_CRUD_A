package board.crud.bbs.service;


import board.crud.bbs.domain.MemberVO;

public interface MemberService {

//    로그인
//    @param id 사용자 아이디
//    @param pwd 사용자 비밀번호
//    @return 로그인 성공 시 MemberVO, 실패시  null

    MemberVO login(String id, String pwd);
    void join(MemberVO memeber);


}
