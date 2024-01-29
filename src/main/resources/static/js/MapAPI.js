// 관리자 건물 등록 주소 API 로딩
function sample4_execDaumPostcode() {
	new daum.Postcode({
        oncomplete: function(data) {
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("address").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';
            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}

// 사용자 건물 정보 보기 시작시 지도 로딩
window.onload = function () {
    let container = document.getElementById('buildMap');
    let address = document.getElementById('address').value;
    let inputDisabled = document.getElementsByTagName('input');
	let buildId = document.getElementById('buildId');
    let buildIdOptValue = buildId.options[buildId.selectedIndex].value;
    let buildIdOptText = buildId.options[buildId.selectedIndex].innerText;
    
    console.log('buildId :: ', buildId);
    console.log('buildIdOptValue :: ', buildIdOptValue);
    console.log('buildIdOptText :: ', buildIdOptText);

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
                content: '<div style="width:150px;text-align:center;padding:6px 0;">'+ buildIdOptText +'</div>'
            });
            infowindow.open(map, marker);

            map.setCenter(coords);
        }
    });

    for(let i = 0; i < inputDisabled.length; i++) {
        inputDisabled[i].readOnly = true;
    }
}

// 사용자 건물 정보 변경
function changeBuild() {
	let buildId = document.getElementById('buildId');
	let formId = document.getElementById('infoForm');
    let buildIdOptValue = buildId.options[buildId.selectedIndex].value;
    let buildIdOptText = buildId.options[buildId.selectedIndex].innerText;
	
	formId.submit();
}

