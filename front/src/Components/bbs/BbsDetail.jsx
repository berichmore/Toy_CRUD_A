import React from 'react';
import axios from "axios";

const BbsDetail = () => {

    const getBbsDetails = () => {

        axios.get(`/bbsdetail/`)

    }
    
    
    return (

        <div>
            <h1>글보기</h1>
            <table className="table table-striped">
                <tbody>
                    <tr>
                        <th className="col-3">작성자</th>
                        <td>
                            {/*<span>{bbs.id}</span>*/}
                        </td>
                    </tr>
                    <tr>
                            <th className="col-3">제목</th>
                            <td>
                                {/*<span>{bbs.id}</span>*/}
                            </td>
                        </tr>
                    <tr>
                            <th className="col-3">작성일</th>
                            <td>
                                {/*<span>{bbs.id}</span>*/}
                            </td>
                        </tr>
                    <tr>
                            <th className="col-3">조회수</th>
                            <td>
                                {/*<span>{bbs.id}</span>*/}
                            </td>
                        </tr>
                    <tr>
                            <th className="col-3">내용</th>
                            <td>
                                {/*<span>{bbs.id}</span>*/}
                            </td>
                        </tr>

                </tbody>
            </table>



        </div>
    );
};

export default BbsDetail;