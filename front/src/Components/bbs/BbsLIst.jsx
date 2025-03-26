import React, {useEffect, useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";

const BbsLIst = () => {

    const [bbsList, setBbsList] = useState([]);
    const navigate = useNavigate();


    const goWrite =() =>{
        //글쓰기 페이지로 이동
        navigate("/bbswrite");
    }

    const getBbsList = () =>{
        axios.get("/bbs/list")
            .then((response)=> {
                console.log(response.data);
                setBbsList(response.data)
            })
            .catch((error)=>{}
            )
    }

    useEffect(()=>{
        getBbsList("","",1);
    },[]);




    return (
        <>
        <div>
            <table>
                <tbody>
                <tr>
                    <td>
                        <select className="custom-select">
                            <option>검색 옵션 선택</option>
                            <option> 제목</option>
                            <option> 내용</option>
                            <option> 작성자</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" className="form-control" placeholder="검색어"/>
                    </td>
                    <td>
                        <button type="button" className="btn btn-outline-secondary">검색</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <thead>
                   <tr>
                        <th className="col-1">번호</th>
                        <th className="col-1">제목</th>
                        <th className="col-1">작성자</th>
                   </tr>
                </thead>

                <tbody>
                {
                    bbsList.map((bbs, idx)=>(
                        <tr key = {bbs.sequence}>
                            <td>{idx + 1}</td>
                            <td>{bbs.title}</td>
                            <td>{bbs.id}</td>
                        </tr>

                    ))
                }
                </tbody>
            </table>

        </div>
            <div className="d-flex justify-content-end">
                <button onClick={goWrite} className="btn btn-info">글쓰기</button>
            </div>
        </>
    );
};

export default BbsLIst;