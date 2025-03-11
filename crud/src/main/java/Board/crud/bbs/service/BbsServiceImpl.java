package Board.crud.bbs.service;

import Board.crud.bbs.domain.BbsVO;
import Board.crud.bbs.mapper.BbsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsServiceImpl implements BbsService{

    private final BbsMapper bbsMapper;

    //생성자 주입
    public BbsServiceImpl(BbsMapper bbsMapper) {
        this.bbsMapper = bbsMapper;
    }

    @Override
    public List<BbsVO> getBbsList() {
        return List.of();
    }

    @Override
    public BbsVO getBbsById(int id) {
        return null;
    }

    @Override
    public void registerBbs(BbsVO bbsVO) {

    }

    @Override
    public void modifyBbs(BbsVO bbsVO) {

    }

    @Override
    public void removeBbs(int id) {

    }
}
