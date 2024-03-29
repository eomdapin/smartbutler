function FirstPage() {
    return (
        <div id="wrapIndex" className="text-center">
            <div className="container">
                <div className="row">
                    <div className="logo">
                        <img alt="로고" src="/img/logo.png" className="align-middle" width="64"
                            style={{verticalAlign: "top!important"}} />
                            <h1 style={{display: "inline-block", fontWeight: "900"}}>SMARTBUTLER</h1>
                    </div>
                </div>
                <div className="row justify-content-around my-5">
                    <div className="col-auto box">
                        <a href="/admin">
                            <img src="/img/adminLogin.png" alt="관리자" />
                        </a>
                    </div>
                    <div className="col-auto box">
                        <a href="/user">
                            <img src="/img/userLogin.png" alt="사용자" />
                        </a>
                    </div>
                    <div className="col-auto box">
                        <a href="/worker">
                            <img src="/img/workerLogin.png" alt="작업자" />
                        </a>
                    </div>
                </div>
                <div className="row"><span>Copyright &copy; 2024 SMARTBUTLER</span></div>
            </div>
        </div>

    );
}

export default FirstPage;