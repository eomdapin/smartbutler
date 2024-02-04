import React, { useEffect, useState } from 'react';
import axios from 'axios';
import MapLoad from './api/MapLoad.js';

function buildChange() {

}

function BuildInfo() {
    const [build, setBuild] = useState([
        {
            address: '',
            floor: '',
            area: '',
            comDate: '',
        }
    ]);
    const [image, setImage] = useState([]);

    useEffect(() => {
        axios.get('/user/buildings/build')
            .then(response => setBuild(response.data))
            .catch(error => console.log(error))

        axios.get('/user/buildings/images')
            .then(response => setImage(response.data))
            .catch(error => console.log(error))
    }, []);

    let buildId = 0;
    console.log(image);

    return (
        <>
            <div className="container">
                <div className="content form-content">
                    <h2 className="text-center mt-2">건물 정보</h2>
                    <form id="infoForm" className="infoForm" action="/user/buildings/info" method="get">
                        <div className="row g-3 justify-content-center align-items-center mb-4 mt-3">
                            <div className="col-7 mt-3 border-top border-5 border-black"></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="buildId" className="form-label">건물명</label></div>
                            <div className="col-5 mb-3">
                                <select className="form-select" id="buildId" name="buildId" onChange="changeBuild()">
                                    {build.map((value, index) => {
                                        return (
                                            <option className="form-option" value={value.buildId} key={Date() + index}>
                                                {value.buildName}
                                            </option>
                                        );
                                    })}
                                    {document.getElementsByClassName('carousel-item').item(0).className += ' active'}
                                </select>
                            </div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="address" className="form-label">주소</label></div>
                            <div className="col-5 mb-3"><input type="text" id="address" name="address" className="form-control" value={build[0].address} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="area" className="form-label">면적</label></div>
                            <div className="col-5 mb-3"><input type="text" id="area" name="area" className="form-control" value={build[0].area} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="comDate" className="form-label">준공일</label></div>
                            <div className="col-5 mb-3"><input type="date" id="comDate" name="comDate" className="form-control" value={build[0].comDate} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label htmlFor="name" className="form-label">층수</label></div>
                            <div className="col-5 mb-3"><input type="text" id="floor" name="floor" className="form-control" value={build[0].floor} defaultChecked readOnly /></div>
                        </div>
                    </form>
                    <MapLoad />
                    <div className="row g-3 justify-content-center align-items-center mb-4 mt-3">
                        <div className="col-7 mt-3 border-top border-5 border-black"></div>
                    </div>

                    <h3 className="text-center mt-2">건물 사진</h3>
                    <div id="carouselExampleIndicators" className="carousel slide" style={{ height: "800px" }}>
                        <div className="carousel-inner">
                            {image.map((image, index) => {
                                let active = '';
                                if(index == 0) {
                                    active = 'active';
                                }
                                return (
                                    // <div className={`carousel-item ${active}`} key={Date() + index}>
                                    <div className='carousel-item' key={Date() + index}>
                                        <img src={`/web-img/${image.name}`} className="d-block" style={{ height: "800px", margin: "0 auto" }} alt="건물 사진" />
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
        </>
    );
}

export default BuildInfo;