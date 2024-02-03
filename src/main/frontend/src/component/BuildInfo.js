import React, { useEffect, useState } from 'react';
import axios from 'axios';

function changeBuild() {

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

    const clear = () => {
        setBuild('');
        setImage('');
    }

    let buildId = 0;
    console.log(build);

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
                                </select>
                            </div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label for="address" className="form-label">주소</label></div>
                            <div className="col-5 mb-3"><input type="text" id="address" name="address" className="form-control" value={build[0].address} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label for="area" className="form-label">면적</label></div>
                            <div className="col-5 mb-3"><input type="text" id="area" name="area" className="form-control" value={build[0].area} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label for="comDate" className="form-label">준공일</label></div>
                            <div className="col-5 mb-3"><input type="date" id="comDate" name="comDate" className="form-control" value={build[0].comDate} defaultChecked readOnly /></div>
                        </div>
                        <div className="row g-3 justify-content-center align-items-center mb-4">
                            <div className="col-2 mb-3"><label for="name" className="form-label">층수</label></div>
                            <div className="col-5 mb-3"><input type="text" id="floor" name="floor" className="form-control" value={build[0].floor} defaultChecked readOnly /></div>
                        </div>
                    </form>
                </div>
            </div>
        </>
    );
}

export default BuildInfo;