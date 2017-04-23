//
// use the websocket module
//
var ws = require("nodejs-websocket")
//
// create the ws server, listen on port 80xx
//
var server = ws.createServer( function (conn) {

//  log all new connections
    console.log("Server: New connection")

//  when text is rcvd : log msg, convert to uppercase to 'prove' we got it & send it back
    conn.on("text", function (str) {
        console.log("Server: Received "+str)
        conn.sendText(str.toUpperCase()+" !!!")
    })

//  when closed : log msg 
    conn.on( "close", function( code, reason) {
        console.log("Server: Connection closed")
    })
}).listen(8001)
