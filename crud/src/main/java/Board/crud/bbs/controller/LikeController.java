package board.crud.bbs.controller;

import board.crud.bbs.dao.BbsLikeDao;
import board.crud.bbs.domain.Member;
import board.crud.bbs.dto.request.ToggleLikeRequest;
import board.crud.bbs.dto.response.LikeStatusResponse;
import board.crud.bbs.mapper.BbsMapper;
import board.crud.bbs.service.BbsLikeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@CrossOrigin
public class LikeController {

    private final BbsLikeService bbsLikeService;
    private final BbsMapper bbsMapper;
    private final BbsLikeDao bbsLikeDao;

    public LikeController(BbsLikeService bbsLikeService, BbsMapper bbsMapper, BbsLikeDao bbsLikeDao){
        this.bbsLikeService = bbsLikeService;
        this.bbsMapper = bbsMapper;
        this.bbsLikeDao = bbsLikeDao;
    }

    //좋아요 토글 api

    @GetMapping("/{seq}")
    public ResponseEntity<?> getLikeCount(@PathVariable("seq") int seq){
        int count = bbsLikeDao.getLikeCount(seq);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/{seq}")
    public ResponseEntity<?> toggleLike(@RequestBody ToggleLikeRequest request, HttpServletRequest httpRequest){

        //1. 로그인 체크
        Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        //2. 좋아요 처리
        LikeStatusResponse response = bbsLikeService.toggleLike(loginUser.getId(), request);

        // 3. 응답 반환
        return ResponseEntity.ok(response);
    }

}
