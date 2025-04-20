import React, {useEffect, useState} from 'react';
import {getCommentsByBbsSeq} from "../api/commentApi";

const CommentList = ({bbsSeq, reloadTrigger}) => {
    const [comments, setComments] = useState([]);


    useEffect(() => {
        const fetchComments = async () => {
            try {
                const data = await getCommentsByBbsSeq(bbsSeq);
                setComments(data);
            }catch (err){
                console.error("댓글 조회 실패", err)
            }
        }
        fetchComments()
    }, [bbsSeq,reloadTrigger]);

    return (
        <div className="my-4">
            <h5>댓글 목록</h5>
            <ul className="list-group" >
                {comments.map(comments => (
                    <li className="list-group-item" key={comments.seq}>
                        <strong>{comments.id}</strong>
                        {comments.content}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CommentList;