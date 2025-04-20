package board.crud.bbs.service;


import board.crud.bbs.dao.BbsLikeDao;
import board.crud.bbs.dto.param.BbsLikeParam;
import board.crud.bbs.dto.request.ToggleLikeRequest;
import board.crud.bbs.dto.response.LikeStatusResponse;
import board.crud.bbs.mapper.BbsMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BbsLikeServiceImpl implements BbsLikeService {

    private final BbsLikeDao bbsLikeDao;
    private final BbsMapper bbsMapper;

    public BbsLikeServiceImpl(BbsLikeDao bbsLikeDao, BbsMapper bbsMapper){
        this.bbsLikeDao = bbsLikeDao;
        this.bbsMapper = bbsMapper;
    }



    @Transactional
    @Override
    public LikeStatusResponse toggleLike(String id, ToggleLikeRequest request) {
        BbsLikeParam param = new BbsLikeParam(id, request.getBbsSeq());

        boolean aleadyLiked = bbsLikeDao.exists(param);

        if(aleadyLiked){
            bbsLikeDao.BbsLikeDelete(param);
            bbsMapper.decreaseLikeCount(request.getBbsSeq());
        } else {
            bbsLikeDao.BbsLikeInsert(param);
            bbsMapper.increaseLikeCount(request.getBbsSeq());
        }

        int likeCount = bbsMapper.getLikeCount(request.getBbsSeq());
        return new LikeStatusResponse(!aleadyLiked, likeCount);
    }
}
