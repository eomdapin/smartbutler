import React, { useEffect } from 'react';

const { kakao } = window;

// 사용자 건물 정보 보기 시작시 지도 로딩
function MapLoad({ address }) {

    useEffect(() => {
        const container = document.getElementById('buildMap');
        const buildId = document.getElementById('buildId');
        const buildIdOptText = buildId.options[buildId.selectedIndex].innerText;
        const options = { //지도를 생성할 때 필요한 기본 옵션
            center: new window.kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
            level: 3 //지도의 레벨(확대, 축소 정도)
        };

        const map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        const geocoder = new kakao.maps.services.Geocoder();

        geocoder.addressSearch(address, function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
                const coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                const marker = new kakao.maps.Marker({
                    map: map,
                    position: coords
                });

                const infowindow = new kakao.maps.InfoWindow({
                    content: '<div style="width:150px;text-align:center;padding:6px 0;">' + buildIdOptText + '</div>'
                });
                infowindow.open(map, marker);

                map.setCenter(coords);
            }
        });

    }, [address])

    return (
        <div>
            <div id="buildMap" className="w-100 text-center" style={{ height: "500px" }}></div>
        </div>
    );
}

export default MapLoad;