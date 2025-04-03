import React, {createContext, useEffect, useState} from 'react';
import axios from "axios";

//provider를 사용하기 위해 createCotext 생성
export const LoginContext = createContext(null);

const LoginProvider = ({children}) => {

    const [loginUser, setLoginUser] = useState(null);

    useEffect(() => {
        axios.get('/member/me', {withCredentials: true})
            .then((res) => setLoginUser(res.data))
            .catch((err) => setLoginUser(null));
    }, []);
    return (
        <LoginContext.Provider value={{loginUser, setLoginUser}}>
            {children}
        </LoginContext.Provider>

    );
};

export default LoginProvider;