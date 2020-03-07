var express = require('express');
var app = express();
var simulateLatency = require('express-simulate-latency');
// use as middleware for all subsequent handlers...
var smallLag = simulateLatency({ min: 3000, max: 3000 });
/*function msleep(n) {
    Atomics.wait(new Int32Array(new SharedArrayBuffer(4)), 0, 0, n);
}

function sleep(n) {
    msleep(n*1000);
}*/

app.use(smallLag);


function rootFunction(req,res){
    console.log('root request received');
    res.sendStatus(200);
}

app.get('/', function(req,res){
    rootFunction(req,res);
});

app.get('/login', async function (req, res) {
    console.log('login request received');
    res.sendStatus(200);
});

app.get('/user', async function (req, res) {
    console.log('user request received');
    res.sendStatus(200);
});

app.get('/posts', async function (req, res) {
    console.log('posts entries request received');
    res.sendStatus(200);
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});
