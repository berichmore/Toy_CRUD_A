package board.crud.bbs.controller;

import board.crud.bbs.domain.BbsVO;
import board.crud.bbs.service.BbsService;
import board.crud.bbs.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/bbs")
public class BbsController {

    private final BbsService bbsService;

    public BbsController(BbsService bbsService, BoardService boardService) {
        this.bbsService = bbsService;
    }

    @GetMapping("list")
    public List<BbsVO> getBbsLIst(){
        return bbsService.getBbsList();
    }

    @GetMapping("/{id}")
    public BbsVO getBbs(@PathVariable("id") String id){
        return bbsService.getBbsById(id);
    }
    @PostMapping()
    public String createBbs(@RequestBody BbsVO bbsVO){
        bbsService.registerBbs(bbsVO);
        return "Register success";
    }
    @PutMapping("/{id}")
    public String updateBbs(@PathVariable("id")String id, @RequestBody BbsVO bbsVo){
        bbsVo.setId(id);
        bbsService.modifyBbs(bbsVo);
        return "Update success";
    }
    @DeleteMapping("/{id}")
    public String deleteBbs(@PathVariable("id") int seq){
        bbsService.removeBbs(seq);
        return "delete success";
    }
}
