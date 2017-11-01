let emailUtil =  require('./email-util');
let fileUtil = require('./FileUtil');

let logger = console.log;

function send(){
	//emailUtil.sendEmail();

}
//send();

(()=>{
	//logger.log('Stat script');
	fileUtil.readPrint();
})();

process.argv.forEach((val, index, array)=>{
	console.log('----'+val);
});