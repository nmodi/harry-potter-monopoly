<%@include file="header_fragment.html"%>
<h1>Game Setup</h1>
<h2>Please select your options:</h2>
<form action="play">
	<label for="houseDropdown"> House: </label> <select name="house"
		id="houseDropdown">
		<option value="gryffindor">Gryffindor</option>
		<option value="hufflepuff">Hufflepuff</option>
		<option value="ravenclaw">Ravenclaw</option>
		<option value="slytherin">Slytherin</option>
	</select> <br> <label for="freqDropdown">Frequency of Game Updates:
	</label> <select name="updateFrequency" id="freqDropdown">
		<option value="5">5 seconds</option>
		<option value="10">10 seconds</option>
		<option value="20">20 seconds</option>
		<option value="30">30 seconds</option>
	</select> <br> <label for="name">Enter your name: </label> <input
		type="text" name="playerName" maxlength="15" id="name"> <br>
	<input type="submit" value="Play Game">
</form>
<%@include file="footer_fragment.html"%>