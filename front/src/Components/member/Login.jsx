import React, {useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";

const Login = () => {

    const navigate = useNavigate();
    const { setLogin} = useState(null);

    const [id, setId] = useState("");
    const [pwd, setPwd] = useState("");


    const login = async () => {

        try{
        const response = await axios.post("/member/login",
            {id, pwd
            }, {
            withCredentials: true
            });
        console.log("로그인 성공", response.data);
        setLogin(response.data);
        alert(response.data.name + "님, 로그인 되었습니다.");
        navigate("/bbslist");


    } catch (error){
            console.error("로그인 실패", error.response.data);
            alert(error.response.data || "로그인 중 오류 발생");
        }
    };

    const checkLogin = async () => {
        try{
            const response = axios.get("/member/me", {
              withCredentials: true
            });
            alert("로그인상태입니다")

        }catch(error){
            console.error("로그인 상태 아님: " , error.response.data || error.message);
        }
    }

    // const getBbsList = () =>{
    //     axios.get("/bbs/list")
    //         .then((response)=> {
    //             console.log(response.data);
    //             setBbsList(response.data)
    //         })
    //         .catch((error)=>{}
    //         )
    // }

    return (
        <div>
            <table className="table">
                <tbody>
                <tr>
                    <th className="col-3">아이디</th>
                    <td>
                        <input type="text" size="50px"
                        value={id}
                               onChange={(e)=> setId(e.target.value)}
                        />
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" size="50px"
                        value={pwd}
                               onChange={(e)=> setPwd(e.target.value)}
                        />
                    </td>
                </tr>
                </tbody>
            </table><br/>


            <div className="my-1 d-flex justify-content-center">
                <button className="btn btn-outline-secondary"
                        onClick={login}
                >로그인</button>

                <button
                className="btn-outline-secondary"
                onClick={checkLogin}
                >로그인 상태 체크</button>
    
            </div>

        </div>
    );
};

export default Login;