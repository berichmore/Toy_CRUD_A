package board.crud.bbs.service;

import board.crud.bbs.domain.BbsVO;
import board.crud.bbs.mapper.BbsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsServiceImpl implements BbsService{

    private final BbsMapper bbsMapper;

    public BbsServiceImpl(BbsMapper bbsMapper) {
        this.bbsMapper = bbsMapper;
    }

    @Override
    public List<BbsVO> getBbsList() {
        return bbsMapper.selectBbsList();
    }

    @Override
    public BbsVO getBbsById(String id) {
        return bbsMapper.selectBbsById(id);
    }

    @Override
    public void registerBbs(BbsVO bbsVO) {
        bbsMapper.insertBbs(bbsVO);
    }

    @Override
    public void modifyBbs(BbsVO bbsVO) {
        bbsMapper.updateBbs(bbsVO);
    }

    @Override
    public void removeBbs(int seq) {
        bbsMapper.deleteBbs(seq);
    }
}
