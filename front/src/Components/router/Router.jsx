import React from 'react';
import {Route, Routes} from "react-router-dom";
import Home from "../app/Home";
import BbsLIst from "../bbs/BbsLIst";
import Ex from "../ex/Ex";
import Login from "../member/Login";
import Logout from "../member/Logout";
import Join from "../member/Join";

const Router = () => {
    return (
     <Routes>
         <Route path="/" element={<Home/>}></Route>
         <Route path="/bbslist" element={<BbsLIst/>}></Route>
         <Route path="/ex" element={<Ex/>}></Route>

         <Route path="/login" element={<Login/>}></Route>
         <Route path="/join" element={<Join/>}></Route>
         <Route path="/logout" element={<Logout/>}></Route>

     </Routes>
    );
};

export default Router;