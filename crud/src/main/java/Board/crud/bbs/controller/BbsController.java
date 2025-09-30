package board.crud.bbs.controller;


import board.crud.bbs.dto.request.CreateBbsRequest;
import board.crud.bbs.dto.request.UpdateBbsRequest;
import board.crud.bbs.dto.response.BbsResponse;
import board.crud.bbs.service.BbsService;
import board.crud.member.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bbs")
public class BbsController {

    private final BbsService bbsService;

    public BbsController(BbsService bbsService){
        this.bbsService = bbsService;
    }

    //게시글 목록 + 전체 개수
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getBbsList(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size){
        return ResponseEntity.ok(bbsService.getBbsListWithCount(page, size));
    }

    // 게시글 검색
    @GetMapping("/search")
    public ResponseEntity<List<B0bsResponse>> searchBbs(
            @RequestParam("type") String type,
            @RequestParam("keyword") String keyword){
        return ResponseEntity.ok(bbsService.searchBbs(type, keyword));
    }

    //게시글 단건 조회
    @GetMapping("/seq/{seq}")
    public ResponseEntity<BbsResponse> getBbsBySeq(@PathVariable("seq") int seq){
        BbsResponse BbsResult = bbsService.getBbsBySeq(seq);
        return ResponseEntity.ok(BbsResult);
    }

    //조회수 증가
    @PutMapping("/hit/{seq}")
    public ResponseEntity<Void> increaseReadCount(@PathVariable("seq") int seq){
        bbsService.increaseReadCount(seq);
        return ResponseEntity.ok().build();
    }

    //게시글 작성
    @PostMapping
    public ResponseEntity<String> createBbs(@RequestBody CreateBbsRequest createBbsRequest,
                                            HttpServletRequest httpServletRequest){
        Member loginUser = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("글쓰기는 로그인이 필요합니다.");
        }
        bbsService.registerBbs(createBbsRequest, loginUser.getId());
        return ResponseEntity.ok("게시글이 등록되었습니다.");
    }

    //게시글 수정
    @PutMapping("/{seq}")
    public ResponseEntity<String> updateBbs(@PathVariable("seq") int seq,
                                            @RequestBody UpdateBbsRequest updateBbsRequest,
                                            HttpServletRequest httpServletRequest){
        Member loginUser = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("게시글 수정은 로그인이 필요합니다.");
        }
        updateBbsRequest.setSeq(seq);  //URI의 seq를 DTO에 주입
        bbsService.modifyBbs(updateBbsRequest, loginUser.getId());
        return ResponseEntity.ok("게시글 수정이 완료되었습니다.");

    }
    //게시글 삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity<String> deleteBbs(@PathVariable("seq") int seq, HttpServletRequest httpServletRequest){
        Member loginUser = (Member) httpServletRequest.getSession().getAttribute("loginMember");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        bbsService.removeBbs(seq, loginUser.getId());
        return ResponseEntity.ok("게시글 삭제 완료");
    }
}



