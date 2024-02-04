import React, { useEffect, useState } from 'react';
import Header from './component/Header.js';
import Footer from './component/Footer.js';
import BuildInfo from './component/BuildInfo.js';

function App() {
    return (
        <>
            <Header />
            <BuildInfo />
            <Footer />
        </>
    );
}

export default App;
