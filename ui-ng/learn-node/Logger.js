const fs = require('fs');
const log_dir = "./log/";
const m = require('moment');
const log_name = log_dir + 'app.log';


let log_file;
let log_stdout;
(() => {

    if (!fs.existsSync(log_dir)) {
        fs.mkdirSync(log_dir);
    }

    if (!fs.existsSync(log_name)) {
        log_file = fs.createWriteStream(log_name, { flags: 'w' });
    }
    log_stdout = process.stdout;

})();

exports.log = (message) => {
   
    let line = "[" + m(new Date()).format() + "] " + message + "\n";
    log_stdout.write(line);
    if (log_file) {
        log_file.write(line);
    } else {
        fs.appendFileSync(log_name, line);
    }
}

