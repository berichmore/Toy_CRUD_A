import React, {useContext, useEffect, useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {LoginContext} from "../context/LoginProvider";
// import alert from "bootstrap/js/src/alert";


const BbsWrite = () => {


    // const [auth, setAuth] = useContext(AuthCon)


    const [aid,setAid] = useState("");
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");
    const navigate = useNavigate();

    const {loginUser} = useContext(LoginContext);


    const changeTitle = (e) => {
        setTitle(e.target.value);
    }
    const changeContent = (e) => {
        setContent(e.target.value);
    }

    const changeAnonymousId = (e)=>{
        setAid(e.target.value);

    }

    const createBbs = async() => {


        const req = {
            // id : localStorage.getItem("id"),
            id : loginUser.id,
            title : title,
            content : content
        }
        await axios.post("/bbs", req)
            .then((res)=>{
                console.log(res.data);

                // alert(res.data.message("안녕하세요 "));
                alert("이런이런 부트스트랩");
                // alert(res.data);
                // alert(res.data.message);
                navigate('/bbslist');


        })
            // .catch(err=> console.log(err));

        .catch((err)=>{
            console.log("글 등록이 실패했습니다.")
            alert("글 등록이 실패했습니다.");
        })

    }

    useEffect(() => {
        if(!loginUser){
            alert("로그인이 필요합니다.")
            navigate("/login");
        }

        // alert("로그인한 사용자만 게시글을 작성할 수 있습니다.");

    },[loginUser]);


    return (
        <div>
            <h1>글쓰기 페이지</h1>
            <table className="table">
                <tbody>
                    <tr>
                        <th className="table-primary">작성자</th>
                        <td>
                            <input
                                type="text"
                                className="form-control"
                                // value={localStorage.getItem("id")}
                                value={loginUser ? loginUser.id : ""}
                                // onChange={(e)=> setAid(e.target.value)}
                                // value={id}

                                size="50px"
                                readOnly
                            />
                        </td>
                    </tr>
                 <tr>
                        <th className="table-primary">제목</th>
                        <td>
                            {/*<input*/}
                            {/*    type="text"*/}
                            {/*    className="form-control"*/}
                            {/*    value={title}*/}
                            {/*    size="50px"*/}
                            {/*    // readOnly*/}
                            {/*/>*/}
                            <textarea className="form-control" value={title} onChange={changeTitle}></textarea>
                        </td>
                    </tr>
                 <tr>
                        <th className="table-primary">내용</th>
                        <td>
                            <textarea className="form-control" value={content} onChange={changeContent} rows={10}></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div className="my-5 d-flex justify-content-center">
                <button className="btn btn-outline-secondary"
                        onClick={createBbs}
                > 등록</button>
            </div>

        </div>
    );
};

export default BbsWrite;