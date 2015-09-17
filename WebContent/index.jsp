<%@include file="header_fragment.html"%>
<h1>Welcome!</h1>
<h4>How do you want to play today?</h4>


		
	<!--	<a href="options.jsp" class="btn btn-primary btn-lg" role="button">Set up new game</a> 
		
		<a href="play" class="btn btn-default btn-lg" role="button">Spectate</a>-->
		
		
	<!-- <a href="results" class="btn btn-default" role="button">View prior game results</a> -->


<form action="index.jsp" name="index_form">

<!-- 
<input class="btn btn-lg btn-primary" type="submit" name="from" value="Play" OnClick="document.forms['index_form'].action = 'options.jsp'" >
<input class="btn btn-lg btn-default" type="submit" name="from" value="Spectate" OnClick="document.forms['index_form'].action = 'play'" > -->

	<button class="btn btn-primary btn-lg" role="button" type="submit" OnClick="document.forms['index_form'].action = 'options.jsp'" value="play" name="intent">Set up new game</button> 
	<button class="btn btn-default btn-lg" role="button" type="submit" OnClick="document.forms['index_form'].action = 'play'" value="watch" name="intent">Spectate</button>

</form>


<%@include file="footer_fragment.html"%>