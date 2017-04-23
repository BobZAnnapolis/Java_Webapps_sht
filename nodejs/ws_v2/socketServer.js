var http = require("http");
var socketio = require("socketio");
var connect = require("connect");
var serveStatic = require('serve-static');
var app = connect();
var server;
var io;


app.use(serveStatic("public"));
app.listen(8050);

app.on("connection", function(socket) {
    socket.on("message", function(data) {
        socket.emit("echo", data);
    })
});

