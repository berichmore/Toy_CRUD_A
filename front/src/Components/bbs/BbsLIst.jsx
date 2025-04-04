import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";

const BbsLIst = () => {



    //글목록
    const [bbsList, setBbsList] = useState([]);
    const navigate = useNavigate();

    //검색
    const [searchType, setSearchType] = useState("title");
    const [keyword, setKeyword] = useState("");




    const handleSearch = async () => {
        try {
            const response = await axios.get('/bbs/search', {
                params: {
                    type: searchType,
                    keyword: keyword
                }
            });
            setBbsList(response.data);   //검색 결과 표시
        }catch (error){
            console.error("에러발생", error);
        }

    }

    const handleClick = () => {
        navigate("/bbsdetails")
    }
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
            <table className="search">
                <tbody>
                <tr>
                    <td>
                        <select className="custom-select"
                                value={searchType}
                                onChange={(e)=>setSearchType(e.target.value)}

                        >
                            <option>검색 옵션 선택</option>
                            <option value="title"> 제목</option>
                            <option value="content"> 내용</option>
                            <option value="id"> 작성자</option>
                        </select>
                    </td>

                    <td>
                        <input type="text"
                               className="form-control"
                               placeholder="검색어"
                               value={keyword}
                               onChange={(e) => setKeyword(e.target.value)}
                        />
                    </td>
                    <td>
                        <button type="button"
                                className="btn btn-outline-secondary"
                                onClick={handleSearch}
                        >검색</button>
                    </td>
                </tr>
                </tbody>
            </table>

            {/*검색버튼*/}
            <div className="d-flex justify-content-end">
                <button onClick={goWrite} className="btn btn-info">글쓰기</button>
            </div>
            <table className="table table-hover">
                <thead>
                   <tr>
                        <th className="col-1">번호</th>
                        <th className="col-8">제목</th>
                        <th className="col-3">작성자</th>
                   </tr>
                </thead>

                <tbody>
                {
                    bbsList.map((bbs, idx)=>(
                        <tr key = {bbs.sequence}>
                            <td>{idx + 1}</td>
                            {/*<td  className="clickable" onClick={()=> handleClick(bbs.seq)}>{bbs.title}</td>*/}
                            <td><Link to={`/bbsdetail/${bbs.seq}`}>{bbs.title}</Link></td>
                            <td>{bbs.id}</td>
                        </tr>
                    ))



                }
                </tbody>
            </table>

        </div>

        </>
    );
};



export default BbsLIst;