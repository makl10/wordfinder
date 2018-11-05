<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib tagdir = "/WEB-INF/tags" prefix = "nav" %>

<!doctype html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/wordsearch/css/starter-template.css" rel="stylesheet">
  </head>

  <body>

    <nav:nav />

  	<main role="main" class="container">
  		<div>
		    <br>
    			${result}
    		<br>
  		</div>
  		<div>
  			<c:url value="/solve" var="solveUrl" />
	  		<form action="${solveUrl}" method="POST">
	  			Word To Check: <input type="text" name="word" /> <br>
	  			Grid to check:
		  		<c:forEach items="${allGrids}" var="grid">
		  			<input type="radio" name="id" value="${grid.id}">${grid.name}</input>
		  		</c:forEach>
	            <input type="submit" value="Submit" />
	  		</form>  			
  		</div>

    </main><!-- /.container -->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../resources/bootstrap/dist/js/bootstrap.min.js"></script>
  </body>
</html>
