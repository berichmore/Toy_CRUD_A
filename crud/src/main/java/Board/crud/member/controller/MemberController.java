package board.crud.member.controller;



import board.common.globalException.UnauthorizedException;
import board.crud.bbs.dto.response.ApiResponse;
import board.crud.member.domain.Member;
import board.crud.member.dto.request.JoinRequest;
import board.crud.member.dto.request.LoginRequest;
import board.crud.member.dto.response.MemberResponse;
import board.crud.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
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

    //로그인
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<MemberResponse>> login(@RequestBody LoginRequest loginRequest,
                                                            HttpServletRequest httpServletRequest){
        Member loginMember = memberService.login(loginRequest);
        if(loginMember == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            throw new UnauthorizedException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        httpServletRequest.getSession().setAttribute("loginMember", loginMember); //도메인 저장
//        return ResponseEntity.ok(new MemberResponse(loginMember));  // DTO로 응답
        return ResponseEntity.ok(ApiResponse.success(new MemberResponse(loginMember)));
    }

    //로그인 된 사용자 정보 반환
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<MemberResponse>> getLoginUser(HttpServletRequest httpServletRequest){
        Member loginUser = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        if(loginUser == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            throw new UnauthorizedException("로그인 정보가 없습니다.");
        }
//        return ResponseEntity.ok(new MemberResponse(loginUser));
        return ResponseEntity.ok(ApiResponse.success(new MemberResponse(loginUser)));
    }

    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
//        return ResponseEntity.ok("로그아웃 성공");
        return ResponseEntity.ok(ApiResponse.success());
    }

    //중복 체크
    @GetMapping("/check")
    public ResponseEntity<ApiResponse<Boolean>> checkIdDuplicate(@RequestParam("id") String id){
//        return ResponseEntity.ok(memberService.existsById(id));
        return ResponseEntity.ok(ApiResponse.success(memberService.existsById(id)));
    }

    //회원가입
    @PostMapping("/join")
    public ResponseEntity<ApiResponse<Void>> join(@RequestBody JoinRequest joinRequest){
        memberService.join(joinRequest);
//        return ResponseEntity.ok("회원가입이 완료되었습니다.");
        return ResponseEntity.ok(ApiResponse.success());
    }



    }
