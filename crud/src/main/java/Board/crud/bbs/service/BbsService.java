package Board.crud.bbs.service;


import Board.crud.bbs.domain.BbsVO;

import java.util.List;

public interface BbsService {

    List<BbsVO> getBbsList();
    BbsVO getBbsById(String id);
    void registerBbs(BbsVO bbsVO);
    void modifyBbs(BbsVO bbsVO);
    void removeBbs(int seq);
}
