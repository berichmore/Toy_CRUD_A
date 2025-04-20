import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";
import {Link, useLocation, useNavigate, useParams} from "react-router-dom";
import {deleteBbs, getBbsDetail} from "../api/bbsApi";
import {LoginContext} from "../context/LoginProvider";
import CommentList from "../comment/CommentList";
import CommentWrite from "../comment/CommentWrite";
import {AiFillHeart, AiOutlineHeart} from "react-icons/ai";
import {getLikeCount, toggleLike} from "../api/likeApi";


const BbsDetail = () => {

    const [bbs, setBbs] = useState({});
    const location = useLocation();  //라우터 state를 받기 위함.
    const {seq} = useParams();
    const navigate = useNavigate();

    //댓글 get
    const [reload, setReload] = useState(false);
    const handleCommentAdded = () => setReload(prev => !prev);

    //좋아요 수, 좋아요 상태
    const [likeCount, setLikeCount] = useState(0);
    const [liked, setLiked] = useState(false); //추후 서버에서 상태 받아올 경우 사용 가능

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


    // 모듈화된 코드 구현 / 글 데이터 + 좋아요 수
    useEffect(()=>{

        const fetchData = async ()=> {
        try {
            await increaseReadCount();
            const data = await getBbsDetail(seq);
            setBbs(data);

            const like = await getLikeCount(seq);
            setLikeCount(like);
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
    //좋아요 토글
    const handleLike = async () => {
        if(!loginUser){
            alert("좋아요는 로그인이 필요합니다");
            return;

    }try{
        const res = await toggleLike(seq);
        setLiked(res.liked);
        setLikeCount(res.likeCount);
    }catch (error){
            alert("좋아요 실패");
        }
    }


    
    
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
            <div className="mb-4 text-align-center">
                <button
                    className={`btn btn-${liked ? "danger" : "outline-secondary"} d-flex align-items-center`}
                    onClick={handleLike}
                    disabled={!loginUser}
                >
                    {/*아이콘 표시*/}
                    {liked ? <AiFillHeart size={20} className="me-1"/> : <AiOutlineHeart size={20} className="me-1" />}
                    {likeCount}
                </button>
            </div>
            <div>
                <Link className="btn btn-outline-secondary" to="/bbslist">글목록</Link>

                {loginUser && loginUser.id === bbs.id && (
                    <>
                <Link className="btn btn-outline-secondary" to={`/bbsupdate/${bbs.seq}`}>글수정</Link>
                <button className="btn btn-outline-secondary" onClick={handleDelete}>글삭제</button>
                    </>
            )}

                <CommentList bbsSeq={seq} reloadTrigger={reload}/>
                {/*댓글 작성 컴포넌트*/}
                {/*{*/}

                    <CommentWrite seq={seq} onCommentAdded={handleCommentAdded}/>
                {/*//     :*/}
                {/*//*/}
                {/*// null*/}
                {/*}*/}
                {/*댓글 리스트 컴포넌트*/}

            </div>




        </div>
    );
};

export default BbsDetail;