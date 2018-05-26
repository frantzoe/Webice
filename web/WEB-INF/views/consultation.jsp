<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/17/2018
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8"/>
        <meta name="description" content="...">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Événement | Tal'Asso</title>

        <link rel="shortcut icon" href="resources/images/favicon.png">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=fr">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="resources/material/sheets/material.grey-orange.min.css">
        <link rel="stylesheet" href="resources/sheets/styles_main.css">
        <style>
            #bottom-right-button {
                position: fixed;
                display: block;
                right: 0;
                bottom: 0;
                margin-right: 40px;
                margin-bottom: 40px;
                z-index: 900;
            }
        </style>
    </head>
    <body>
        <div class="talasso-main mdl-layout mdl-js-layout">
            <h1 class="mdl-typography--text-center mdl-typography--text-uppercase">Événements</h1>
            <main class="mdl-layout__content">
                <div class="talasso-main__content mdl-grid talasso-max-width">
                    <jsp:useBean id="conventions" scope="request" type="java.util.ArrayList"/>
                    <c:forEach var="convention" items="${conventions}">
                        <div class="mdl-cell mdl-cell--6-col mdl-card mdl-shadow--4dp talasso-card">
                            <div class="mdl-card__media">
                                <img class="content-image" src="resources/images/${convention.image}" border="0" alt="">
                            </div>
                            <div class="mdl-card__title">
                                <h2 class="mdl-card__title-text">${convention.label}</h2>
                            </div>
                            <div class="mdl-card__supporting-text">
                                ${convention.detail}
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent">
                                    <i class="material-icons ">event</i>
                                    ${convention.scheduled} à ${convention.place}
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </main>
            <div class="mdl-layout__obfuscator"></div>
        </div>
        <a href="registration" target="_blank" id="bottom-right-button" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast">S'inscrire</a>
        <script src="resources/material/scripts/material.min.js"></script>
    </body>
</html>
