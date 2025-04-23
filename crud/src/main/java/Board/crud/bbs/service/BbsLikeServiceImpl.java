package board.crud.bbs.service;


import board.crud.bbs.dao.BbsLikeDao;
import board.crud.bbs.dto.param.BbsLikeParam;
import board.crud.bbs.dto.request.ToggleLikeRequest;
import board.crud.bbs.dto.response.LikeStatusResponse;
import board.crud.bbs.dao.BbsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BbsLikeServiceImpl implements BbsLikeService {

    private final BbsLikeDao bbsLikeDao;
    private final BbsDao bbsDao;

    public BbsLikeServiceImpl(BbsLikeDao bbsLikeDao, BbsDao bbsDao){
        this.bbsLikeDao = bbsLikeDao;
        this.bbsDao = bbsDao;
    }



    @Transactional
    @Override
    public LikeStatusResponse toggleLike(String userId, ToggleLikeRequest toggleLikeRequest) {
        BbsLikeParam bbsLikeParam = new BbsLikeParam(userId, toggleLikeRequest.getBbsSeq());
        boolean aleadyLiked = bbsLikeDao.bbsLikeExists(bbsLikeParam);

        if(aleadyLiked){
            bbsLikeDao.bbsLikeDelete(bbsLikeParam);
            bbsDao.decreaseLikeCount(bbsLikeParam.getBbsSeq());
        }else {
            bbsLikeDao.bbsLikeInsert(bbsLikeParam);
            bbsDao.increaseLikeCount(bbsLikeParam.getBbsSeq());
        }

        int updateCount = bbsLikeDao.bbsGetLikeCount(toggleLikeRequest.getBbsSeq());
        return new LikeStatusResponse(!aleadyLiked, updateCount);
    }


    @Override
    public int getLikeCount(int bbsSeq) {
        return bbsLikeDao.bbsGetLikeCount(bbsSeq);
    }
}

//private final BbsLikeDao bbsLikeDao;
//private final BbsDao bbsDao;
//
//public BbsLikeServiceImpl(BbsLikeDao bbsLikeDao, BbsDao bbsDao){
//    this.bbsLikeDao = bbsLikeDao;
//    this.bbsDao = bbsDao;
//}
//
//
//
//@Transactional
//@Override
//public LikeStatusResponse toggleLike(String id, ToggleLikeRequest request) {
//    BbsLikeParam param = new BbsLikeParam(id, request.getBbsSeq());
//
//    boolean aleadyLiked = bbsLikeDao.exists(param);
//
//    if(aleadyLiked){
//        bbsLikeDao.BbsLikeDelete(param);
//        bbsDao.decreaseLikeCount(request.getBbsSeq());
//    } else {
//        bbsLikeDao.BbsLikeInsert(param);
//        bbsDao.increaseLikeCount(request.getBbsSeq());
//    }
//
//    int likeCount = bbsLikeDao.getLikeCount(request.getBbsSeq());
//    return new LikeStatusResponse(!aleadyLiked, likeCount);
//}