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
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Événement | Tal'Asso</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=fr">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="resources/material/sheets/material.grey-orange.min.css">>
        <link rel="stylesheet" href="resources/sheets/styles_admin.css">
    </head>
    <body>
        <div class="talasso-main mdl-layout mdl-js-layout">
            <main class="mdl-layout__content">
                <div class="talasso-main__content mdl-grid talasso-max-width">
                    <jsp:useBean id="candidacies" scope="request" type="java.util.ArrayList"/>
                    <c:forEach var="candidacy" items="${candidacies}">
                        <div class="mdl-cell mdl-card mdl-shadow--4dp talasso-card">
                            <div class="mdl-card__media">
                                <img class="content-image" src="resources/images/example-event01.jpg" border="0" alt="">
                            </div>
                            <div class="mdl-card__title">
                                <h2 class="mdl-card__title-text">${candidacy.motivation}</h2>
                            </div>
                            <div class="mdl-card__supporting-text">
                                ${candidacy.motivation}
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="#">Détails</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="mdl-card mdl-cell mdl-cell--9-col-desktop mdl-cell--6-col-tablet mdl-cell--4-col-phone">
                    <div class="mdl-card__supporting-text">
                        <h4>Features</h4>
                        Dolore ex deserunt aute fugiat aute nulla ea sunt aliqua nisi cupidatat eu. Nostrud in laboris labore nisi amet do dolor eu fugiat consectetur elit cillum esse.
                    </div>
                    <div class="mdl-card__actions">
                        <a href="#" class="mdl-button">Read our features</a>
                    </div>
                </div>
            </main>
            <div class="mdl-layout__obfuscator"></div>
        </div>
        <script src="resources/material/scripts/material.min.js"></script>
    </body>
    <!--script>
        Array.prototype.forEach.call(document.querySelectorAll('.mdl-card__media'), function(el) {
            var link = el.querySelector('a');
            if(!link) {
                return;
            }
            var target = link.getAttribute('href');
            if(!target) {
                return;
            }
            el.addEventListener('click', function() {
                location.href = target;
            });
        });
    </script-->
</html>
