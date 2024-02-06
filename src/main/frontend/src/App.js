import { BrowserRouter, Route, Routes } from 'react-router-dom';
import BuildInfo from './component/BuildInfo.js';
import FirstPage from './component/FirstPage.js';

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<FirstPage />} />
                    <Route path="/user/buildings/info" element={<BuildInfo />} />
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
