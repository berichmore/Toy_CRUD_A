package Board.crud.bbs.mapper;

import Board.crud.bbs.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    //board 테이블 전체 조회
    List<BoardVO> selectBoardList();

    //조회
    BoardVO selectBoardById(Long id);

    //등록
    void insertBoard(BoardVO boardVO);

    //수정
    void updateBoard(BoardVO boardVO);

    //삭제
    void deleteBoard(Long id);
}
