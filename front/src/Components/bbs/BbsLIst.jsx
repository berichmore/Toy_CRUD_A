import React from 'react';

const BbsLIst = () => {
    return (
        <div>
            <table>
                <tr>
                    <td>
                        <select className="custom-select">
                            <option>검색 옵션 선택</option>
                            <option> 제목 </option>
                            <option> 내용 </option>
                            <option> 작성자 </option>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
    );
};

export default BbsLIst;