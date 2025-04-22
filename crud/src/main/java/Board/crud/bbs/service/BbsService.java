package board.crud.bbs.service;


import board.crud.bbs.domain.Bbs;
import board.crud.bbs.dto.request.CreateBbsRequest;
import board.crud.bbs.dto.request.UpdateBbsRequest;
import board.crud.bbs.dto.response.BbsResponse;

import java.util.List;
import java.util.Map;

public interface BbsService {

    //글목록 + 전체개수
    Map<String, Object> getBbsListWithCount(int page, int size);

    //검색 결과
    List<BbsResponse> searchBbs(String type, String keyword);

    //게시글 조회
    BbsResponse getBbsBySeq(int seq);
    //게시글 등록
    void registerBbs(CreateBbsRequest request, String writerId);
    //
//    void updateRef(int seq);

    //게시글 수정
    void modifyBbs(UpdateBbsRequest request, String writerId);
    //게시글 삭제
    void removeBbs(int seq, String requestUserId);
    //조회수 카운트
    void increaseReadCount(int seq);

    //
//    Bbs findBbsBySeq(int seq);

    //
         //리팩토링 이전 2개를 하나로 통합
//    List<Bbs> getBbsList(int size, int page);
//    int getTotalCount();





    // seq를 통해 다시
//    List<BbsVO> getList();
//    BbsVO getById(String id);


}
