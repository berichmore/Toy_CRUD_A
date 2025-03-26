package board.crud.bbs.service;


import board.crud.bbs.domain.DeptVO;

import java.util.List;

public interface DeptService {

    List<DeptVO> getDeptList();
    DeptVO getDept(Long id);
    void registerDept(DeptVO deptVO);
    void modifyDept(DeptVO deptVO);
    void removeDept(Long id);
}
