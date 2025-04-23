package board.crud.bbs.controller;


import board.crud.bbs.dto.request.ToggleLikeRequest;
import board.crud.bbs.dto.response.LikeStatusResponse;
import board.crud.bbs.service.BbsLikeService;
import board.crud.member.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<LikeStatusResponse> toggleLike(@RequestBody ToggleLikeRequest toggleLikeRequest,
                                                         HttpServletRequest httpServletRequest) {
        Member loginUser = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        LikeStatusResponse toggleLikeResult = bbsLikeService.toggleLike(loginUser.getId(), toggleLikeRequest);
        return ResponseEntity.ok(toggleLikeResult);
    }
    @GetMapping("/{bbsSeq}")
    public ResponseEntity<Integer> getLikeCount(@PathVariable("bbsSeq") int bbsSeq){
        int bbsLikeCount = bbsLikeService.getLikeCount(bbsSeq);
        return ResponseEntity.ok(bbsLikeCount);
    }
}
//private final BbsLikeService bbsLikeService;
//private final BbsDao bbsDao;
//private final BbsLikeDao bbsLikeDao;
//
//public LikeController(BbsLikeService bbsLikeService, BbsDao bbsDao, BbsLikeDao bbsLikeDao){
//    this.bbsLikeService = bbsLikeService;
//    this.bbsDao = bbsDao;
//    this.bbsLikeDao = bbsLikeDao;
//}
//
////좋아요 토글 api
//
//@GetMapping("/{seq}")
//public ResponseEntity<?> getLikeCount(@PathVariable("seq") int seq){
//    int count = bbsLikeDao.getLikeCount(seq);
//    return ResponseEntity.ok(count);
//}
//
//@PostMapping("/{seq}")
//public ResponseEntity<?> toggleLike(@RequestBody ToggleLikeRequest request, HttpServletRequest httpRequest){
//
//    //1. 로그인 체크
//    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
//    if(loginUser == null){
//        return ResponseEntity.status(401).body("로그인이 필요합니다.");
//    }
//
//    //2. 좋아요 처리
//    LikeStatusResponse response = bbsLikeService.toggleLike(loginUser.getId(), request);
//
//    // 3. 응답 반환
//    return ResponseEntity.ok(response);
//}