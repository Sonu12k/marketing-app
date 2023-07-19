<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>
    <h2 >Create new lead</h2>
   <form action="saveLead" method="post">
         <pre>   
         This is for first method
             First Name<input type="text" name="firstName"/>
             Last Name<input type="text" name="lastName"/>
             Email Id<input type="text" name="email"/>
             Mobile Name<input type="text" name="mobile"/>
             <input type="submit" value="save"/> 
             
           <!--   First Name<input type="text" name="name"/>
             Last Name<input type="text" name="lastName"/>
             Email Id<input type="text" name="emailId"/>
             Mobile Name<input type="text" name="mobileNumber"/>
             <input type="submit" value="save"/> 
            -->
           </pre>
   </form>
  ${msg}
  
</body>
</html>