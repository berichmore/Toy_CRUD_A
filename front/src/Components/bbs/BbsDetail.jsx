import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";
import {Link, useLocation, useNavigate, useParams} from "react-router-dom";
import {deleteBbs, getBbsDetail} from "../api/bbsApi";
import {LoginContext} from "../context/LoginProvider";


const BbsDetail = () => {

    const [bbs, setBbs] = useState({});
    const location = useLocation();  //라우터 state를 받기 위함.
    const {seq} = useParams();
    const navigate = useNavigate();

    //세션 인허가
    const {loginUser} = useContext(LoginContext);  //사용자 id, name 등 접근




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


    // 모듈화된 코드 구현
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
    },[seq, location.state?.updated]);  //수정 후 다시 실행

    //글 삭제 핸들러

    const handleDelete = async () => {
        const confirmDelete = window.confirm("정말로 이 글을 삭제하시겠습니까?");
        if(!confirmDelete) return;

        try {
            await deleteBbs(seq);
            alert("삭제가 완료되었습니다.")
            navigate("/bbslist"); //삭제 후 목록으로 이동
        }catch (error){
            alert("삭제가 실패하였습니다.");
        }
    };


    
    
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

                {loginUser && loginUser.id === bbs.id && (
                    <>
                <Link className="btn btn-outline-secondary" to={`/bbsupdate/${bbs.seq}`}>글수정</Link>
                <button className="btn btn-outline-secondary" onClick={handleDelete}>글삭제</button>
                    </>
            )}
            </div>



        </div>
    );
};

export default BbsDetail;