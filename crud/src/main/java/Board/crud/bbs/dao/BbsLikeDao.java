package board.crud.bbs.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BbsLikeDao {

    boolean BbsLikeExists(@Param("id") String id, @Param("bbsSeq") int bbsSeq);

    void BbsLikeInsert(@Param("id")String id, @Param("bbsSeq") int bbsSeq);

    void BbsLikeDelete(@Param("id")String id, @Param("bbsSeq") int bbsSeq);
}
