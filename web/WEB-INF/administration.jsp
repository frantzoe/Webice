<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/17/2018
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% int candCount = 0; %>
<% int convCount = 0; %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <meta name="description" content="...">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Administration | Tal'Asso</title>

        <link rel="shortcut icon" href="resources/images/favicon.png">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="resources/material/sheets/material.indigo-pink.min.css">
        <link rel="stylesheet" href="resources/sheets/styles_admin.css">
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
    <body class="talasso-admin mdl-color--grey-100 mdl-color-text--grey-700 mdl-base">
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header mdl-layout--fixed-tabs">
            <header class="mdl-layout__header mdl-layout__header--scroll mdl-color--primary">
                <div class="mdl-layout--large-screen-only mdl-layout__header-row">
                </div>
                <div class="mdl-layout--large-screen-only mdl-layout__header-row">
                    <h3>${sessionScope.recruiterSession.forename} ${sessionScope.recruiterSession.surname}</h3>
                </div>
                <div class="mdl-layout--large-screen-only mdl-layout__header-row">
                </div>
                <div class="mdl-layout__tab-bar mdl-js-ripple-effect mdl-color--primary-dark">
                    <a href="#candidacies" class="mdl-layout__tab is-active">Candidatures</a>
                    <!--a href="#dashboard" class="mdl-layout__tab is-inactive">Dashboard</a-->
                    <a href="#conventions" class="mdl-layout__tab">Événements</a>
                    <!--a href="#features" class="mdl-layout__tab">Details</a-->
                    <!--button class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-shadow--4dp mdl-color--accent" id="add">
                        <i class="material-icons" role="presentation">add</i>
                        <span class="visuallyhidden">Add</span>
                    </button-->
                </div>
            </header>
            <main class="mdl-layout__content">
                <div class="mdl-layout__tab-panel is-active" id="candidacies">
                    <jsp:useBean id="candidacies" scope="request" type="java.util.List"/>
                    <c:forEach var="candidacy" items="${candidacies}">
                        <%candCount += 1;%>
                        <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
                            <div class="mdl-card mdl-cell mdl-cell--12-col">
                                <div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
                                    <h4 class="mdl-cell mdl-cell--12-col">${candidacy.candidate.forename} ${candidacy.candidate.surname} / ${candidacy.convention.label}</h4>
                                    <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
                                        <div class="section__circle-container__circle mdl-color--primary"></div>
                                    </div>
                                    <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
                                        <h5>${candidacy.candidate.forename} ${candidacy.candidate.surname}</h5>
                                        <p>Motivations : ${candidacy.motivation}</p>
                                        <p>Personalité : ${candidacy.candidate.personality}</p>
                                        <!--a href="#">proident minim</a-->
                                    </div>
                                    <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
                                        <div class="section__circle-container__circle mdl-color--primary"></div>
                                    </div>
                                    <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
                                        <h5>${candidacy.convention.label}</h5>
                                        Détails : ${candidacy.convention.detail}
                                        <!--a href="#">proident minim</a-->
                                    </div>
                                </div>
                                <div class="mdl-card__actions">
                                    <a id="valCan1<% out.print(candCount); %>" href="#" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent">Valider Pour ${candidacy.choiceOne}</a>
                                    <div class="mdl-tooltip" data-mdl-for="valCan1<% out.print(candCount); %>">Accepter la Candidature pour le poste de ${candidacy.choiceOne}</div>
                                    <a id="valCan2<% out.print(candCount); %>" href="#" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent">Valider Pour ${candidacy.choiceTwo}</a>
                                    <div class="mdl-tooltip" data-mdl-for="valCan2<% out.print(candCount); %>">Accepter la Candidature pour le poste de ${candidacy.choiceTwo}</div>
                                </div>
                            </div>
                            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="delCan<% out.print(candCount); %>">
                                <i class="material-icons">delete</i>
                            </button>
                            <div class="mdl-tooltip" data-mdl-for="delCan<% out.print(candCount); %>">Supprimer Cette Candidature</div>
                        </section>
                    </c:forEach>
                    <br><br><br>
                </div>
                <div class="mdl-layout__tab-panel is-inactive" id="conventions">
                    <jsp:useBean id="conventions" scope="request" type="java.util.ArrayList"/>
                    <c:forEach var="convention" items="${conventions}">
                        <%convCount += 1;%>
                        <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
                            <header class="section__play-btn mdl-cell mdl-cell--3-col-desktop mdl-cell--2-col-tablet mdl-cell--4-col-phone mdl-color--teal-100 mdl-color-text--white">
                                <!--i class="material-icons">play_circle_filled</i-->
                                <img src="resources/images/${convention.image}">
                            </header>
                            <div class="mdl-card mdl-cell mdl-cell--9-col-desktop mdl-cell--6-col-tablet mdl-cell--4-col-phone">
                                <div class="mdl-card__supporting-text">
                                    <h4>${convention.label}</h4>
                                    ${convention.detail}
                                </div>
                                <div class="mdl-card__actions mdl-card--border">
                                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent">
                                        <i class="material-icons ">event</i>
                                        ${convention.scheduled} à ${convention.place}
                                    </a>
                                </div>
                            </div>
                            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="delCon<% out.print(convCount); %>">
                                <i class="material-icons">delete</i>
                            </button>
                            <div class="mdl-tooltip" data-mdl-for="delCon<% out.print(convCount); %>">Supprimer Cet Événement</div>
                        </section>
                    </c:forEach>
                    <br><br><br>
                </div>
                <footer class="mdl-mini-footer">
                    <div class="mdl-mini-footer__left-section">
                        <div class="mdl-logo">Tal'Asso</div>
                            <ul class="mdl-mini-footer__link-list">
                                <li><a href="#">GitHub</a></li>
                                <li><a href="#">JavaDoc</a></li>
                            </ul>
                        </div>
                </footer>
            </main>
        </div>
        <a href="logout" target="_blank" id="bottom-right-button" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast">Déconnexion</a>
        <script src="resources/material/scripts/material.min.js"></script>
    </body>
</html>
