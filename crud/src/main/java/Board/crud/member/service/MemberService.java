package board.crud.member.service;


import board.crud.member.domain.Member;
import board.crud.member.dto.request.JoinRequest;
import board.crud.member.dto.request.LoginRequest;

public interface MemberService {

//    로그인
//        @param request 사용자로그인 요청
//        @param 로그인 성공 시 Member 객체, 실패 시 null
    Member login(LoginRequest loginRequest);   //서비스 책임인 도메인을 반환
    void join(JoinRequest joinRequest);
    boolean existsById(String id);



}
//Member login(String id, String pwd);
//void join(Member member);
//boolean existsById(String id);