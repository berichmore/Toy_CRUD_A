package Board.crud.bbs.controller;

import Board.crud.bbs.domain.DeptVO;
import Board.crud.bbs.service.DeptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public String hello(){
        return "게시판에 오신걸 환영합니다.";
    }
    @GetMapping("list")
    public List<DeptVO> getDeptList(){
        return deptService.getDeptList();

    }

    @GetMapping("/{id}")
    public DeptVO getDept(@PathVariable long id){
        return deptService.getDept(id);
    }

    @PostMapping("")
    public String createDept(@RequestBody DeptVO deptVO){
        deptService.registerDept(deptVO);
        return "넥사크로 데이터셋 추가완료 + ResponseEntity 적용"
                + ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public String updateDept(@PathVariable("id") String id, @RequestBody DeptVO deptVO){
        deptVO.setDeptId(id);
        deptService.modifyDept(deptVO);
        return "넥사크로 데이터셋 수정 완료";
    }

    @DeleteMapping("/{id}")
    public String deleteDept(@PathVariable("id") Long id){
        deptService.removeDept(id);
        return "넥사크로 데이터셋 삭제완료.";
    }
}
