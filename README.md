# LukasJ Client
This repository is part of the LukasJ project aiming to develop a RESTfulserver exchanging data through token
authorization with a client.
This is the client developed in Java and should run from console on any Java-compatible machine

## App running
The main send the two unprotected Restful APIs to the server **/api/register** and **/api/login**

Both the Restful calls returns the server generated token that can be used for any further protected API call. The console output below shows what happen when the application runs.
```
LukasJ Client 1.0.0

Register endpoint : http://192.168.185.181:3000/api/register
Register body content : {"name":"mj011","role":"lukeforever"}
Server returned : {"name":"mj011","role":"lukeforever","token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoibWowMTEiLCJyb2xlIjoibHVrZWZvcmV2ZXIiLCJpYXQiOjE1MjMxMzYwMjd9.3yLM37vyX4Kgn8HWml9BlDn7Zw0TwaNHzWQeEAK2jpI"}

Login endpoint : http://192.168.185.181:3000/api/login
Login body content : {"user":"jd001","password":"jdpasswd"}
Server returned : {"user":"jd001","password":"jdpasswd","token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiamQwMDEiLCJwYXNzd29yZCI6ImpkcGFzc3dkIiwiaWF0IjoxNTIzMTM2MDI3fQ.nHBpbPcbnkt5mevQto8Pa8qSsTR258Tf_IJE8MosDGs"}**
```

## ToDo List
- Implement the other Restful protected APIs passing the generated token in the Http Request header
- Add user interactiion 

## Test platforms
The client has been tested on OSX and Windows10 platforms running the Java 8 RTE
