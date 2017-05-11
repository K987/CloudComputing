var express = require('express');
var morgan = require('morgan');
var bodyParser = require('body-parser');
var redis = require('redis');

var PORT = process.env.PORT || 8080;

var app = express();

app.use(morgan('[:date[iso]] :method :url\t:status'));
app.use(bodyParser.json({ type: 'application/json' }))

var client = redis.createClient(process.env.DB_PORT, process.env.DB_HOST, {});
client.set('healthcheck','iam ok');

client.on('connect', function() {
    console.log('Connected to Redis');
});


var token = 'askljkfds123242'

function getHealth(callback) {
  return client.get('healthcheck', callback);
}

app.get('/auth/healthCheck', function(req,res){
  getHealth(function(err,reply){
    var rtrn = (reply == null ? "i am not healthy" : reply);
    res.status(200).send({healthCheck : rtrn });
  })
      //res.status(200).send('ok');
});


app.post('/auth/login', function (req, res) {
  if ( req.body.userName === 'Kalman' && req.body.userPassword === 'pwd123') {
    var response = {
      userName: req.body.userName,
      token: token,
      validTo: 7200
    }
    res.status(200).send(JSON.stringify(response));
  } else {
    var response = {
      status: 403,
      message: 'wrong username or password'
    }
    res.status(403).send(JSON.stringify(response));
  }
});

app.post('/auth/check', function (req, res){
  if (req.body.token === 'Bearer '+token){
    res.status(204).end();
  } else {
    res.status(403).end();
  }
});


// Launch server
app.listen(PORT);
console.log('Running on http://localhost:' + PORT);
