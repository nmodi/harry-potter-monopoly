<%@include file="header_fragment.html"%>


<script>
function goBack() {
    window.history.back();
}
</script>
<h1>Game Setup</h1>
<h4>Please select your options:</h4>

<form action="play" class="form-horizontal">

	<div class="form-group">
		<label for="name" class="control-label col-sm-2">Name: </label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="playerName"
				maxlength="25" id="name" placeholder="Harry Potter">
		</div>
	</div>

	<div class="form-group">
		<label for="houseDropdown" class="control-label col-sm-2">
			House: </label>
		<div class="col-sm-10">
			<select name="house" id="houseDropdown" class="form-control">
				<option value="gryffindor">Gryffindor</option>
				<option value="hufflepuff">Hufflepuff</option>
				<option value="ravenclaw">Ravenclaw</option>
				<option value="slytherin">Slytherin</option>
			</select>
		</div>
	</div>



	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Start game!</button>
		</div>
	</div>
	
	
<input type="hidden" name="intent" value="options">
	
</form>


<button onclick="goBack()" class="btn btn-sm btn-default"><< Back</button>


<%@include file="footer_fragment.html"%>