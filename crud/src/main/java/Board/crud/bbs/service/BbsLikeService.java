package board.crud.bbs.service;


import board.crud.bbs.dto.request.ToggleLikeRequest;
import board.crud.bbs.dto.response.LikeStatusResponse;


public interface BbsLikeService {
    LikeStatusResponse toggleLike(String userId, ToggleLikeRequest toggleLikeRequest);
    int getLikeCount(int bbsSeq); //조회용
}
