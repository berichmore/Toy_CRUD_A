import logo from './logo.svg';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import Header from "./Components/app/Header";
import Nav from "./Components/app/Nav";
import Main from "./Components/app/Main";
import Footer from "./Components/app/Footer";
import {useEffect, useState} from "react";
import "./css/style.css"



function App() {
  return (
    <div className="App">
     <BrowserRouter>

         <Header/>

         <Nav/>
         <Main/>

         <Footer/>



     </BrowserRouter>
    </div>
  );
}

export default App;
