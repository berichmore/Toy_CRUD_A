package board.crud.bbs.service;


import board.crud.bbs.domain.BoardVO;

import java.util.List;


public interface BoardService {

    List<BoardVO> getBoardList();
    BoardVO getBoard(Long id);
    void registerBoard(BoardVO boardVO);
    void modifyBoard(BoardVO boardVO);
    void removeBoard(Long id);
}
