package board.crud.bbs.mapper;

import board.crud.bbs.domain.BbsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsMapper {

    //전체 조회
    List<BbsVO> selectBbsList();

    //회원 조회
    BbsVO selectBbsById(String id);

    //등록
    void insertBbs(BbsVO bbsVO);

    //수정
    void updateBbs(BbsVO bbsVO);

    //삭제
    void deleteBbs(int seq);

}
