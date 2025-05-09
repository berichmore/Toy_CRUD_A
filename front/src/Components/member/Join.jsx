import React, {useState} from 'react';
import {useNavigate} from "react-router-dom";
import axios from "axios";

const Join = () => {
        const [form, setForm] = useState({
            id:"",
            name:"",
            pwd:"",
            pwdConfirm:"",
            email:""

        });
        const [isIdChecked, setIsIdChecked] = useState(false);   //아이디 중복여부확인

        const navigate = useNavigate();

        const handleChange = (e) =>{
            setForm({
                ...form,
                [e.target.name]: e.target.value
            });
            if(e.target.name === "id") setIsIdChecked(false); //아이디 바꾸면 다시 체크
        };

        const checkDuplicate = async() => {
            if(!form.id){
                alert("아이디를 입력하세요 ")
                return;
            }
            try {
                const res = await axios.get(`/member/check?id=${form.id}`);
                if (res.data){
                    alert(" 이미 존재하는 아이디 입니다.")
                }else{
                    alert(" 사용 가능한 아이디 입니다.")
                    setIsIdChecked(true);
                }
            }catch (e) {
                console.error(e);
                alert("중복 확인 실패")
            }
        }


        const handleJoin = async() => {
            if(form.pwd !== form.pwdConfirm){
                alert("비밀번호가 일치하지 않습니다.");
                return;
            }
            try {
                await axios.post("/member/join", {
                    id: form.id,
                    pwd: form.pwd,
                    name: form.name,
                    email: form.email
                });
                alert("회원가입 성공");
                navigate("/login")

            }catch (error) {
                console.error("회원가입 실패", error)
                alert("회원가입 실패");

            }

        }





    return (
        <div>
            <h1>회원가입</h1> &nbsp; &nbsp;
            <table className="table">
                <tbody>
                    <tr>
                        <th className="col-2">아이디</th>
                            <td className="flex container">
                                <input type="text"
                                       name="id"
                                       value={form.id}
                                       onChange={handleChange}
                                       className="form-control w-25"
                                />
                                &nbsp; &nbsp;
                                <button className="btn btn-outline-danger"
                                        onClick={checkDuplicate}
                                >아이디 중복 확인</button>
                            </td>
                    </tr>

                    <tr>
                        <th>이름</th>
                        <td>
                            <input type="text"
                                   name="name"
                                   value={form.name}
                                   onChange={handleChange}
                                   className="form-control w-25"
                            />
                        </td>
                    </tr>
                    
                    <tr>
                        <th>비밀번호</th>
                        <td>
                            <input type="password"
                                   name="pwd"
                                   value={form.pwd}
                                   onChange={handleChange}
                                   className="form-control w-25"
                            />
                        </td>
                    </tr>

                    <tr>
                        <th>비밀번호 확인</th>
                        <td>
                            <input type="password"
                                   name="pwdConfirm"
                                   value={form.pwdConfirm}
                                   onChange={handleChange}
                                   className="form-control w-25"
                            // name="pwdConfirm"
                            />
                        </td>
                    </tr>

                    <tr>
                        <th>이메일</th>
                        <td>
                        <input type="text"
                               name="email"
                               value={form.email}
                               onChange={handleChange}
                               className="form-control w-25"
                        />
                        </td>
                    </tr>
                </tbody>
            </table><br/>
            <div className="my-3 d-flex-justify-content-center">
                <button className="btn btn-outline-secondary"
                        onClick={handleJoin}
                >회원가입</button>
            </div>
        </div>
    );
};

export default Join;