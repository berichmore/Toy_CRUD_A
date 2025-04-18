package board.crud.comment.controller;

import board.crud.bbs.domain.Member;
import board.crud.comment.dto.request.CreateCommentRequest;
import board.crud.comment.dto.response.CommentResponse;
import board.crud.comment.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@RestController
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping()
    public ResponseEntity<?> createComment(@RequestBody CreateCommentRequest request, HttpServletRequest httpRequest){
        Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        commentService.writeComment(request, loginUser.getId());
        return ResponseEntity.ok("댓글 등록 완료");
    }

    //댓글 목록 조회 API (게시글번호 seq기준)
    @GetMapping("/{bbsSeq}")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable("bbsSeq") int bbsSeq){
        List<CommentResponse> comments = commentService.getCommentsByBbsSeq(bbsSeq);
        return ResponseEntity.ok(comments);
    }
}
