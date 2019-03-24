<%@ include file="/WEB-INF/views/include.jsp"%>
<html>

<head>
	
	<title>Elections Simulation</title>
	<!-- META JS and CSS -->
	<%@ include file="/WEB-INF/views/common/metajscss.jsp"%>

</head>



<body>
	
	<!-- Navigation -->
    <%@ include file="/WEB-INF/views/common/navbar.jsp"%>
    
    <!-- Page Content -->
    <div class="container">
    	 <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3">Elections <small>Simulator</small></h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a  href="<spring:url value ="/"/>">Home</a>
            </li>
            <li class="breadcrumb-item active">Elections Simulator</li>
        </ol>
        
        <spring:url value="/elections" var="elections" />
        <form:form action="${elections}" method="post" modelAttribute="partyVotesForm">
        	<input type="number" name="seats"/>Escaños<br/>
			<input type="text" name="partyVotes[0].partyId" value="PP"/>
			<input type="number" name="partyVotes[0].numberOfVotes"/><br/>
			<input type="text" name="partyVotes[1].partyId" value="PSOE"/>
			<input type="number" name="partyVotes[1].numberOfVotes"/><br/>
			<input type="text" name="partyVotes[2].partyId" value="UP"/>
			<input type="number" name="partyVotes[2].numberOfVotes"/><br/>
			<input type="text" name="partyVotes[3].partyId" value="CS"/>
			<input type="number" name="partyVotes[3].numberOfVotes"/><br/>
			<input type="text" name="partyVotes[4].partyId" value="VOX"/>
			<input type="number" name="partyVotes[4].numberOfVotes"/><br/>
			  
			  Add more via JS
			  
			  <input class="btn btn-primary" type="submit" value="Simulate" />
		</form:form>
    
    
    </div>
    <!-- /.container -->
    
    <!-- Footer -->
    <%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>