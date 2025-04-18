package board.crud.comment.dao;

import board.crud.comment.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CommentDao {
//    댓글 쓰기
    void createComment(Comment comment);
    //댓글 조회용
    List<Comment> getCommentsByBbsSeq(@Param("bbsSeq") int bbsSeq);
}
