package board.crud.comment.dao;

import board.crud.comment.domain.Comment;

public interface CommentDao {
    void createComment(Comment comment);
}
