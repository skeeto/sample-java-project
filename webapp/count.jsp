<html>
  <head>
    <title>JSP Demo</title>
  </head>
  <body>
    <h1>JSP Demo</h1>
    <%!
       private int counter;

       private synchronized int count() {
           return ++counter;
       }
    %>
    <%
       String name = (String) session.getAttribute("name");
       if (name != null) { %>
           <p>Welcome back, <%= name %>.</p>
           <form action="/logout" method="post">
	     <input type="submit" value="logout"/>
	   </form>
           <%
       } else { %>
	   <form action="login" method="post">
	     <input type="text" name="name"/>
	     <input type="submit" value="login"/>
	   </form>
       <%
       }
    %>
    <p>
      This page has been visited <%= count() %> times.
    </p>
  </body>
</html>
