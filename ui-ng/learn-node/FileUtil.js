let fs = require('fs');
let HashMap = require('hashmap');

const inputFile = './a.txt'

function readFileAndPrint() {
	let file1Data = fs.readFileSync(inputFile).toString().split("\n");

	let file2Data = fs.readFileSync('./b.txt').toString().split("\n");
	//console.log('Printing file a.txt');
	//console.log(file1Data[0]);
	/*file1Data.shift();
	file2Data.shift();

	file1Data.forEach((line) => {
		let count = 0;

		file2Data.forEach((line2) => {
			if (count == 0) {
				console.log('Line ------ ' + line);
				console.log('Line 2 ---- ' + line2);

				getdelta(line, line2)
			}
			count++;
		});
		file2Data.shift();
	})*/
	//console.log(file1Data[0]);
	let map1 = getAccPeriodNDataMap(file1Data);
	let map2 = getAccPeriodNDataMap(file2Data);

	let keys = map1.keys();
	map2.keys().forEach((key) => {
		keys.push(key);
	})


	var headRow = 'FileCompare'
	keys.forEach((key) => {
		if (headRow.indexOf(key.split(',')[1]) == -1){
			console.log(headRow.indexOf(key.split(',')[1]));
			headRow += ('\t' + key.split(',')[1]);
		}
	})
	console.log(headRow);

	let rows = '';
	keys.forEach((key) => {
		//key.split(',')[0]

		console.log(map1.get(key) + '  ' + map2.get(key));
	})

	//console.log(JSON.stringify(map));
}

function getAccPeriodNDataMap(fileData) {
	let map = new HashMap();
	let headers = (fileData[0]).split('\t');
	fileData.shift();

	//Remove first header
	headers.shift();

	fileData.forEach((line) => {
		let response = '';
		let datas = line.split('\t');
		let timePeriod = datas[0];
		datas.shift();
		let count = 0;
		datas.forEach((data) => {
			//map.set(,data);
			let account = headers[count++];
			//console.log(account);
			//response += '\t' + timePeriod + "::" + account + ' ' + data+' ';
			map.set(timePeriod + "," + account, data);

		});
	})

	return map;
}

function getdelta(a, b) {
	let lineData = a.split('\t');
	let line2Data = b.split('\t');

	let responseLine = '';
	lineData.forEach((data) => {
		let count = 0;

		line2Data.forEach((data2) => {
			if (count == 0) {
				//console.log(parseFloat(data2)-parseFloat(data));
				responseLine += (responseLine != '' ? '\t' + (parseFloat(data) - parseFloat(data2)) : (parseFloat(data) - parseFloat(data2)));
			}
			count++;
		});
		line2Data.shift();
	});
	console.log(responseLine);
}

module.exports = {
	readPrint: readFileAndPrint
}