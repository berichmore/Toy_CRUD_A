package Board.crud.bbs.service;


import Board.crud.bbs.domain.BoardVO;

import java.util.List;


public interface BoardService {

    List<BoardVO> getBoardList();
    BoardVO getBoard(Long id);
    void registerBoard(BoardVO boardVO);
    void modifyBoard(BoardVO boardVO);
    void removeBoard(Long id);
}
