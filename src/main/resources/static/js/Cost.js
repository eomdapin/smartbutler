function sumCost() {
	let total = document.getElementById('total');
	let inputs = document.getElementsByTagName('input');
	let totalSum = 0;

	Array.from(inputs).forEach((element) => {
		if (element.getAttribute('type') === 'number') {
			totalSum += Number(element.value);
		}
	});

	total.value = totalSum;
	totalSum = 0;
}

function addCost() {
	let dateInput = new Date(document.getElementById('date').value);
	let dateYear = dateInput.getFullYear();
	let dateMonth = ('0' + (dateInput.getMonth() + 1)).slice(-2);
	let dateSum = dateYear + '-' + dateMonth + '-' + '01';

	document.getElementById('date').value = dateSum;
}

function sendCost() {
	if (confirm("관리비 전송 후에는 수정이 불가합니다.\n정말 전송하시겠습니까?")) {
		Array.from(document.getElementsByTagName('input')).forEach(element => {
			element.value = element.value.replace(/원/g, "");
			element.value = element.value.replace(/,/g, "");
		});

		document.getElementById('costForm').submit();
	}
}

window.onload = () => {
	let sumCost = document.getElementsByClassName('sumCost');

	Array.from(sumCost).forEach((element) => {
		if (Number(element.innerText) < 0) {
			element.style.color = 'blue';
			element.innerText = element.innerText.substring(1);
			element.innerText = '▼' + element.innerText;
		} else if (Number(element.innerText) > 0) {
			element.style.color = 'red';
			element.innerText = '▲' + element.innerText;
		}
	});
}