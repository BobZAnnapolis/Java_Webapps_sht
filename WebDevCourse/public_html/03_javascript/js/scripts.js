// random color generator
function getRandomColor() {
	// numbers and letters composing RGB colors
	var letters='0123456789ABCDEF'.split('');
	var color='#';
	for (var i=0; i<6;i++) {
		color+=letters[Math.round(Math.random() * 15)]
	}
	console.log("Returning color : " + color);
	return color;
}
		
// fcn to get a random value between 1 and 5 seconds 
function getRandomTime() {
	var x=Math.random();
	x=x*6;
	x=Math.floor(x);
	if (x==0) {
		x=1;
	}
	if (x>5) {
		x=5;
	}
	console.log("Returning seconds : " + x);
	return (x*1000);
}
		
var clickedTime; var createdTime; var reactionTime;
		
function makeBox() {
//	alert("makeBox() called");
	clickedTime=Date.now();
	// use a random timeout between 1-5 sec to make box appear		
	setTimeout(function() {
		if (Math.random() > 0.5 ) {
			document.getElementById("box").style.borderRadius="100px";
		} else {
			document.getElementById("box").style.borderRadius="0";
		}
				
		var top=Math.random();
		top=top*300;
		var left=Math.random();
		left=left*500;		

		document.getElementById("box").style.top=top+"px";
		document.getElementById("box").style.left=left+"px";
		document.getElementById("box").style.backgroundColor=getRandomColor();
		document.getElementById("box").style.display="block";
		createdTime=Date.now();
	}, getRandomTime());
}
		
// click on the to make it disappear
document.getElementById("box").onclick=function() {
	clickedTime=Date.now();
	reactionTime=(clickedTime-createdTime)/1000;
//	alert("It took " + reactionTime + " seconds to click on the box.");
	document.getElementById("yourTime").innerHTML=reactionTime;
	this.style.display="none";
	makeBox();
}
		
makeBox();
