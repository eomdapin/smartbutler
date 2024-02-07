import React, { useEffect, useState } from 'react';
import Header from './Header.js';
import Footer from './Footer.js';
import axios from 'axios';
import MapLoad from './api/MapLoad.js';

function BuildInfo() {
    const [image, setImage] = useState([]);
    const [buildId, setBuildId] = useState(0);
    const [build, setBuild] = useState([
        {
            buildId: '',
            address: '',
            floor: '',
            area: '',
            comDate: '',
        }
    ]);

    useEffect(() => {
        axios.get('/user/buildings/build')
            .then(response => {
                setBuild(response.data[0])
                setImage(response.data[1])
            })
            .catch(error => console.log(error));
    }, []);

    useEffect(() => {
        axios.get(`/user/buildings/build?buildId=${buildId+1}`)
            .then(response => {
                setBuild(response.data[0])
                setImage(response.data[1])
            })
            .catch(error => console.log(error));
    }, [buildId]);

    const BuildChange = () => {
        const selectBuildId = document.getElementById('buildId');
        setBuildId(selectBuildId.value - 1);
        selectBuildId.value = buildId;
    }

    return (
        <>
            <Header />
            <div className="container" style={{ float: "none" }}>
                <div className="content form-content">
                    <h2 className="text-center mt-2">건물 정보</h2>
                    <form id="infoForm" className="infoForm" action="/user/buildings/info" method="get">
                        <div className="row g-3 justify-content-center align-items-center mb-4 mt-3">
                            <div className="col-7 mt-3 border-top border-5 border-black"></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="buildId" className="form-label">건물명</label></div>
                            <div className="col-5 mb-3">
                                <select className="form-select" id="buildId" name="buildId" onChange={BuildChange} value={buildId + 1}>
                                    {build.map((value, index) => {
                                        return (
                                            <option className="form-option" value={value.buildId} key={Date() + index}>
                                                {value.buildName}
                                            </option>
                                        );
                                    })}
                                </select>
                            </div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="address" className="form-label">주소</label></div>
                            <div className="col-5 mb-3"><input type="text" id="address" name="address" className="form-control" value={build[buildId]?.address || ''} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="area" className="form-label">면적</label></div>
                            <div className="col-5 mb-3"><input type="text" id="area" name="area" className="form-control" value={build[buildId].area} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="comDate" className="form-label">준공일</label></div>
                            <div className="col-5 mb-3"><input type="date" id="comDate" name="comDate" className="form-control" value={build[buildId].comDate} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="name" className="form-label">층수</label></div>
                            <div className="col-5 mb-3"><input type="text" id="floor" name="floor" className="form-control" value={build[buildId].floor} defaultChecked readOnly /></div>
                        </div>
                    </form>

                    {build[buildId] && build[buildId].address && <MapLoad address={build[buildId].address} />}

                    <div className="row g-3 justify-content-center align-items-center mb-4 mt-3">
                        <div className="col-7 mt-3 border-top border-5 border-black"></div>
                    </div>

                    <h3 className="text-center mt-2">건물 사진</h3>
                    <div id="carouselExampleIndicators" className="carousel slide" style={{ height: "800px" }}>
                        <div className="carousel-inner">
                            {image.map((image, index) => {
                                let carouselItem = 'carousel-item';

                                if (index === 0) {
                                    carouselItem += ' active';
                                }
                                return (
                                    <div className={carouselItem} key={Date() + index}>
                                        <img src={`/user/buildings/image?image=${image.name}`} className="d-block" style={{ height: "800px", margin: "0 auto" }} alt="건물 사진" />
                                    </div>
                                );
                            })}
                        </div>
                        <button className="carousel-control-prev background-color: rgba(255,255,255,0.3);" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                            <span className="carousel-control-prev-icon" aria-hidden="true"></span> <span className="visually-hidden">Previous</span>
                        </button>
                        <button className="carousel-control-next background-color: rgba(255,255,255,0.3);" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                            <span className="carousel-control-next-icon" aria-hidden="true"></span> <span className="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default BuildInfo;