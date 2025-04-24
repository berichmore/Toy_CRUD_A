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
    void registerBbs(CreateBbsRequest createRequest, String writerId);

    //게시글 수정
    void modifyBbs(UpdateBbsRequest modifyRequest, String writerId);

    //게시글 삭제
    void removeBbs(int seq, String requestUserId);

    //조회수 카운트
    void increaseReadCount(int seq);



}
