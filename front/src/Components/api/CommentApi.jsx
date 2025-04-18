import axios from "axios";


// 댓글 등록
export const postComment = async (bbsSeq, content) =>{
    try {
        const res = await axios.post("/comment", {bbsSeq ,content},
            {withCredentials: true});
        console.log("[contentApi] 댓글 등록 성공", res.data);
        return res.data
    }catch (error){
        console.error("[contentApi 댓글 등록 실패", error);
        throw  error;
    }
};

//댓글 목록 조회
export const getCommentsByBbsSeq = async (bbsSeq) =>{
    try {
        const res = await axios.get(`/comment/${bbsSeq}`,
            {withCredentials: true});
        console.log("[commentApi] 댓글 목록 조회 성공", res.data);
        return res.data;
    }catch (error){
        console.error("[commentApi] 댓글 목록 조회 실패", error);
        throw error;
    }
};


// //게시글 삭제
// export const deleteBbs = async(seq) => {
//     try {
//         const res = await axios.delete(`/bbs/${seq}`);
//         console.log(`삭제된 데이터는  ${res.data}   입니다.`);  //현대적 방식 - 가독성 업
//         return res.data;
//
//     }catch (error){
//         console.error("글을 삭제할 수 없습니다.",error);
//         throw error;
//     }
// }