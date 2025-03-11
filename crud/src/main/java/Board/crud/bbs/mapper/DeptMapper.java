package Board.crud.bbs.mapper;


import Board.crud.bbs.domain.DeptVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper{

    //dept 테이블 전체조회
    List<DeptVO> selectDeptList();
    //id로 조회
    DeptVO selectDeptById(Long id);

    //등록
    void insertDept(DeptVO deptVO);

    //수정
    void updateDept(DeptVO deptVO);

    //삭제
    void deleteDept(Long id);
}
