function initiate(){
	var array = Array.prototype.slice.call(document.getElementById("listeVilles").rows);
	for (let i = 0; i < 50; i++) {
  		array[i].classList.remove("hidden");
	}
}
/*
function next(){
	
}

function previous(){
	
}*/
