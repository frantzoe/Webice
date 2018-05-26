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
        <link rel="stylesheet" href="../../resources/sheets/styles_main.css">
    </head>
    <body>
        <div class="talasso-main talasso-main--content mdl-layout mdl-js-layout">
            <main class="mdl-layout__content">
                <div class="talasso-form talasso-main__content mdl-grid">
                    <div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--4dp">
                        <div class="mdl-card__media mdl-color-text--grey-50">
                            <h3>Espace Recruteurs</h3>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="section-spacer"></div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <form id="logForm" method="post" action="login">
                                <fieldset>
                                    <h3>Connexion</h3>
                                    <div class="mdl-textfield mdl-js-textfield mdl mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email">
                                        <label class="mdl-textfield__label" for="email">Email</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="password" name="password" type="password">
                                        <label class="mdl-textfield__label" for="password">Mot de Passe</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                </fieldset>
                                <div style="overflow:auto;">
                                    <div style="float: right;">
                                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="prevBtn" type="submit">
                                            Connexion
                                        </button>
                                    </div>
                                </div>
                                <br><br><br>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <div class="mdl-layout__obfuscator"></div>
        </div>
        <script src="resources/material/scripts/material.min.js"></script>
    </body>
</html>
