package board.crud.comment.service;

import board.crud.comment.dto.request.CreateCommentRequest;

public interface CommentService {
    void writeComment(CreateCommentRequest request, String writerId);
}
