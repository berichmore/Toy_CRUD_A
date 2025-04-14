package board.crud.bbs.service;

import board.crud.bbs.domain.Bbs;
import board.crud.bbs.mapper.BbsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BbsServiceImpl implements BbsService{

    private final BbsMapper bbsMapper;

    public BbsServiceImpl(BbsMapper bbsMapper) {
        this.bbsMapper = bbsMapper;
    }

    @Override
    public List<Bbs> getBbsList(int size, int page) {
        //페이지가 1부터 들어온다고 가정할 때,
        int offset = (page - 1) * size;
        //mybatis mapper 호출
        return bbsMapper.selectBbsListPaging(offset, size);
    }

    @Override
    public Bbs getBbsById(String id) {
        return bbsMapper.selectBbsById(id);
    }

    //회원찾기
    public Bbs findBbsBySeq(int seq) {
        return bbsMapper.selectBbsBySeq(seq);
    }

    @Override
    public int getTotalCount() {
        return bbsMapper.selectBbsCount();
    }


    @Override
    public Bbs getBbsBySeq(int seq) {
        return bbsMapper.selectBbsBySeq(seq);
    }

    @Override
    public void registerBbs(Bbs bbs) {
        bbsMapper.insertBbs(bbs);
        updateRef(bbs.getSeq());

    }

    @Override
    public void updateRef(int seq) {
        bbsMapper.updateRef(seq);
    }

    @Override
    public void modifyBbs(Bbs bbs) {
        bbsMapper.updateBbs(bbs);
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
    public List<Bbs> searchBbs(String type, String keyword) {
        return bbsMapper.searchBbs(type, keyword);
    }



}
