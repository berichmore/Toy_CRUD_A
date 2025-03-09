import React from 'react';
import {Route, Routes} from "react-router-dom";
import Home from "../app/Home";
import BbsLIst from "../bbs/BbsLIst";

const Router = () => {
    return (
     <Routes>
         <Route path="/" element={<Home/>}></Route>
         <Route path="/bbslist" element={<BbsLIst/>}></Route>
     </Routes>
    );
};

export default Router;