
//좋아요 수 조회
import axios from "axios";

export const getLikeCount = async (bbsSeq) =>{
    try {
        const res =await axios.get(`/like/${bbsSeq}`);
        return res.data;
    }catch (error){
        console.error("좋아요 수 조회 실패", error);
        throw error;
    }
};


//좋아요 토글( 로그인 필요함)
export const toggleLike = async (bbsSeq) =>{
    try {
        const res = await axios.post(`/like/${bbsSeq}`, {bbsSeq},{
            withCredentials: true //세션 쿠키 전송
        });
        return res.data;
    }catch (error){
        console.error("좋아요 토글 실패", error);
        throw error;
    }
}