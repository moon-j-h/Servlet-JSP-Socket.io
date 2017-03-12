
/**
 * Server For Sharing ppt Slide Show Of DalGongFee Web Application
 */

var express = require('express'),
	app = express(),
	http = require('http'),
	server = http.createServer(app),
	io = require('socket.io').listen(server);

server.listen(13000);
console.log("Server start!!");
 
function Joiner(memberId, memberName){
	this.memberId = memberId;
	this.memberName = memberName;
}

var roomList = []; 
var filePathList = [];
var filePageNum = []; 
io.sockets.on('connection', function(socket){
	console.log("connect");
	socket.on('addJoiner', function(data, fileInfo){
		socket.room = data.roomNum;
		socket.memberId = data.memberId;
		socket.memberName =data.memberName;
		socket.join(data.roomNum); 
		console.log("room Num : "+data.roomNum+", email : "+data.memberId);
		var oneRoom = roomList[data.roomNum];
		
		var joiner = new Joiner(data.memberId, data.memberName);
		if(oneRoom === undefined){  
			roomList[data.roomNum] = [joiner];
		}else{
			roomList[data.roomNum].push(joiner);
		}
		if(fileInfo !== null){  
			filePathList[data.roomNum] = fileInfo.path; 
			filePageNum[data.roomNum] = fileInfo.num;
		}else{ 
			socket.emit("setFileInfo", filePathList[data.roomNum], filePageNum[data.roomNum]);
		}
		socket.emit("setJoinerList", roomList[data.roomNum]);  
		socket.broadcast.to(data.roomNum).emit("updateJoinerList", data.memberId, data.memberName); 
	});
	
	socket.on("changePage", function(data){
		socket.broadcast.to(socket.room).emit("updatePage", data);
	});
	
	socket.on('disconnect', function(){
		console.log("joiner disconnect");
		var oneRoom2 = roomList[socket.room]; 
		if(oneRoom2 !== undefined){
			for(var i=0; i<oneRoom2.length; i++){
				if(oneRoom2[i].memberId === socket.memberId){
					if(i === 0){ 
						socket.broadcast.to(socket.room).emit("outAllJoiner", socket.memberId);
						break;
					}else{
						oneRoom2.splice(i, 1);
						socket.broadcast.to(socket.room).emit("outJoiner", roomList[socket.room]); 
						break;
					}
				}
			}
		}
		socket.leave(socket.room);
	});
});