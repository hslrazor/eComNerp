<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Sign-up TBA</title>
</head>
<body>
<h3>Welcome please provide you details to Sign-up for TBA</h3>
<!-- Contains first name, last name, user name, password, email, Birthday and gender  -->
	<s:form action="signup">
		<s:textfield name ="firstname" label="First Name"></s:textfield>
		<s:textfield name ="lastname" label="Last Name"></s:textfield>
		<s:textfield name ="name" label="User ID"></s:textfield>
		<s:password name="pwd" label="Password"></s:password>
		<s:textfield name ="email" label ="Email"></s:textfield>
		<s:date name="birthday" format="dd/MM/yyyy"/>
		<s:radio list="{'male','female','X'}" name="gender"></s:radio>
		<s:submit value ="Signup"></s:submit>
	</s:form>

</body>
</html>