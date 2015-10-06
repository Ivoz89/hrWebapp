<%@tag description="Bootstrap Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
    <!-- Bootstrap Core CSS -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="/public/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/public/bootstrap/css/grayscale.css" rel="stylesheet">
    <link href="/public/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="/public/css/grad.css" rel="stylesheet" type="text/css">
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top"> 
        <script type="text/javascript" src="/public/bootstrap/js/jquery.js"></script>
        <script type="text/javascript" src="/public/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/public/bootstrap/js/jquery.easing.min.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>
        <script type="text/javascript" src="/public/bootstrap/js/grayscale.js"></script>
        <header class="intro">
            <div class="intro-body">
                <div class="container">
                    <div class="row">
                        <jsp:doBody/>
                    </div>
                </div>
            </div>
        </header>
        <footer>
            <div class="container text-center">
                <p>Created by Ivo Zielinski</p>
                <p>GFT Graduate Program 2015 Project</p>
                <p>Created using  <a href="https://github.com/IronSummitMedia/startbootstrap">Grayscale</a> bootstrap template</p>
            </div>
        </footer>
    </body>
</html>
