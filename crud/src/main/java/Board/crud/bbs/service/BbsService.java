package board.crud.bbs.service;


import board.crud.bbs.domain.BbsVO;

import java.util.List;

public interface BbsService {

    List<BbsVO> getBbsList();
    BbsVO getBbsById(String id);
    BbsVO getBbsBySeq(int seq);
    void registerBbs(BbsVO bbsVO);
    //ref
    void updateRef(int seq);

    void modifyBbs(BbsVO bbsVO);
    void removeBbs(int seq);
    
    //조회수 카운트
    void increaseReadCount(int seq);

    //검색
    List<BbsVO> searchBbs(String type, String keyword);

    //
    BbsVO findBbsBySeq(int seq);





    // seq를 통해 다시
//    List<BbsVO> getList();
//    BbsVO getById(String id);


}
