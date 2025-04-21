package board.crud.bbs.mapper;

import board.crud.bbs.domain.Bbs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BbsMapper {

    //전체 조회
    List<Bbs> selectBbsList();

    //회원 조회
    Bbs selectBbsById(String id);

    //Read Page 조회
    Bbs selectBbsBySeq(int seq);

    //등록
    void insertBbs(Bbs bbs);

    //수정
    void updateBbs(Bbs bbs);

    //삭제
    void deleteBbs(int seq);

    //조회수 카운트
    void increaseReadCount(int seq);

    //ref
    void updateRef(int seq);

    //Type 검색
    List<Bbs> searchBbs(@Param("type") String type, @Param("keyword") String keyword);
    
    //전체 게시글 수
    int selectBbsCount();

    //페이지네이션
    List<Bbs> selectBbsListPaging(@Param("offset") int offset, @Param("size")int size);


    //글 좋아요
    void increaseLikeCount(int bbsSeq);
    void decreaseLikeCount(int bbsSeq);
    void updateLikeCount(int bbsSeq);








}
