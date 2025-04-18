import React, {useState} from 'react';
import {postComment} from "../api/CommentApi";

const CommentWrite = ({bbsSeq, onCommentAdded}) => {
    const [content, setContent] = useState("");

    const createComment = async() => {
        try {
            await postComment(bbsSeq,content);
            setContent("");
            onCommentAdded();
        }catch (err){
            alert("댓글 등록 실패" + (err.response?.data || "서버 오류"));
        }
    };


    return (
        <div>
            <textarea
                className="form-control mb-2"
                rows="3"
                value={content}
                onChange={(e)=> setContent(e.target.value)}
                placeholder="댓글을 입력하세요"
            />
            <button className="btn btn-primary" onClick={createComment}>
                댓글 등록
            </button>
        </div>
    );
};

export default CommentWrite;