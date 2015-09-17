<div class="col-sm-3">

	<h4>
		<span id="p1Name">Name Name</span> of House <span id="p1House">Blank</span>
	</h4>

	<p>
		House Points: <span id="p1Points">0</span> points
	</p>
			<p>
		Detention: <span id="p1Jailed">0</span>
	</p>

</div>

<div class="col-sm-3">

	<h4>
		<span id="p2Name">Name Name</span> of House <span id="p2House">Blank</span>
	</h4>

	<p>
		House Points: <span id="p2Points">0</span> points
	</p>
		<p>
		Detention: <span id="p2Jailed">0</span>
	</p>


</div>


<div class="col-sm-3">

	<h4>
		<span id="p3Name">Name Name</span> of House <span id="p3House">Blank</span>
	</h4>

	<p>
		House Points: <span id="p3Points">0</span> points
	</p>
			<p>
		Detention: <span id="p3Jailed">0</span>
	</p>

	

</div>


<div class="col-sm-3">

	<h4>
		<span id="p4Name">Name Name</span> of House <span id="p4House">Blank</span>
	</h4>

	<p>
		House Points: <span id="p4Points">0</span> points
	</p>
		<p>
		Detention: <span id="p4Jailed">0</span>
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

			request.onreadystatechange = getNames;
			request.open("GET", setup, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getNames() {
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
	
	function requestUpdatedState() {
		requestPersonalInfo();
		requestOwnedProperties(); 
		requestGameWon(); 
	}
	
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
		
	}
	
	function updateOwnedProperties(){
		
	}
	
	
	requestNames();
	setInterval(requestUpdatedState, 3000); 
</script>

<!-- 
	setInterval(sendRequest, 2000); -->

