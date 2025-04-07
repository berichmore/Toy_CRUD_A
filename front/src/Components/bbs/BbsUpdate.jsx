import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import {getBbsDetail,putBbsDetail} from "../api/bbsApi";
import axios from "axios";
axios.defaults.withCredentials =true;

const BbsUpdate = () => {
    const {seq} = useParams();
    const navigate = useNavigate();
    const [form, setForm] = useState({
        title: '',
        content: ''
    });

    // const getBbs


    //기존 글 불러오기
    useEffect(() => {

        const fetchBbs = async () => {
            try {
                const data = await getBbsDetail(seq);
                setForm({
                    title: data.title,
                    content: data.content

                });
            }catch (error){
                console.error("게시글 불러오기 실패", error)
            }
        }
        fetchBbs();
    }, [seq]);


    //수정 버튼 활성화
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await putBbsDetail(seq, form);
            alert("수정이 완료되었습니다.");
            navigate(`/bbsdetail/${seq}`);
        }catch (error){
            console.error("수정 실패")
            alert("수정 실패");
        }
    }




    return (
        // <div>
        //     <h1>UpdatePage</h1>

            <div className="container">
                <h2>게시글 수정</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>제목</label>
                        <input type="text" name="title"
                               value={form.title}
                               className="form-control"
                               onChange={(e)=>
                                    setForm({...form, [e.target.name]: e.target.value})
                        }
                        />
                    </div>
                    <div className="form-group">
                        <label>내용</label>
                        <textarea name="content"
                                  value={form.content}
                                  className="form-control"
                                  rows="5"
                                  onChange={(e)=> setForm({...form, [e.target.name]: e.target.value})}
                        />
                    </div>
                    <button type="submit"
                            className="btn btn-primary mt-3"

                    >수정하기</button>
                </form>
            {/*</div>*/}


        </div>
    );
};

export default BbsUpdate;