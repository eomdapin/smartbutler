function putClick() {
	if(confirm("수정하시겠습니까?")) {
		document.getElementById("editForm").submit();
	}
}

function deleteClick() {
	if(confirm("삭제하시겠습니까?")) {
		document.getElementById("deleteForm").submit();
	}
}