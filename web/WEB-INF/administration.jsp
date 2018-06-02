<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/17/2018
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="conventions" scope="request" type="java.util.ArrayList"/>
<jsp:useBean id="candidacies" scope="request" type="java.util.List"/>
<jsp:useBean id="tab" scope="request" type="java.lang.Integer" />

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
                    <h3>${sessionScope.recruiterSession.fullname}</h3>
                </div>
                <div class="mdl-layout--large-screen-only mdl-layout__header-row">
                </div>
                <div class="mdl-layout__tab-bar mdl-js-ripple-effect mdl-color--primary-dark">
                    <c:choose>
                        <c:when test="${tab == 0}">
                            <a href="#candidacies" class="mdl-layout__tab is-active">Candidatures</a>
                            <a href="#conventions" class="mdl-layout__tab">Événements</a>
                        </c:when>
                        <c:when test="${tab == 1}">
                            <a href="#candidacies" class="mdl-layout__tab">Candidatures</a>
                            <a href="#conventions" class="mdl-layout__tab is-active">Événements</a>
                        </c:when>
                    </c:choose>
                </div>
            </header>
            <main class="mdl-layout__content">
                <c:choose>
                    <c:when test="${tab == 0}">
                        <div class="mdl-layout__tab-panel is-active" id="candidacies">
                    </c:when>
                    <c:when test="${tab == 1}">
                        <div class="mdl-layout__tab-panel is-inactive" id="candidacies">
                    </c:when>
                </c:choose>
                    <c:forEach var="candidacy" items="${candidacies}">
                        <c:if test="${not candidacy.validated}">
                            <%candCount += 1;%>
                            <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
                                <div class="mdl-card mdl-cell mdl-cell--12-col">
                                    <div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
                                        <h4 class="mdl-cell mdl-cell--12-col">${candidacy.candidate.fullname} / ${candidacy.convention.label}</h4>
                                        <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
                                            <div class="section__circle-container__circle mdl-color--primary">
                                                <i class="material-icons mdl-color-text--white">face</i>
                                            </div>
                                        </div>
                                        <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
                                            <h5>${candidacy.candidate.fullname}</h5>
                                            Motivations : ${candidacy.motivation}<br>Personalité : ${candidacy.candidate.personality}
                                        </div>
                                        <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
                                            <div class="section__circle-container__circle mdl-color--primary">
                                                <i class="material-icons mdl-color-text--white">event</i>
                                            </div>
                                        </div>
                                        <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
                                            <h5>${candidacy.convention.label}</h5>
                                            Détails : ${candidacy.convention.detail}
                                        </div>
                                    </div>
                                    <div class="mdl-card__actions">
                                        <a href="validatecandidacy?email=${candidacy.candidate.fullname}&label=${candidacy.convention.label}&choice=${candidacy.choiceOne}">
                                            <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent" id="valCan1<% out.print(candCount); %>">
                                                <i class="material-icons">check_circle</i>
                                                ${candidacy.choiceOne}
                                            </button>
                                        </a>
                                        <div class="mdl-tooltip mdl-tooltip--large mdl-tooltip--top" data-mdl-for="valCan1<% out.print(candCount); %>">Valider la Candidature pour le poste de ${candidacy.choiceOne}</div>
                                        <a href="validatecandidacy?email=${candidacy.candidate.email}&label=${candidacy.convention.label}&choice=${candidacy.choiceTwo}">
                                            <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent" id="valCan2<% out.print(candCount); %>">
                                                <i class="material-icons">check_circle</i>
                                                ${candidacy.choiceTwo}
                                            </button>
                                        </a>
                                        <div class="mdl-tooltip mdl-tooltip--large mdl-tooltip--top" data-mdl-for="valCan2<% out.print(candCount); %>">Valider la Candidature pour le poste de ${candidacy.choiceTwo}</div>
                                    </div>
                                </div>
                                <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="delCan<% out.print(candCount); %>" onclick="candidacyDialog('${candidacy.candidate.email}','${candidacy.candidate.fullname} ${candidacy.candidate.surname}','${candidacy.convention.label}')">
                                    <i class="material-icons">delete</i>
                                </button>
                                <div class="mdl-tooltip mdl-tooltip--large mdl-tooltip--left" data-mdl-for="delCan<% out.print(candCount); %>">Supprimer Candidature</div>
                            </section>
                        </c:if>
                    </c:forEach>
                    <section class="section--footer mdl-color--white mdl-grid"></section>
                </div>
                <c:choose>
                    <c:when test="${tab == 0}">
                            <div class="mdl-layout__tab-panel is-inactive" id="conventions">
                    </c:when>
                    <c:when test="${tab == 1}">
                            <div class="mdl-layout__tab-panel is-active" id="conventions">
                    </c:when>
                </c:choose>
                    <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
                        <div class="mdl-tabs__tab-bar">
                            <a href="#see-panel" class="mdl-tabs__tab is-active">Consulter</a>
                            <a href="#add-panel" class="mdl-tabs__tab">Ajouter</a>
                        </div>
                        <div class="mdl-tabs__panel is-active" id="see-panel">
                            <c:forEach var="convention" items="${conventions}">
                                <c:if test="${convention.active}">
                                    <%convCount += 1;%>
                                    <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
                                        <div class="mdl-card mdl-cell mdl-cell--12-col">
                                            <div class="mdl-card__supporting-text mdl-grid mdl-grid--no-spacing">
                                                <h4 class="mdl-cell mdl-cell--12-col">${convention.label}</h4>
                                                <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone">
                                                    <div class="section__circle-container__circle mdl-color--primary">
                                                        <i class="material-icons mdl-color-text--white">event</i>
                                                    </div>
                                                </div>
                                                <div class="section__text mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone">
                                                    <h5>${convention.label}</h5>
                                                    Détails : ${convention.detail}
                                                </div>
                                            </div>
                                            <div class="mdl-card__actions mdl-card--border">
                                                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--accent">
                                                    <i class="material-icons ">schedule</i>
                                                        ${convention.scheduled} à ${convention.place}
                                                </a>
                                            </div>
                                        </div>
                                        <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="delCon<% out.print(convCount); %>" name="delCon<% out.print(convCount); %>" onclick="conventionDialog('${convention.label}')">
                                            <i class="material-icons">delete</i>
                                        </button>
                                        <div class="mdl-tooltip mdl-tooltip--large mdl-tooltip--left" data-mdl-for="delCon<% out.print(convCount); %>">Supprimer Événement</div>
                                    </section>
                                </c:if>
                            </c:forEach>
                            <section class="section--footer mdl-color--white mdl-grid"></section>
                        </div>
                        <div class="mdl-tabs__panel" id="add-panel">
                            <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
                                <div class="mdl-card mdl-cell mdl-cell--12-col">
                                    <div class="mdl-card__supporting-text" style="align-content: center">
                                        <form id="creForm" method="post" action="createconvention">
                                            <fieldset>
                                                <h3>Nouvel Evenement</h3>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="label" name="label" pattern="[A-Z,a-z, ]*" type="text">
                                                    <label class="mdl-textfield__label" for="label">Libéllé</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <textarea class="mdl-textfield__input" id="detail" name="detail" rows="5" type="text"></textarea>
                                                    <label class="mdl-textfield__label" for="detail">Description</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="scheduled" name="scheduled" type="date">
                                                    <label class="mdl-textfield__label" for="scheduled">Date</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="place" name="place" pattern="[A-Z,a-z, ]*" type="text">
                                                    <label class="mdl-textfield__label" for="place">Lieu</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="position1" name="position1" pattern="[A-Z,a-z, ]*" type="text">
                                                    <label class="mdl-textfield__label" for="position1">Mission</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="position2" name="position2" pattern="[A-Z,a-z, ]*" type="text">
                                                    <label class="mdl-textfield__label" for="position2">Mission</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="position3" name="position3" pattern="[A-Z,a-z, ]*" type="text">
                                                    <label class="mdl-textfield__label" for="position3">Mission</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                    <input class="mdl-textfield__input" id="position4" name="position4" pattern="[A-Z,a-z, ]*" type="text">
                                                    <label class="mdl-textfield__label" for="position4">Mission</label>
                                                    <span class="mdl-textfield__error">FieldError</span>
                                                </div>
                                            </fieldset>
                                            <div style="overflow:auto;">
                                                <div style="float: right;">
                                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="nextBtn" type="submit">
                                                        Valider
                                                    </button>
                                                </div>
                                        </div>
                                        </form>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <footer class="mdl-mini-footer">
                    <div class="mdl-mini-footer__left-section">
                        <div class="mdl-logo">Tal'Asso</div>
                            <ul class="mdl-mini-footer__link-list">
                                <li><a href="https://github.com/lincolninnocent/Webice" target="_blank">GitHub</a></li>
                                <li><a href="#">JavaDoc</a></li>
                            </ul>
                        </div>
                </footer>
            </main>
        </div>
        <dialog class="mdl-dialog" id="dialog_convention">
            <h4 class="mdl-dialog__title">Suppression</h4>
            <div class="mdl-dialog__content" id="dialog_convention_content">
            </div>
            <div class="mdl-dialog__actions">
                <button class="mdl-button" id="dialog_convention_close" type="button">Non</button>
                <button class="mdl-button" id="dialog_convention_submit" type="button" value="">Oui</button>
            </div>
        </dialog>
        <dialog class="mdl-dialog" id="dialog_candidacy">
            <h4 class="mdl-dialog__title">Suppression</h4>
            <div class="mdl-dialog__content" id="dialog_candidacy_content">
            </div>
            <div class="mdl-dialog__actions">
                <button class="mdl-button" id="dialog_candidacy_close" type="button">Non</button>
                <button class="mdl-button" id="dialog_candidacy_submit" type="button" value="">Oui</button>
            </div>
        </dialog>
        <a id="bottom-right-button" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast" href="logout">Déconnexion</a>
        <script src="resources/material/scripts/material.min.js"></script>
        <script src="resources/scripts/administrations.js"></script>
    </body>
</html>
