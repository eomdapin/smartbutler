import React from 'react';

function Header({ isLogin }) {
    return (
        <header className="d-flex justify-content-between">
            <div className="d-flex align-items-center">
                <div className="logo"><img alt="로고" src="/img/logo.png" className="align-middle" width="64" /></div>
                <div><h1><a href="/user" className="logo-text">SMARTBUTLER</a></h1></div>
            </div>
            <div className="d-flex align-items-center" style={{ gap: "50px", marginRight: "200px" }}>
                <div><a href="/user/buildings/info">메인으로</a></div>
                <div><a href="/user">건물 정보 보기</a></div>
            </div>
        </header>
    );
}

export default Header;