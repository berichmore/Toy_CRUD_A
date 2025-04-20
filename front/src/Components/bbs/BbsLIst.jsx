import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";
// response.data.totalCount = undefined;
const BbsLIst = () => {

    //페이지네이션
    const [page, setPage] = useState(1);
    const [size, setSize] = useState(10);
    //총 게시물 수
    const [totalCount, setTotalCount] = useState(0);
    //전체 페이지 수 계산
    const totalPages = Math.ceil(totalCount / size);
    const maxPageButtons = 5;
    const startPage = Math.floor((page-1)/ maxPageButtons) * maxPageButtons + 1;
    const endPage = Math.min(startPage + maxPageButtons -1, totalPages);


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


    // 게시글 목록
    const getBbsList = () =>{
        axios.get("/bbs/list", {
            params: {
                page: page,
                size: size
            }
        })

            .then((response)=> {
                console.log(response.data);
                setBbsList(response.data.bbsList);
                setTotalCount(response.data.totalCount);
            })
            .catch((error)=>{}
            )
    }

    useEffect(()=>{
        // getBbsList("","",1);
        getBbsList();
    },[page]);

    const changePage = (page) =>{
        setPage(page);
        // getBbsList();

    }




    return (
        <>
            <div>
                <table className="search">
                    <tbody>
                    <tr>
                        <td>
                            <select className="custom-select"
                                    value={searchType}
                                    onChange={(e) => setSearchType(e.target.value)}

                            >
                                {/*검색버튼*/}
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
                            >검색
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>



                {/*게시물 수 + 글쓰기 버튼*/}
                <div className="d-flex justify-content-between align-items-center">
                    <div style={{marginLeft: '10px', fontWeight: 'bold'}}>
                        전체 게시물 수: {totalCount}
                    </div>
                    <button onClick={goWrite} className="btn btn-info">글쓰기</button>
                </div>


                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th className="col-1">번호</th>
                        <th className="col-8">제목</th>
                        <th className="col-2">❤️ 좋아요</th>
                        <th className="col-3">작성자</th>
                    </tr>
                    </thead>

                    <tbody>
                    {
                        bbsList.map((bbs, idx) => (
                            <tr key={bbs.sequence}>
                                <td>{bbs.seq}</td>
                                {/*<td  className="clickable" onClick={()=> handleClick(bbs.seq)}>{bbs.title}</td>*/}
                                <td><Link to={`/bbsdetail/${bbs.seq}`}>{bbs.title}</Link></td>
                                <td>{bbs.likeCount}</td>
                                <td>{bbs.id}</td>
                            </tr>
                        ))


                    }
                    </tbody>
                </table>
                <div className="d-flex justify-content-center">
                <nav aria-label="Page navigation example">
                    <ul className="pagination">
                        {/*이전페이지*/}
                        <li className={`page-item ${page === 1 ? "disabled" : ""}`}>
                            <button className="page-link" onClick={()=>changePage(startPage-1)}>&laquo;</button>

                        </li>
                        {/*페이지 번호 목록*/}
                        {Array.from({length: endPage - startPage + 1}, (_, idx) => startPage +idx ).map((num)=>(
                            <li key  = {num} className = {`page-item ${page === num ? "active" : ""}`}>
                                <button className="page-link" onClick={()=> changePage(num)}>
                                    {num}
                                </button>
                            </li>
                            ))}
                        <li className={`page-item ${page === totalPages ? "disabled" : ""}`}>
                            <button className="page-link" onClick={() => changePage(endPage+1)}>&raquo;</button>

                        </li>
                    </ul>
                </nav>
                </div>
            </div>

        </>
    );
};


export default BbsLIst;