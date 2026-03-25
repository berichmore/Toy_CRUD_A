package board.crud.bbs.service;


import board.crud.bbs.dao.BbsLikeDao;
import board.crud.bbs.domain.BbsLike;
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



//    @Transactional
//    @Override
//    public LikeStatusResponse toggleLike(String userId, ToggleLikeRequest toggleLikeRequest) {
//        BbsLikeParam bbsLikeParam = new BbsLikeParam(userId, toggleLikeRequest.getBbsSeq());
//        boolean aleadyLiked = bbsLikeDao.bbsLikeExists(bbsLikeParam);
//
//        if(aleadyLiked){
//            bbsLikeDao.bbsLikeDelete(bbsLikeParam);
//            bbsDao.decreaseLikeCount(bbsLikeParam.getBbsSeq());
//        }else {
//            bbsLikeDao.bbsLikeInsert(bbsLikeParam);
//            bbsDao.increaseLikeCount(bbsLikeParam.getBbsSeq());
//        }
//
//        int updateCount = bbsLikeDao.bbsGetLikeCount(toggleLikeRequest.getBbsSeq());
//        return new LikeStatusResponse(!aleadyLiked, updateCount);
//    }

    @Transactional
    @Override
    public LikeStatusResponse toggleLike(String userId, ToggleLikeRequest toggleLikeRequest) {


        // ForUpdate  bbs(부모)로
        bbsDao.selectBbsBySeqForUpdate(toggleLikeRequest.getBbsSeq());

        BbsLikeParam param = new BbsLikeParam(userId, toggleLikeRequest.getBbsSeq());

        boolean aleadyLiked = bbsLikeDao.bbsLikeExists(param);

        if (aleadyLiked) {
            bbsLikeDao.bbsLikeDelete(param);
            bbsDao.decreaseLikeCount(param.getBbsSeq());
        } else {
            bbsLikeDao.bbsLikeInsert(param);
            bbsDao.increaseLikeCount(param.getBbsSeq());
        }
        int updateCount = bbsLikeDao.bbsGetLikeCount(param.getBbsSeq());
        return new LikeStatusResponse(!aleadyLiked, updateCount);

//        BbsLikeParam param = new BbsLikeParam(userId, toggleLikeRequest.getBbsSeq());
//
//        System.out.println("현재 실행중인 스레드 이름: " + Thread.currentThread().getName() +
//                ", 요청 회원: " + param.getId());
//        // FOR UPDATE 락 -> 좋아요 여부 확인
//        BbsLike existing = bbsLikeDao.selectForUpdate(param);
//
//        if(existing != null){
//            bbsLikeDao.bbsLikeDelete(param);
//            bbsDao.decreaseLikeCount(param.getBbsSeq());
//        } else {
//            bbsLikeDao.bbsLikeInsert(param);
//            bbsDao.increaseLikeCount(param.getBbsSeq());
//        }
//        int updatedCount = bbsLikeDao.bbsGetLikeCount(param.getBbsSeq());
//        return new LikeStatusResponse(existing == null, updatedCount);


//        // FOR UPDATE 락없이 좋아요 확인 (정합성 무너뜨리기)
//        boolean aleadyLiked = bbsLikeDao.bbsLikeExists(param);
//
//        if(aleadyLiked){
//            bbsLikeDao.bbsLikeDelete(param);
//            bbsDao.decreaseLikeCount(param.getBbsSeq());
//        } else {
//            // 동시성 이슈를 더 확실하게 보기 위해 짧게 지연시간을 줘보기
//            try{
//                Thread.sleep(10);
//            }catch (InterruptedException e){
//
//            }
//            bbsLikeDao.bbsLikeInsert(param);
//            bbsDao.increaseLikeCount(param.getBbsSeq());
//        }
//
//        int updatedCount = bbsLikeDao.bbsGetLikeCount(param.getBbsSeq());
//        return new LikeStatusResponse(!aleadyLiked, updatedCount);
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