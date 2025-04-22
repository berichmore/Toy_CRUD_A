package board.crud.member.service;


import board.crud.member.domain.Member;
import board.crud.member.dto.request.JoinRequest;
import board.crud.member.dto.request.LoginRequest;
import board.crud.member.dto.response.MemberResponse;

public interface MemberService {

//    로그인
//        @param request 사용자로그인 요청
//        @param 로그인 성공 시 Member 객체, 실패 시 null
    MemberResponse login(LoginRequest request);
    //회원가입
    void join(JoinRequest request);
    //중복 아이디 확인
    boolean existsById(String id);



}
//Member login(String id, String pwd);
//void join(Member member);
//boolean existsById(String id);