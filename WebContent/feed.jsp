<div class="col-sm-3" >
	<h4>
		<span id="p1Name">Name Name</span> of House <span id="p1House">Blank</span>
	</h4>
	<p>
		House Points: <span id="p1Points">000</span>
	</p>
	<p>
		<span id="p1Jailed">A Free Elf</span>
	</p>
	<p>
		@ <span id="p1Pos">Go!</span>
	</p>
</div>

<div class="col-sm-3">
	<h4>
		<span id="p2Name">Name Name</span> of House <span id="p2House">Blank</span>
	</h4>
	<p>
		House Points: <span id="p2Points">000</span>
	</p>
	<p>
		<span id="p2Jailed">A Free Elf</span>
	</p>
	
	<p>
		@ <span id="p2Pos">Go!</span>
	</p>
</div>


<div class="col-sm-3">
	<h4>
		<span id="p3Name">Name Name</span> of House <span id="p3House">Blank</span>
	</h4>

	<p>
		House Points: <span id="p3Points">000</span>
	</p>
	<p>
		<span id="p3Jailed">A Free Elf</span>
	</p>
		<p>
		@ <span id="p3Pos">Go!</span>
	</p>
</div>


<div class="col-sm-3">
	<h4>
		<span id="p4Name">Name Name</span> of House <span id="p4House">Blank</span>
	</h4>

	<p>
		House Points: <span id="p4Points">000</span>
	</p>
	<p>
		<span id="p4Jailed">A Free Elf</span>
	</p>
	<p>
		@ <span id="p4Pos">Go!</span>
	</p>
</div>



<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>

<script>
	function capitalize(s) {
		return s[0].toUpperCase() + s.slice(1);
	}
	
	var request;
	var url = "runner"; 
	
	function requestNames() {
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			var query = "?reqType=names";
			var setup = url.concat(query);
			request.onreadystatechange = updateNames;
			request.open("GET", setup, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function updateNames() {
		var val = request.responseText;
		var vals = val.split(",");
		document.getElementById('p1Name').innerHTML = vals[0];
		document.getElementById('p1House').innerHTML = capitalize(vals[1]);
		document.getElementById('p2Name').innerHTML = vals[2];
		document.getElementById('p2House').innerHTML = capitalize(vals[3]);
		document.getElementById('p3Name').innerHTML = vals[4];
		document.getElementById('p3House').innerHTML = capitalize(vals[5]);
		document.getElementById('p4Name').innerHTML = vals[6];
		document.getElementById('p4House').innerHTML = capitalize(vals[7]);
	}


	requestNames();
	
	function requestGameWon(){
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			var query = "?reqType=won";
			var setup = url.concat(query);
			request.onreadystatechange = handleGameWon;
			request.open("GET", setup, true);
			request.send();
			
		} catch (e) {
			alert("Unable to connect to server");
		
		}
	}
	
	function handleGameWon(){
		var val = request.responseText;
		// create button to go to next page? 
	}
	
	function requestPersonalInfo(){
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			var query = "?reqType=personal";
			var setup = url.concat(query);
			request.onreadystatechange = updatePersonalInfo;
			request.open("GET", setup, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	
	function updatePersonalInfo(){
		var val = request.responseText;
		var vals = val.split(",");
		document.getElementById('p1Points').innerHTML = vals[0];
		document.getElementById('p1Jailed').innerHTML = vals[1];
		document.getElementById('p1Pos').innerHTML = vals[2];
		
		document.getElementById('p2Points').innerHTML = vals[3];
		document.getElementById('p2Jailed').innerHTML = vals[4];
		document.getElementById('p2Pos').innerHTML = vals[5];
		
		document.getElementById('p3Points').innerHTML = vals[6];
		document.getElementById('p3Jailed').innerHTML = vals[7];
		document.getElementById('p3Pos').innerHTML = vals[8];
		
		document.getElementById('p4Points').innerHTML = vals[9];
		document.getElementById('p4Jailed').innerHTML = vals[10];
		document.getElementById('p4Pos').innerHTML = vals[11];
	}
	
	
	function requestUpdatedState() {
		// requestGameWon(); 
		requestPersonalInfo(); 
	}
	
	
	setInterval(requestUpdatedState, 3000);
	
	</script>
	
	<!-- 

	
	function requestGameWon(){
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			var query = "?reqType=won";
			var setup = url.concat(query);

			request.onreadystatechange = handleGameWon;
			request.open("GET", setup, true);
			request.send();
			
		} catch (e) {
			alert("Unable to connect to server");
		
		}
	}
	
	function handleGameWon(){
		var val = request.responseText;
		// create button to go to next page? 
	}
	
	function requestPersonalInfo(){
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			var query = "?reqType=personal";
			var setup = url.concat(query);

			request.onreadystatechange = updatePersonalInfo;
			request.open("GET", setup, true);
			request.send();
			
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	
	function requestOwnedProperties(){
		var url = "runner";

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			var query = "?reqType=property";
			var setup = url.concat(query);

			request.onreadystatechange = updateOwnedProperties;
			request.open("GET", setup, true);
			request.send();
			
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	
	function updatePersonalInfo(){
		var val = request.responseText;
		var vals = val.split(",");
		document.getElementById('p1Points').innerHTML = vals[0];
		document.getElementById('p2Points').innerHTML = capitalize(vals[1]);

		document.getElementById('p3Points').innerHTML = vals[2];
		document.getElementById('p4Points').innerHTML = capitalize(vals[3]);
	}
	
	function updateOwnedProperties(){
		
	}
	
	
	// setInterval(requestUpdatedState, 3000); 
</script>

-->

