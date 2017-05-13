var express = require('express');
var morgan = require('morgan');
var bodyParser = require('body-parser');
var redis = require('redis');
var crypto = require('crypto');

var PORT = process.env.PORT || 8080;

var app = express();

app.use(morgan('[:date[iso]] :method :url\t:status'));
app.use(bodyParser.json({ type: 'application/json' }))

var db = redis.createClient(process.env.DB_PORT, process.env.DB_HOST, {});

db.on('connect', function() {
    console.log('Connected to Redis');
});

db.set('healthCheck','iam ok');
db.set('Kalman', 'pwd123');
db.set('Victor','pwd123');


var token = 'askljkfds123242'

function getFromDB(value,callback) {
  return db.get(value, callback);
}

function createToken(userName){
  var secret = 'a'+new Date().getTime();
  return crypto.createHmac('sha256',secret).update(userName).digest('hex');
}

app.get('/auth/healthCheck', function(req,res){
  getFromDB('healthCheck',function(err,reply){
    var rtrn = (reply == null ? "i am not healthy" : reply);
    res.status(200).send({healthCheck : rtrn });
  })
});


app.post('/auth/login', function (req, res) {
  getFromDB(req.body.userName, function(err,reply){
    if (reply === req.body.userPassword){
      var token = createToken(req.body.userName);
      var validTo = new Date().getTime() + 600000;
      db.set('Bearer '+token,validTo);
      var response = {
        userName: req.body.userName,
        token: token,
        validTo: validTo
      }
      res.status(200).send(JSON.stringify(response));
    }
    else {
      var response = {
        status: 403,
        message: 'wrong username or password'
      }
      res.status(403).send(JSON.stringify(response));
    }
  })
});

app.post('/auth/check', function (req, res){
  getFromDB(req.body.token, function(err,reply){
    console.log('r is: '+reply);
    var validTo = (reply != null ? reply : 0);
    console.log('v is: '+validTo);
    console.log('c is: '+new Date().getTime());
    console.log('validTo > currentTime : '+ (validTo > new Date().getTime()));
    if (validTo > new Date().getTime()){
      res.status(204).end();
    } else {
      res.status(403).end();
    }
  })
});

app.post('/auth/register', function(req, res){
  getFromDB(req.body.userName, function(err,reply){
    if (reply != null){
      var response = {
        status : 400,
        message : 'user already exists'
      }
      res.status(400).send(JSON.stringify(response));
    } else {
      db.set(req.body.userName, req.body.userPassword);
      res.status(204).end();
    }
  })
})

// Launch server
app.listen(PORT);
console.log('Running on http://localhost:' + PORT);
