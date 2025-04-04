package board.crud.bbs.mapper;

import board.crud.bbs.domain.BbsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BbsMapper {

    //전체 조회
    List<BbsVO> selectBbsList();

    //회원 조회
    BbsVO selectBbsById(String id);

    //Read Page 조회
    BbsVO selectBbsBySeq(int seq);

    //등록
    void insertBbs(BbsVO bbsVO);

    //수정
    void updateBbs(BbsVO bbsVO);

    //삭제
    void deleteBbs(int seq);

    //조회수 카운트
    void increaseReadCount(int seq);

    //ref
    void updateRef(int seq);

    //Type 검색
    List<BbsVO> searchBbs(@Param("type") String type, @Param("keyword") String keyword);




}
