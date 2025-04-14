package board.crud.bbs.service;


import board.crud.bbs.domain.Bbs;

import java.util.List;

public interface BbsService {


    Bbs getBbsById(String id);
    Bbs getBbsBySeq(int seq);
    void registerBbs(Bbs bbs);
    //ref
    void updateRef(int seq);

    void modifyBbs(Bbs bbs);
    void removeBbs(int seq);
    
    //조회수 카운트
    void increaseReadCount(int seq);

    //검색
    List<Bbs> searchBbs(String type, String keyword);

    //
    Bbs findBbsBySeq(int seq);

    //
    int getTotalCount();

    List<Bbs> getBbsList(int size, int page);


    // seq를 통해 다시
//    List<BbsVO> getList();
//    BbsVO getById(String id);


}
