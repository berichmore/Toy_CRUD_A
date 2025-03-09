import React from 'react';
import Router from "../router/Router";

const Main = () => {
    return (
        <main>
            <div className="py-4">
            <div className="container">
                <Router></Router>
            </div>
            </div>
        </main>
    );
};

export default Main;