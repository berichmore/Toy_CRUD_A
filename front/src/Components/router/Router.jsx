import React from 'react';
import {Route, Routes} from "react-router-dom";
import Home from "../app/Home";
import BbsLIst from "../bbs/BbsLIst";
import Ex from "../ex/Ex";

const Router = () => {
    return (
     <Routes>
         <Route path="/" element={<Home/>}></Route>
         <Route path="/bbslist" element={<BbsLIst/>}></Route>
         <Route path="/ex" element={<Ex/>}></Route>
     </Routes>
    );
};

export default Router;