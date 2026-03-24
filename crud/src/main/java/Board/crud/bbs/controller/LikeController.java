package board.crud.bbs.controller;


import board.common.globalException.UnauthorizedException;
import board.crud.bbs.dto.request.ToggleLikeRequest;
import board.crud.bbs.dto.response.ApiResponse;
import board.crud.bbs.dto.response.LikeStatusResponse;
import board.crud.bbs.service.BbsLikeService;
import board.crud.member.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@CrossOrigin
public class LikeController {

    private final BbsLikeService bbsLikeService;

    public LikeController(BbsLikeService bbsLikeService){
        this.bbsLikeService = bbsLikeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LikeStatusResponse>> toggleLike(@RequestBody ToggleLikeRequest toggleLikeRequest,
                                                                     HttpServletRequest httpServletRequest) {
        Member loginUser = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        if(loginUser == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            throw new UnauthorizedException("좋아요는 로그인된 사용자만 가능합니다.");
        }
        LikeStatusResponse toggleLikeResult = bbsLikeService.toggleLike(loginUser.getId(), toggleLikeRequest);
//        return ResponseEntity.ok(toggleLikeResult);
        return ResponseEntity.ok(ApiResponse.success(toggleLikeResult));
    }
    @GetMapping("/{bbsSeq}")
    public ResponseEntity<ApiResponse<Integer>> getLikeCount(@PathVariable("bbsSeq") int bbsSeq){
        int bbsLikeCount = bbsLikeService.getLikeCount(bbsSeq);
        return ResponseEntity.ok(ApiResponse.success(bbsLikeCount));
    }



    //JMeter Test API
    @PostMapping("/test")
    public ResponseEntity<ApiResponse<LikeStatusResponse>> toggleLikeTest(@RequestBody ToggleLikeRequest toggleLikeRequest){
//        Member loginUser = new Member();
//        loginUser.setId("테스트");
//        loginUser.setPwd("12341234");

        // JMeter가 보낸 request 객체를 직접 꺼낼 수 있도록 하기 위함
        String memberId = toggleLikeRequest.getMemberId();

//        LikeStatusResponse result = bbsLikeService.toggleLike(loginUser.getId(), toggleLikeRequest);
        LikeStatusResponse result = bbsLikeService.toggleLike(memberId, toggleLikeRequest);
        return ResponseEntity.ok(ApiResponse.success(result));
    }
}
