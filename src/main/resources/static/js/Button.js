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

function claimFinClick() {
	if(confirm("민원을 완료 처리하시겠습니까?")) {
		document.getElementById("claimFinForm").submit();
	}
}

function estimateClick() {
	if(confirm("견적을 완료 처리하시겠습니까?")) {
		document.getElementById("estimateForm").submit();
	}
}