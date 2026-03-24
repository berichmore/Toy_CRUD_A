import React from 'react';
import axios from "axios";


//해당 게시글 불러오기
export const getBbsDetail = async (seq) => {

    try {
        const res = await axios.get(`/bbs/seq/${seq}`);
        if(res.data.success) {
            return res.data.data;
        } else {
            throw new Error(res.data.message);
        }

    }catch (error){
        console.error("게시글 조회 실패", error);
        throw error;
    }
}


//게시글 수정
export const putBbsDetail = async (seq, updateData) => {

    try {
        const res = await axios.put(`/bbs/${seq}`, updateData);
        if (res.data.success) {
            return res.data.data;
        } else {
            throw new Error(res.data.message);
        }
    }catch (error){
        console.error("수정이 실패하였습니다.",error);
        throw error;
    }

}

//게시글 삭제
export const deleteBbs = async(seq) => {
    try {
        const res = await axios.delete(`/bbs/${seq}`);
        if (res.data.success) {
            return res.data.data;
        } else {
            throw new Error(res.data.message);
        }
    }catch (error){
        console.error("글을 삭제할 수 없습니다.",error);
        throw error;
    }
}