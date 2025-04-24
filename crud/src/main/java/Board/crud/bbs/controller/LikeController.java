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
