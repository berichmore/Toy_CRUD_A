import React from 'react';

const Login = () => {
    return (
        <div>
            <table className="table">
                <tbody>
                <tr>
                    <th className="col-3">아이디</th>
                    <td>
                        <input type="text" size="50px"/>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" size="50px"/>
                    </td>
                </tr>
                </tbody>
            </table><br/>


            <div className="my-1 d-flex justify-content-center">
                <button className="btn btn-outline-secondary" >로그인</button>
    
            </div>

        </div>
    );
};

export default Login;