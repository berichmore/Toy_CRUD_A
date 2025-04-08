package board.crud.bbs.controller;

import board.crud.bbs.domain.BbsVO;
import board.crud.bbs.service.BbsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("list")
    public List<BbsVO> getBbsLIst(){
        return bbsService.getBbsList();
    }

    //검색
//    @GetMapping("/search")
//    public ResponseEntity<List<BbsVO>> searchBbs(String type, String keyword){
//        List<BbsVO> result = bbsService.searchBbs(type, keyword);
//        return ResponseEntity.ok(result);
//    }
    @GetMapping("/search")
    public ResponseEntity<List<BbsVO>> searchBbs(
            @RequestParam("type") String type,
            @RequestParam("keyword") String keyword){
        List<BbsVO> result = bbsService.searchBbs(type, keyword);
        return ResponseEntity.ok(result);
    }



    
    //id로 검색용
    @GetMapping("/{id}")
    public BbsVO getBbs(@PathVariable("id") String id){
        return bbsService.getBbsById(id);
    }
    
//    "seq로 조회할 수 있게 다시 새로짜기"
    @GetMapping("/seq/{seq}")
    public BbsVO getBbsBySeq(@PathVariable("seq") int seq){
        return bbsService.getBbsBySeq(seq);
    }

    @PostMapping()
    public String createBbs(@RequestBody BbsVO bbsVO){
        bbsService.registerBbs(bbsVO);
        return "Register success";
    }
    @PutMapping("/{seq}")
    public String updateBbs(@PathVariable("seq")int seq, @RequestBody BbsVO bbsVo){
        bbsVo.setSeq(seq);
        bbsService.modifyBbs(bbsVo);
        return "Update success";
    }
    @DeleteMapping("/{seq}")
    public String deleteBbs(@PathVariable("seq") int seq){
        bbsService.removeBbs(seq);
        return "delete success";
    }



}
