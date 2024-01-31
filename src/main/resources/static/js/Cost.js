function sumCost() {
	let total = document.getElementById('total');
	let inputs = document.getElementsByTagName('input');
	let totalSum = 0;

	Array.from(inputs).forEach((element) => {
		if(element.getAttribute('type') === 'number') {
			totalSum += Number(element.value);
		}
	});

	total.value = totalSum;
	totalSum = 0;

	console.log('total >>> ', total.value);
}

function addCost() {
	let dateInput = new Date(document.getElementById('date').value);
	let dateYear = dateInput.getFullYear();	
	let dateMonth =  ('0' + (dateInput.getMonth() + 1)).slice(-2);
	let dateSum = dateYear + '-' + dateMonth + '-' + '01';
	
}
