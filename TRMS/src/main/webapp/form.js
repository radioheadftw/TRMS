n =  new Date();
y = n.getFullYear();
m = n.getMonth() + 1;
d = n.getDate()+7;
	
if(m < 10){
	m = '0'+m;
}
if(d < 10){
	d = '0'+d;
}
	
document.getElementById("date").value = y+"/"+m+"/"+d;
document.getElementById("date").min = m+"/"+d+"/"+y;
	
function empty() {
	var x;
	x = document.getElementById("date").value;
	if (x == "") {
	    alert("Enter a date.");
	    return false;
	};
	var t;
	t = document.getElementById("time").value;
	if (t == "") {
	    alert("Enter a time.");
	    return false;
	};
	var y;
	y = document.getElementById("location").value;
	if (y == "") {
	    alert("Enter a location.");
	    return false;
	};
	var z;
	z = document.getElementById("description").value;
	if (z == "") {
	    alert("Enter a description.");
	    return false;
	};
	var a;
	a = document.getElementById("cost").value;
	if (a == "") {
	    alert("Enter a cost.");
	    return false;
	};
	alert("Form submitted.");
}