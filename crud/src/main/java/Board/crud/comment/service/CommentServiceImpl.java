package board.crud.comment.service;

import board.crud.comment.dao.CommentDao;
import board.crud.comment.domain.Comment;
import board.crud.comment.dto.request.CreateCommentRequest;
import board.crud.comment.dto.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;

    public CommentServiceImpl (CommentDao commentDao){
        this.commentDao = commentDao;
    }


    @Override
    public void writeComment(CreateCommentRequest createCommentRequest, String writerId) {
        Comment comment = new Comment(); //도메인 객체 생성은 Service에서만
        comment.setBbsSeq(createCommentRequest.getBbsSeq());
        comment.setContent(createCommentRequest.getContent());
        comment.setId(writerId);
        comment.setDel(0);
        commentDao.createComment(comment);
    }

    @Override
    public List<CommentResponse> getCommentsByBbsSeq(int bbsSeq) {
        return commentDao.getCommentsByBbsSeq(bbsSeq).stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }
}
//private final CommentDao commentDao;
//
//    public CommentServiceImpl(CommentDao commentDao) {
//        this.commentDao = commentDao;
//    }
//
//    @Override
//    public void writeComment(CreateCommentRequest request, String writerId) {
//        Comment comment = new Comment();
//        comment.setBbsSeq(request.getBbsSeq());
//        comment.setContent(request.getContent());
//        comment.setId(writerId);
//        comment.setDel(0);
//        commentDao.createComment(comment);
//    }
//
//    @Override
//    public List<CommentResponse> getCommentsByBbsSeq(int bbsSeq) {
//        List<Comment> commentList = commentDao.getCommentsByBbsSeq(bbsSeq);
//
//        //VO-> DTO 변환
//        return commentList.stream()
//                .map(CommentResponse::new)
//                .collect(Collectors.toList());
//}