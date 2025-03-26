package board.crud.bbs.service;

import board.crud.bbs.domain.BoardVO;
import board.crud.bbs.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    //생성자 주입.
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardMapper.selectBoardList();
    }

    @Override
    public BoardVO getBoard(Long id) {
        return boardMapper.selectBoardById(id);
    }

    @Override
    public void registerBoard(BoardVO boardVO) {
        boardMapper.insertBoard(boardVO);
    }

    @Override
    public void modifyBoard(BoardVO boardVO) {
        boardMapper.updateBoard(boardVO);
    }

    @Override
    public void removeBoard(Long id) {
        boardMapper.deleteBoard(id);
    }
}
