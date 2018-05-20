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
        <link rel="stylesheet" href="../../resources/material/sheets/material.grey-orange.min.css">
        <link rel="stylesheet" href="../../resources/sheets/styles_signup.css">
    </head>
    <body>
        <div class="talasso-main mdl-layout mdl-js-layout">
            <main class="mdl-layout__content">
                <div class="talasso-main__content mdl-grid talasso-max-width">
                    <jsp:useBean id="conventions" scope="request" type="java.util.List"/>
                    <c:forEach var="convention" items="${conventions}">
                        <div class="mdl-cell mdl-card mdl-shadow--4dp talasso-card">
                            <div class="mdl-card__media">
                                <img class="content-image" src="../../resources/images/${convention.image}" border="0" alt="">
                            </div>
                            <div class="mdl-card__title">
                                <h2 class="mdl-card__title-text">${convention.label}</h2>
                            </div>
                            <div class="mdl-card__supporting-text">
                                ${convention.detail}
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="#">Détails</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <!--footer class="mdl-mini-footer">
                    <div class="mdl-mini-footer--left-section">
                        <button class="mdl-mini-footer--social-btn social-btn social-btn__twitter">
                            <span class="visuallyhidden">Twitter</span>
                        </button>
                        <button class="mdl-mini-footer--social-btn social-btn social-btn__blogger">
                            <span class="visuallyhidden">Facebook</span>
                        </button>
                        <button class="mdl-mini-footer--social-btn social-btn social-btn__gplus">
                            <span class="visuallyhidden">Google Plus</span>
                        </button>
                    </div>
                    <div class="mdl-mini-footer--right-section">
                        <button class="mdl-mini-footer--social-btn social-btn__share">
                            <i class="material-icons" role="presentation">share</i>
                            <span class="visuallyhidden">share</span>
                        </button>
                    </div>
                </footer-->

            </main>
            <div class="mdl-layout__obfuscator"></div>
        </div>
        <script src="../../resources/material/scripts/material.min.js"></script>
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
