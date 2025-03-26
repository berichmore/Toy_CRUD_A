package board.crud.bbs.service;

import board.crud.bbs.domain.DeptVO;
import board.crud.bbs.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{


    private final DeptMapper deptMapper;

    //생성자 주입.
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<DeptVO> getDeptList() {
        return deptMapper.selectDeptList();

    }

    @Override
    public DeptVO getDept(Long id) {
        return deptMapper.selectDeptById(id);
    }

    @Override
    public void registerDept(DeptVO deptVO) {
        deptMapper.insertDept(deptVO);
    }

    @Override
    public void modifyDept(DeptVO deptVO) {
        deptMapper.updateDept(deptVO);
    }

    @Override
    public void removeDept(Long id) {
        deptMapper.deleteDept(id);
    }
}
