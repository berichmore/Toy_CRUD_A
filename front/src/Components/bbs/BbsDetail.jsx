import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link, useParams} from "react-router-dom";
import {getBbsDetail} from "../api/bbsApi";


const BbsDetail = () => {

    const [bbs, setBbs] = useState({});
    const {seq} = useParams();



    //조회수 증가
    const increaseReadCount = async() => {
        try {
            await axios.put(`/bbs/hit/${seq}`);
        }catch (error){
            console.error("조회수 증가 실패", error)

        }
    }


    // api 모듈화로 인한 삭제
    // const getBbsDetail = async () => {
    //
    //     await axios.get(`/bbs/seq/${seq}`)
    //         .then((res)=>{
    //             console.log(res.data);
    //
    //             setBbs(res.data);
    //         })

    // }


    useEffect(()=>{

        const fetchData = async ()=> {
        try {
            await increaseReadCount();
            const data = await getBbsDetail(seq);
            setBbs(data);


        }catch (error){
            console.error("게시글 상세 조회 실패", error)

        }
        }
        fetchData();
    },[seq]);
    
    
    return (

        <div>
            <h1>글보기</h1>
            <table className="table table-striped">
                <tbody >
                    <tr>
                        <th className="col-3">작성자</th>
                        <td>
                            <span>{bbs.id}</span>
                        </td>
                    </tr>
                    <tr>
                            <th>제목</th>
                            <td>
                                <span>{bbs.title}</span>
                            </td>
                        </tr>
                    <tr>
                            <th>작성일</th>
                            <td>
                                <span>{bbs.createdAt}</span>
                            </td>
                        </tr>
                    <tr>
                            <th>조회수</th>
                            <td>
                                <span>{bbs.readCount}</span>
                            </td>
                        </tr>
                    <tr>
                            <th>내용</th>
                            <td>
                                <div>
                                    {bbs.content}
                                </div>
                            </td>
                        </tr>

                </tbody>
            </table>
            <div>
                <Link className="btn btn-outline-secondary" to="/bbslist">글목록</Link>
                <Link className="btn btn-outline-secondary" to={`/bbsupdate/${bbs.seq}`}>글수정</Link>
            </div>



        </div>
    );
};

export default BbsDetail;