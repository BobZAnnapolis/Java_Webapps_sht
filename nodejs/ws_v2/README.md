Development Environment :
- iMac 0 OS X El Capitan
- language : nodes - v5.10; 
  - module : nam install nodejs-websockets

created a new directory
did an npm init
did an npm install nodejs-websocket
Only have 2 source files :
  websocketServer.js
    - include nodejs-websocket module
    - create the web socket server
      - process connection msgs
      - listen for & process “text rcvd” msgs
      - process closed msgs
  websocketClient.html
    - connect to above server
    - display text rcvd from server
    - send screen text to ws server
  node_modules folder containing the nodejs-websocket stuff


to run - all i needed to do from a command line was enter :
> node websocketServer.js


TESTING
=======
started Safari & FireFox browsers
started the developer tools console in both to watch the console.log msgs
open the websocketClient.html file
enter text, hit return 
verify screen and each browser’s consoles displayed expected messages & text
FireFox browser showed “UPGRADE” 

example output from server terminal session :
    bobzawislak (master) ws $ node websocketServer.js 
    Server: New connection
    Server: Received safari   - client displayed “Result: SAFARI !!!
    Server: Received firefox - client displayed “Result: FIREFOX !!!
    Server: Connection closed
    Server: New connection


I’m not exactly sure why this worked right out of the box on Safari and not on FireFox.
FireFox would always display the “new connection” and “connection closed” messages but sometimes wouldn’t process the onchanged msg
sometimes it would, sometimes not


i've been using the mac at home to research different languages and technologies.
as a result, several different things have been installed on it; vagrant, docker, ansible, java, node, perl, python, ruby, go plus a few more languages i can't recall off the top of my head

there might be node/javascript stuff already installed from these other classes/exercises that made it work ok.


here’s some additional info the terminal session

which node
/usr/local/bin/node

node --version
v5.10.0

npm version
{ npm: '3.8.3',
  ares: '1.10.1-DEV',
  http_parser: '2.6.2',
  icu: '56.1',
  modules: '47',
  node: '5.10.0',
  openssl: '1.0.2g',
  uv: '1.8.0',
  v8: '4.6.85.31',
  zlib: '1.2.8' }

npm config list
; cli configs
user-agent = "npm/3.8.3 node/v5.10.0 darwin x64"

; builtin config undefined
prefix = "/usr/local"

; node bin location = /usr/local/Cellar/node/5.10.0/bin/node
; cwd = /Users/bobzawislak/dev/nodejs/ws
; HOME = /Users/bobzawislak
; "npm config ls -l" to show all defaults.


npm list --global | grep web
│ │ ├─┬ faye-websocket@0.10.0
│ │ │ └─┬ websocket-driver@0.6.4
│ │ │   └── websocket-extensions@0.1.1

