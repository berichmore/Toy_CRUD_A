package board.crud.member.controller;


import board.crud.member.domain.Member;
import board.crud.member.dto.request.JoinRequest;
import board.crud.member.dto.request.LoginRequest;
import board.crud.member.dto.response.MemberResponse;
import board.crud.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //세션 로그인된 사용자 정보 확인
    @GetMapping("/me")
    public ResponseEntity<MemberResponse> getLoginMember(HttpServletRequest request){
        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        if(loginUser != null){
            return ResponseEntity.ok(new MemberResponse(loginUser));
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    //로그아웃 처리
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        request.getSession().invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }

    //로그인 요청
    @PostMapping("/login")
    public ResponseEntity<MemberResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request){
        MemberResponse member = memberService.login(loginRequest);
        if(member == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //세션에 도메인 객체 저장
        request.getSession().setAttribute("loginUser", member);
        return ResponseEntity.ok(new MemberResponse(member));

//        if(member != null){
//            request.getSession().setAttribute("loginUser", member);
//            return ResponseEntity.ok(member);
//        }else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }


    }
    //Id중복체크
    @GetMapping("/check")
    public ResponseEntity<Boolean> checkIdDuplicate(@RequestParam("id") String id){
        boolean exists = memberService.existsById(id);
        return ResponseEntity.ok(exists);
    }

    //회원가입 요청
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinRequest request){
        memberService.join(request);
        return ResponseEntity.ok("회원가입 성공");
    }


    }

//
//private final MemberService memberService;
//
////생성자 주입 방식
//public MemberController(MemberService memberService){
//    this.memberService = memberService;
//}
//
////세션 로그인 유지 확인
//@GetMapping("/me")
//public ResponseEntity<?> getLoginMember(HttpServletRequest request){
//    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
//    if(loginUser != null ) {
//        return ResponseEntity.ok(loginUser); //로그인된 사용자 정보 반환
//    }else {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
//                body("로그인되어 있지 않습니다.");
//    }
//}
//
////로그아웃
//@PostMapping("/logout")
//public ResponseEntity<?> logout(HttpServletRequest request){
//    request.getSession().invalidate(); //세션 무효화
//    return ResponseEntity.ok("로그아웃 성공");
//}
//
////로그인 처리 : JSON요청, 응답
//
//@PostMapping("/login")
//public ResponseEntity<?> login(@RequestBody Member loginRequest, HttpServletRequest request){
//    String id = loginRequest.getId();
//    String pwd = loginRequest.getPwd();
//
//    Member member = memberService.login(id, pwd);
//    if(member != null){
//        //로그인 성공 시 세션에 회원정보저장
//        request.getSession().setAttribute("loginUser", member);
//        return ResponseEntity.ok(member); //JSON으로 MEMBER정보 return
//    }else {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                .body("아이디 또는 비밀번호가 일치하지 않습니다.");
//    }
//}
//
//
////        중복 id 확인
//@GetMapping("/check")
//public ResponseEntity<?> checkIdDuplicate(@RequestParam("id") String id){
//    boolean exists = memberService.existsById(id);
//    return ResponseEntity.ok(exists);  //true : 이미 있음 / false : 사용 가능.
//}
////
//
////회원가입
//@PostMapping("join")
//public ResponseEntity<?> join(@RequestBody Member member, HttpServletRequest request){
//    memberService.join(member);
//    return ResponseEntity.ok("회원가입 성공");
//}

