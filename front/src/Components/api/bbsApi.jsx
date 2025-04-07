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