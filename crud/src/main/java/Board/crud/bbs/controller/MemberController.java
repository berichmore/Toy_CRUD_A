package board.crud.bbs.controller;

import board.crud.bbs.domain.MemberVO;
import board.crud.bbs.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    //생성자 주입 방식
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    //세션 로그인 유지 확인
    @GetMapping("/me")
    public ResponseEntity<?> getLoginMember(HttpServletRequest request){
        MemberVO loginUser = (MemberVO) request.getSession().getAttribute("loginUser");
        if(loginUser != null ) {
            return ResponseEntity.ok(loginUser); //로그인된 사용자 정보 반환
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                    body("로그인되어 있지 않습니다.");
        }
    }

    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        request.getSession().invalidate(); //세션 무효화
        return ResponseEntity.ok("로그아웃 성공");
    }

    //로그인 처리 : JSON요청, 응답

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberVO loginRequest, HttpServletRequest request){
        String id = loginRequest.getId();
        String pwd = loginRequest.getPwd();

        MemberVO member = memberService.login(id, pwd);
        if(member != null){
            //로그인 성공 시 세션에 회원정보저장
            request.getSession().setAttribute("loginUser", member);
            return ResponseEntity.ok(member); //JSON으로 MEMBER정보 return
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        }


        @PostMapping("join")
    public ResponseEntity<?> join(@RequestBody MemberVO member, HttpServletRequest request){
        memberService.join(member);
        return ResponseEntity.ok("회원가입 성공");
        }
    }




