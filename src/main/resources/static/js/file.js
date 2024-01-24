function ChangeFileName() {
	const fileNameInput = document.getElementById('fileName');
	const uploadFileInput = document.getElementById('uploadFile');

	if (uploadFileInput.value.length > 0) {
		fileNameInput.value = uploadFileInput.value.split('/').pop().split('\\').pop();
	}
}