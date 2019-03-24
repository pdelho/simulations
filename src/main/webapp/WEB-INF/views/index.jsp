<%@ include file="/WEB-INF/views/include.jsp"%>
<html>

<head>

	<title>Simulations Webapp</title>
	<!-- META JS and CSS -->
	<%@ include file="/WEB-INF/views/common/metajscss.jsp"%>

</head>



<body>
	
	<!-- Navigation --> 
    <%@ include file="/WEB-INF/views/common/navbar.jsp"%>

    <!-- Page Content -->
    <div class="container">

        <h1 class="my-4">Welcome to DelHoyo webpage!</h1>

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-4 mb-4">
                <div class="card h-100">
                    <h4 class="card-header">Programming</h4>
                    <div class="card-body">
                        <p class="card-text">I'm developing this website just for fun. Don't take it seriously. But is a funny way to learn programming: front-end, back-end, databases... You have the repository in my GitHub, feel free to copy it!</p>
                    </div>
                    <div class="card-footer">
                        <a href="#" class="btn btn-primary">Learn More</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->


        <!-- Features Section -->
        <div class="row">
            <div class="col-lg-6">
                <h2>Modern Business Features</h2>
                <p>The Modern Business template by Start Bootstrap includes:</p>
                <ul>
                    <li><strong>Bootstrap v4</strong>
                    </li>
                    <li>jQuery</li>
                    <li>Font Awesome</li>
                    <li>Working contact form with validation</li>
                    <li>Unstyled page elements for easy customization</li>
                </ul>
                <p>Consult this template in the Other Pages section</p>
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Call to Action Section -->
        <div class="row mb-4">
            <div class="col-md-8">
                <p>This webpage was built using SpringMVC</p>
            </div>
        </div>

    </div>
    
    
    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
        <P class="m-0 text-center text-white">The time on the server is ${serverTime}<br></P>
        <p class="m-0 text-center text-white">2017</p>
        </div>
    </footer>
</body>
</html>
