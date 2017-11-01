let nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
  service: 'gmail'
});

var mailOptions = {
  from: 'nstane88@gmail.com',
  to: 'narendermyname@gmail.com',
  subject: 'Sending Email using Node.js',
  text: 'That was easy!'
};

function sendEmail(){
	
	transporter.sendMail(mailOptions, function(error, info){
	  if (error) {
		console.log(error);
	  } else {
		console.log('Email sent: ' + info.response);
	  }
	});
	
}

module.exports = {
	sendEmail :sendEmail
}