window.onload = function () {
    let container = document.getElementById('buildMap'); //지도를 담을 영역의 DOM 레퍼런스
    let address = document.getElementById('address').value;
    let buildName = document.getElementById('buildName').value;
    let inputDisabled = document.getElementsByTagName('input');

    let options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
    };

    let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

    let geocoder = new kakao.maps.services.Geocoder();

    geocoder.addressSearch(address, function (result, status) {
        if(status === kakao.maps.services.Status.OK) {
            let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            let marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });

            let infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ buildName +'</div>'
            });
            infowindow.open(map, marker);

            map.setCenter(coords);
        }
    });

    for(let i = 0; i < inputDisabled.length; i++) {
        inputDisabled[i].disabled = true;
    }
}
