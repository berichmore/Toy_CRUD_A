import React, {useContext} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from "react-router-dom";
import {LoginContext} from "../context/LoginProvider";

const Nav = () => {
    const {loginUser } = useContext(LoginContext);// 로그인 상태 가져오기

    return (
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
            <div className="container-fluid">

                {/*게시판*/}
                <a className="navbar-brand" href="/bbslist">게시판 </a>

                {/*반응형 토글 버튼*/}
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                {/*네비게이션 메뉴*/}
                <div className="collapse navbar-collapse" id="navbarScroll">
                    <ul className="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
                        style={{ "--bs-scroll-height": "100px" }}>

                        {/*메인 화면*/}
                        <li className="nav-item">
                            <a className="nav-link active" aria-current="page" href="/">Home</a>
                        </li>

                        <li className="nav-item">
                            <a className="nav-link" href="/ex">Ex</a>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                Link
                            </a>
                            <ul className="dropdown-menu">
                                <li><a className="dropdown-item" href="https://ko.legacy.reactjs.org/" target="_blank">리액트 학습</a></li>
                                <li><a className="dropdown-item" href="#">리액트 배우기</a></li>
                                <li>
                                    <hr className="dropdown-divider"/>
                                </li>
                                <li><a className="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li className="nav-item">

                        </li>
                    </ul>
                    {/*로그인 상태에 따라 다르게 보여주기*/}
                    <ul className="navbar-nav ml-auto">
                        {loginUser ? (
                            <>

                        {/*회원정보*/}
                        <li className="nav-item">
                            <span className="nav-link">{loginUser.name}님 반갑습니다</span>
                        </li>
                        {/*로그아웃*/}
                        <li className="nav-item">
                            <Link className="nav-link" to="/logout">로그아웃</Link>
                        </li>
                        </>
                            ): (
                            <>
                                 {/*로그인 안된 사용자 : 로그인 + 회원가입*/}

                        {/*로그인*/}

                        <li className="nav-item">
                            <Link className="nav-link" to="/login">로그인</Link>
                        </li>
                        {/*회원가입*/}
                        <li>
                            <Link className="nav-link" to="/join">회원가입</Link>
                        </li>
                    </>
                    )}
                    </ul>

                </div>
            </div>
        </nav>
    );
};


export default Nav;