<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/17/2018
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Tal'Asso</title>

        <!--meta name="description" content="" />
        <meta name="keywords" content="" /-->

        <!-- FontAwesome -->
        <link href="resources/sheets/font-awesome.css" media="screen" rel="stylesheet" type="text/css"/>

        <!-- Select 2 -->
        <link href="resources/sheets/select2.css" media="screen" rel="stylesheet" type="text/css"/>

        <!-- Core CSS -->
        <link href="resources/sheets/bootstrap.css" media="screen" rel="stylesheet" type="text/css"/>
        <link href="resources/sheets/index.css" media="screen" rel="stylesheet" type="text/css"/>

        <!-- Animate.css -->
        <link href="resources/sheets/animate.css" media="screen" rel="stylesheet" type="text/css"/>

        <!-- Modernizr Library -->
        <script src="resources/scripts/libraries/modernizr-3.6.0.min.js"></script>
    </head>
    <body>
        <!-- Header -->
        <%@include file="WEB-INF/views/loader.jspf" %>
        <!-- Slider -->
        <div class="fly-slider invisible" data-rotation-interval="10000" data-rotation-duration="1000">
            <div class="cube">
                <c:set var="s" value="resources/images/slide-" />
                <c:set var="e" value=".jpg" />
                <c:forEach begin="1" end="4" varStatus="loop">
                    <c:set var="m" value="${s}${loop.current}${e}" />
                    <section class="slide" style="background-image: url(${m});">
                        <div class="slide-content">
                            <h2 class="page-title">Tal'Asso</h2>

                            <div class="page-subtitle">Une Asso Qui Part à l'Assault</div>

                            <div class="volunteer-cta">
                                <a href="consultation" class="btn btn-large btn-icon js-wave">
                                    <i class="material-icons">arrow_forward</i>DEVENIR VOLONTAIRE AUJOURD'HUI</a>
                                <div class="note">soumission candidature requise</div>
                            </div>
                        </div>
                    </section>
                </c:forEach>
            </div>
            <a class="slider-control prev js-wave" href="#">
                <i class="material-icons">keyboard_arrow_left</i>
            </a>
            <a class="slider-control next js-wave" href="#">
                <i class="material-icons">keyboard_arrow_right</i>
            </a>
        </div>
        <!-- Libs -->
        <script src="resources/scripts/libraries/jquery-1.12.2.min.js"></script>
        <script src="resources/scripts/libraries/jquery-ui-1.11.4.min.js"></script>
        <script src="resources/scripts/libraries/bootstrap-3.3.6.min.js"></script>

        <!-- Select2  -->
        <script src="resources/scripts/libraries/select2.full.min.js"></script>

        <!-- TouchSwipe -->
        <script src="resources/scripts/libraries/jquery.touchSwipe.min.js"></script>

        <!-- Waves -->
        <script src="resources/scripts/libraries/waves.min.js"></script>

        <!-- General Scripts -->
        <script src="resources/scripts/general.js"></script>
    </body>
</html>
