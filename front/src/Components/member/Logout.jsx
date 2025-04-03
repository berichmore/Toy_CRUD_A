import React, {useContext, useEffect} from 'react';
import {useNavigate} from "react-router-dom";
import axios from "axios";
import {LoginContext} from "../context/LoginProvider";

const Logout = () => {
    const navigate = useNavigate();
    const {setLoginUser} = useContext(LoginContext);

    const logout = async () => {
        try{
            await axios.post("/member/logout", {},{withCredentials : true});
            setLoginUser(null); //전역상태 초기화
            alert("로그아웃 되었습니다.");
            navigate("/bbslist");
        }catch (error){
            console.error("로그아웃 실패: ", error);
            alert("로그아웃 중 문제 발생");
        }
    }

    useEffect( () => {
        logout();   //로그아웃 함수 호출!


    }, []);
    return (
        <div>
            로그아웃 중입니다..
        </div>

    );
};

export default Logout;