package board.crud.bbs.service;


public interface LikeService {
    void toggleLike(String userId, int bbsSeq);
}
