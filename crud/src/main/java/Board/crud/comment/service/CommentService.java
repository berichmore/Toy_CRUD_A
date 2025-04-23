package board.crud.comment.service;

import board.crud.comment.dto.request.CreateCommentRequest;
import board.crud.comment.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {

    void writeComment(CreateCommentRequest createCommentRequest, String writerId);
    //댓글 조회용
    List<CommentResponse> getCommentsByBbsSeq(int bbsSeq);
}
