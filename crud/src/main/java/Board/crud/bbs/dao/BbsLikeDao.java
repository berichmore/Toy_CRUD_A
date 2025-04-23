package board.crud.bbs.dao;

import board.crud.bbs.dto.param.BbsLikeParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsLikeDao {
    boolean bbsLikeExists(BbsLikeParam likeBbsParam);
    void bbsLikeInsert(BbsLikeParam likeInsertParam);
    void bbsLikeDelete(BbsLikeParam likeDeleteParam);
    int bbsGetLikeCount(int bbsSeq);
}
