import React from 'react';

const Join = () => {
    return (
        <div>
            Join
            <h1>회원가입</h1> &nbsp; &nbsp;
            <table className="table">
                <tbody>
                    <tr>
                        <th className="col-2">아이디</th>
                            <td>
                                <input type="text" size="50px" />&nbsp; &nbsp;
                                <button className="btn btn-outline-danger">아이디 중복 확인</button>
                            </td>
                    </tr>

                    <tr>
                        <th>이름</th>
                        <td>
                            <input type="text" size="50px" />
                        </td>
                    </tr>
                    
                    <tr>
                        <th>비밀번호</th>
                        <td>
                            <input type="password" size="50px" />
                        </td>
                    </tr>

                    <tr>
                        <th>비밀번호 확인</th>
                        <td>
                            <input type="password" size="50px" />
                        </td>
                    </tr>

                    <tr>
                        <th>이메일</th>
                        <td>
                        <input type="text" size="100px" />
                        </td>
                    </tr>
                </tbody>
            </table><br/>
            <div className="my-3 d-flex-justify-content-center">
                <button className="btn btn-outline-secondary">회원가입</button>
            </div>
        </div>
    );
};

export default Join;