package board.crud.bbs.dao;

import board.crud.bbs.dto.param.BbsLikeParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsLikeDao {
    boolean exists(BbsLikeParam param);
    void BbsLikeInsert(BbsLikeParam insertparam);
    void BbsLikeDelete(BbsLikeParam deleteparam);
    int getLikeCount(int bbsSeq);
}
