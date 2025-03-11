package Board.crud.bbs.service;


import Board.crud.bbs.domain.BbsVO;

import java.util.List;

public interface BbsService {

    List<BbsVO> getBbsList();
    BbsVO getBbsById(int id);
    void registerBbs(BbsVO bbsVO);
    void modifyBbs(BbsVO bbsVO);
    void removeBbs(int id);
}
