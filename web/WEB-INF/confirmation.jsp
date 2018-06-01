<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/17/2018
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Inscription | Tal'Asso</title>

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=fr">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="resources/material/sheets/material.grey-orange.min.css">
        <link rel="stylesheet" href="resources/sheets/styles_main.css">
    </head>
    <body>
        <div class="talasso-main talasso-main--content mdl-layout mdl-js-layout">
            <main class="mdl-layout__content">
                <div class="talasso-form talasso-main__content mdl-grid">
                    <div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp">
                        <div class="mdl-card__media mdl-color-text--grey-50">
                            <h3>Confirmation Inscription</h3>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="section-spacer"></div>
                        </div>
                        <div class="mdl-card__supporting-text mdl-typography--text-center">
                            <h3>John Doe</h3>
                            Votre candidature à bien été prise en compte.
                            <br>
                            On reviendra vers vous dans les plus brefs délais.
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="section-spacer"></div>
                        </div>
                        <div style="overflow:auto;">
                            <div align="center">
                                <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast" href="<c:url value="/"/>">Retour à l'Accueil</a>
                                <a class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast" href="consultation">Voir les Événements</a>
                            </div>
                        </div>
                        <div style="margin-bottom: 64px;"></div>
                    </div>
                </div>
            </main>
            <div class="mdl-layout__obfuscator"></div>
        </div>
        <div id="registration_snackbar" class="mdl-js-snackbar mdl-snackbar">
            <div class="mdl-snackbar__text"></div>
            <button class="mdl-snackbar__action" type="button"></button>
        </div>
        <script src="resources/material/scripts/material.min.js"></script>
    </body>
</html>
