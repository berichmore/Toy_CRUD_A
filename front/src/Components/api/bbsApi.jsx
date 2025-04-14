import React from 'react';
import axios from "axios";


//해당 게시글 불러오기
export const getBbsDetail = async (seq) => {

    try {
        const res = await axios.get(`/bbs/seq/${seq}`);
        console.log(res.data);
        return res.data;
    }catch (error){
        console.error("게시글 조회 실패", error);
        throw error;
    }
}


//게시글 수정
export const putBbsDetail = async (seq, updateData) => {

    try {
        const res = await axios.put(`/bbs/${seq}`, updateData);
        console.log(res.data);
        return res.data;
    }catch (error){
        console.error("수정이 실패하였습니다.",error);
        throw error;
    }

}

//게시글 삭제
export const deleteBbs = async(seq) => {
    try {
        const res = await axios.delete(`/bbs/${seq}`);
        console.log(`삭제된 데이터는  ${res.data}   입니다.`);  //현대적 방식 - 가독성 업
        return res.data;

    }catch (error){
        console.error("글을 삭제할 수 없습니다.",error);
        throw error;
    }
}

// //페이지네이션
// export const getBbsListPagination = async (page = 1, size = 10) =>{
//     try {
//         const res = await axios.get("/bbs/list")
//     }catch (error){
//         console.error("게시글 목록 조회 실패", error);
//         throw error;
//     }
// }