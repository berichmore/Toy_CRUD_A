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
    public BbsVO getBbsBySeq(int seq) {
        return bbsMapper.selectBbsBySeq(seq);
    }

    @Override
    public void registerBbs(BbsVO bbsVO) {
        bbsMapper.insertBbs(bbsVO);
        updateRef(bbsVO.getSeq());

    }

    @Override
    public void updateRef(int seq) {
        bbsMapper.updateRef(seq);
    }

    @Override
    public void modifyBbs(BbsVO bbsVO) {
        bbsMapper.updateBbs(bbsVO);
    }

    @Override
    public void removeBbs(int seq) {
        bbsMapper.deleteBbs(seq);
    }

    @Override
    public void increaseReadCount(int seq) {
        bbsMapper.increaseReadCount(seq);
    }

    @Override
    public List<BbsVO> searchBbs(String type, String keyword) {
        return bbsMapper.searchBbs(type, keyword);
    }


}
