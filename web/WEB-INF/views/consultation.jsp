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
        <title>Consultation | Tal'Asso</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=fr">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="../../resources/material/sheets/material.grey-orange.min.css">
        <link rel="stylesheet" href="../../resources/sheets/styles_signup.css">
    </head>
    <body>
        <div class="demo-blog mdl-layout mdl-js-layout has-drawer is-upgraded">
            <main class="mdl-layout__content">
                <div class="demo-blog__posts mdl-grid">

                    <jsp:useBean id="conventions" scope="request" type="java.util.List"/>
                    <c:forEach var="convention" items="${conventions}">
                        <div class="mdl-card on-the-road-again mdl-cell mdl-cell--12-col">
                            <div class="mdl-card__media mdl-color-text--grey-50">
                                <h3><a href="entry.html">${convention.label}</a></h3>
                            </div>
                            <div class="mdl-color-text--grey-600 mdl-card__supporting-text">
                                ${convention.detail}
                            </div>
                            <div class="mdl-card__supporting-text meta mdl-color-text--grey-600">
                                <div class="minilogo"></div>
                                <div>
                                    <strong>${convention.place}</strong>
                                    <span>${convention.scheduled}</span>
                                </div>
                            </div>
                        </div>
                        <div class="mdl-card shopping mdl-cell mdl-cell--12-col">
                            <div class="mdl-card__media mdl-color-text--grey-50">
                                <h3><a href="entry.html">${convention.label}</a></h3>
                            </div>
                            <div class="mdl-card__supporting-text mdl-color-text--grey-600">
                                ${convention.detail}
                            </div>
                            <div class="mdl-card__supporting-text meta mdl-color-text--grey-600">
                                <div class="minilogo"></div>
                                <div>
                                    <strong>${convention.place}</strong>
                                    <span>${convention.scheduled}</span>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <!--nav class="demo-nav mdl-cell mdl-cell--12-col">
                        <div class="section-spacer"></div>
                        <a href="entry.html" class="demo-nav__button" title="show more">
                            More
                            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
                                <i class="material-icons" role="presentation">arrow_forward</i>
                            </button>
                        </a>
                    </nav-->
                </div>
                <footer class="mdl-mini-footer">
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
                </footer>
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
