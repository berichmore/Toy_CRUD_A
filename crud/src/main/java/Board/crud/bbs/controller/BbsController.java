package board.crud.bbs.controller;

import board.crud.bbs.domain.Bbs;
import board.crud.bbs.domain.Member;
import board.crud.bbs.service.BbsService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bbs")
public class BbsController {

    private final BbsService bbsService;

    public BbsController(BbsService bbsService) {
        this.bbsService = bbsService;
    }

    //조회수 증가
    @PutMapping("/hit/{seq}")
    public ResponseEntity<?> increaseReadCount(@PathVariable("seq") int seq){
        bbsService.increaseReadCount(seq);
        return ResponseEntity.ok().build();
    }


    //게시물 + 페이지네이션
    @GetMapping("list")
    public ResponseEntity<Map<String, Object>> getBbsList(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size",defaultValue = "10") int size
        ){
      List<Bbs> list = bbsService.getBbsList(size, page);
      int totalCount = bbsService.getTotalCount();
//      int startPage = bbsService.

        Map<String, Object> response = new HashMap<>();
        response.put("bbsList", list);
        response.put("totalCount", totalCount);
//        response.put("startPage", startPage);
//        response.put("endPage", endPage);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Bbs>> searchBbs(
            @RequestParam("type") String type,
            @RequestParam("keyword") String keyword){
        List<Bbs> result = bbsService.searchBbs(type, keyword);
        return ResponseEntity.ok(result);
    }


    
    //id로 검색용
    @GetMapping("/{id}")
    public Bbs getBbs(@PathVariable("id") String id){
        return bbsService.getBbsById(id);
    }
    
//    "seq로 조회할 수 있게 다시 새로짜기"
    @GetMapping("/seq/{seq}")
    public Bbs getBbsBySeq(@PathVariable("seq") int seq){
        return bbsService.getBbsBySeq(seq);
    }



    //인증인가 추가 글쓴이도 인허가 받아야 함
    @PostMapping()
    public ResponseEntity<?> createBbs(@RequestBody Bbs bbs, HttpServletRequest request){
        //1) 로그인 사용자 확인(인증)
        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        //2) 작성자 설정 (인가 로직 예시)
        // -bbs.setId(LoginUser.getId());로 ID를 셋팅해주면,
        // 실제 DB에는 로그인한 유저의 ID가 게시글 작성자로 들어가게 됨
        bbs.setId(loginUser.getId());
        //3)게시글 저장
        bbsService.registerBbs(bbs);
        return ResponseEntity.ok("게시글 등록 완료");

    }

    //인가 로직
    @PutMapping("{seq}")
    public ResponseEntity<?> updateBbs(@PathVariable("seq")int seq,
                                       @RequestBody Bbs updateRequest,
                                       HttpServletRequest request){
        //1.로그인 정보 가져오기 (인증)
        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        // 2. 게시글 리소스 조회
        Bbs bbs = bbsService.findBbsBySeq(seq);
        if(bbs == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글이 존재하지 않습니다.");
        }
        // 3. 권한 검증 실패(인가)
        if(!loginUser.getId().equals(bbs.getId())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("수정 권한이 없습니다.");
        }
        // 4. 권한 검증 완료 -> 수정 성공
        updateRequest.setSeq(seq);
        bbsService.modifyBbs(updateRequest);

        return ResponseEntity.ok("수정 완료");

    }



    //잘못됐던 나의 코드
//    @DeleteMapping("/{seq}")
//    public String deleteBbs(@PathVariable("seq") int seq){
//        bbsService.removeBbs(seq);
//        return "delete success";
//    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<?> deleteBbs(@PathVariable ("seq") int seq, HttpServletRequest request){
        //1. 사용자 가져오기

        Member loginUser =(Member) request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        //2. 게시글 조회
        Bbs bbs = bbsService.findBbsBySeq(seq);
        if (bbs == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글이 존재하지 않습니다.");
        }
        //3. 작성자와 로그인 사용자 비교
        if (!loginUser.getId().equals(bbs.getId())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
        }

        //4. 삭제 실행
        bbsService.removeBbs(seq);
        return ResponseEntity.ok("삭제 완료!");

    }





}
