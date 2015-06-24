<%-- 
    Document   : validation
    Created on : May 22, 2014, 10:00:23 AM
    Author     : AphiaPlus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Test for jQuery validate() plugin</title>

<link rel="stylesheet" type="text/css" media="screen" href="css/screen.css" />

<script src="lib/jquery.js" type="text/javascript"></script>
<script src="lib/jquery.form.js" type="text/javascript"></script>
<script src="lib/jquery.validate.js" type="text/javascript"></script>

<script type="text/javascript">
// only for demo purposes
$.validator.setDefaults({
	submitHandler: function() {
		alert("submitted!");
	}
});
	
$.metadata.setType("attr", "validate");

$(document).ready(function() {
	$("#form1").validate();
	$("#selecttest").validate();
});
</script>

<style type="text/css">
.block { display: block; }
form.cmxform label.error { display: none; }	
</style>

</head>
<body>

<h1 id="banner"><a href="http://bassistance.de/jquery-plugins/jquery-plugin-validation/">jQuery Validation Plugin</a> Demo</h1>
<div id="main">

<form class="cmxform" id="form1" method="get" action="">
	<fieldset>
		<legend>Validating a form with a radio and checkbox buttons</legend>
		<fieldset>
			<legend>Gender</legend>
			<label for="gender_male">
				<input  type="radio" id="gender_male" value="m" name="gender" validate="required:true" />
				Male
			</label>
			<label for="gender_female">
				<input  type="radio" id="gender_female" value="f" name="gender"/>
				Female
			</label>
			<label for="gender" class="error">Please select your gender</label>
		</fieldset>
		<fieldset>
			<legend>Family</legend>
			<label for="family_single">
				<input  type="radio" id="family_single" value="s" name="family" validate="required:true" />
				Single
			</label>
			<label for="family_married">
				<input  type="radio" id="family_married" value="m" name="family" />
				Married
			</label>
			<label for="family_other">
				<input  type="radio" id="family_other" value="o" name="family" />
				Other
			</label>
			<label for="family" class="error">Please select your family status.</label>
		</fieldset>
		<p>
			<label for="agree">Please agree to our policy</label>
			<input type="checkbox" class="checkbox" id="agree" name="agree" validate="required:true" />
			<br/>
			<label for="agree" class="error block">Please agree to our policy!</label>
		</p>
		<fieldset>
			<legend>Spam</legend>
			<label for="spam_email">
				<input type="checkbox" class="checkbox" id="spam_email" value="email" name="spam[]" validate="required:true, minlength:2" />
				Spam via E-Mail
			</label>
			<label for="spam_phone">
				<input type="checkbox" class="checkbox" id="spam_phone" value="phone" name="spam[]" />
				Spam via Phone
			</label>
			<label for="spam_mail">
				<input type="checkbox" class="checkbox" id="spam_mail" value="mail" name="spam[]" />
				Spam via Mail
			</label>
			<label for="spam[]" class="error">Please select at least two types of spam.</label>
		</fieldset>
		<p>
			<input class="submit" type="submit" value="Submit"/>
		</p>
	</fieldset>
</form>

<form id="selecttest">
	<h2>Some tests with selects</h2>
	<p>
		<label for="jungle">Please select a jungle noun</label><br/>
		<select id="jungle" name="jungle" title="Please select something!" validate="required:true">
			<option value=""></option>
			<option value="1">Buga</option>
			<option value="2">Baga</option>
			<option value="3">Oi</option>
		</select>
	</p>
	
	<p>
		<label for="fruit">Please select at least two fruits</label><br/>
		<select id="fruit" name="fruit" title="Please select at least two fruits" validate="required:true, minlength:2" multiple="multiple">
			<option value="b">Banana</option>
			<option value="a">Apple</option>
			<option value="p">Peach</option>
			<option value="t">Turtle</option>
		</select>
	</p>
	
	<p>
		<label for="vegetables">Please select no more than two vergetables</label><br/>
		<select id="vegetables" name="vegetables" title="Please select no more than two vergetables" validate="required:true, maxlength:2" multiple="multiple">
			<option value="p">Potato</option>
			<option value="t">Tomato</option>
			<option value="s">Salad</option>
		</select>
	</p>
	
	<p>
		<label for="cars">Please select at least two cars, but no more than three</label><br/>
		<select id="cars" name="cars" title="Please select at least two cars, but no more than three" validate="required:true, rangelength:[2,3]" multiple="multiple">
			<option value="m_sl">Mercedes SL</option>
			<option value="o_c">Opel Corsa</option>
			<option value="vw_p">VW Polo</option>
			<option value="t_s">Titanic Skoda</option>
		</select>
	</p>
	
	<p><input type="submit" value="Validate Selecttests"/></p>
</form>

<a href="index.html">Back to main page</a>

</div>


</body>
</html>
