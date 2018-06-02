<%--
  Created by IntelliJ IDEA.
  User: Lincoln
  Date: 5/17/2018
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="conventions" scope="request" type="java.util.List"/>
<% int chbxCount = 99; %>

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
                            <h3>Inscription Événement Tal'Asso</h3>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="section-spacer"></div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <form id="regForm" method="post" action="registration">
                                <fieldset class="tab">
                                    <h3>Informations</h3>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="surname" name="surname" pattern="[A-Z,a-z, ]*" type="text">
                                        <label class="mdl-textfield__label" for="surname">Nom</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="forename" name="forename" pattern="[A-Z,a-z, ]*" type="text">
                                        <label class="mdl-textfield__label" for="forename">Prénom</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="gender" name="gender" type="text" readonly>
                                        <label class="mdl-textfield__label" for="gender">Genre</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                        <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu" for="gender">
                                            <li class="mdl-menu__item" id="female" onclick="setGenre('Féminin')">Féminin</li>
                                            <li class="mdl-menu__item" id="male" onclick="setGenre('Masculin')">Masculin</li>
                                        </ul>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="birthday" name="birthday" type="date">
                                        <label class="mdl-textfield__label" for="birthday">Anniversaire</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email">
                                        <label class="mdl-textfield__label" for="email">Email</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="telephone" name="telephone" pattern="^(?:0|\(?\+33\)?\s?|0033\s?)[1-79](?:[\.\-\s]?\d\d){4}$" type="tel">
                                        <label class="mdl-textfield__label" for="telephone">Telephone</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <textarea class="mdl-textfield__input" id="motivation" name="motivation" rows="5" type="text"></textarea>
                                        <label class="mdl-textfield__label" for="motivation">Motivation</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                    </div>
                                </fieldset>
                                <fieldset class="tab">
                                    <h3>Questionnaire</h3>
                                    <h5>Une voiture vous double à toute allure et se rabat brutalement devant vous.</h5>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q1a1">
                                            <input class="mdl-radio__button" id="q1a1" name="question-1" type="radio" value="1">
                                            <span class="mdl-radio__label">Vous pensez qu'on devrait renforcer les contrôles routiers pour empêcher de pareils abus.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q1a2">
                                            <input class="mdl-radio__button" id="q1a2" name="question-1" type="radio" value="2">
                                            <span class="mdl-radio__label">Vous lui faites immédiatement un appel de phare et un geste.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q1a3">
                                            <input class="mdl-radio__button" id="q1a3" name="question-1" type="radio" value="3">
                                            <span class="mdl-radio__label">Vous profitez du prochain feu rouge pour le féliciter avec humour de sa « bonne conduite ». </span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q1a4">
                                            <input class="mdl-radio__button" id="q1a4" name="question-1" type="radio" value="4">
                                            <span class="mdl-radio__label">Vous pensez qu''il doit avoir de bonnes raisons de conduire aussi vite.</span>
                                        </label>
                                    </p>

                                    <h5>Vous vous rendez chez le médecin.</h5>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q2a1">
                                            <input class="mdl-radio__button" id="q2a1" name="question-2" type="radio" value="1">
                                            <span class="mdl-radio__label">Vous préférez un traitement doux quitte à augmenter les doses progressivement.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q2a2">
                                            <input class="mdl-radio__button" id="q2a2" name="question-2" type="radio" value="2">
                                            <span class="mdl-radio__label">Vous avez déjà une idée de ce qui vous arrive et lui demandez un traitement de cheval pour régler l'affaire.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q2a3">
                                            <input class="mdl-radio__button" id="q2a3" name="question-2" type="radio" value="3">
                                            <span class="mdl-radio__label">Vous amenez toutes les analyses en votre possession et votre carnet de santé.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q2a4">
                                            <input class="mdl-radio__button" id="q2a4" name="question-2" type="radio" value="4">
                                            <span class="mdl-radio__label">Vous lui donnez le maximum d'informations même si c'est un peu en vrac.</span>
                                        </label>
                                    </p>

                                    <h5>Au travail, votre gestuelle la plus fréquente.</h5>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q3a1">
                                            <input class="mdl-radio__button" id="q3a1" name="question-3" type="radio" value="1">
                                            <span class="mdl-radio__label">Mouvements calmes, sans stress, visage doux.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q3a2">
                                            <input class="mdl-radio__button" id="q3a2" name="question-3" type="radio" value="2">
                                            <span class="mdl-radio__label">Démarche souple, gestes spontanés, visage communiquant.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q3a3">
                                            <input class="mdl-radio__button" id="q3a3" name="question-3" type="radio" value="3">
                                            <span class="mdl-radio__label">Attitude sérieuse, corps droit, stricte, bien contrôlé.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q3a4">
                                            <input class="mdl-radio__button" id="q3a4" name="question-3" type="radio" value="4">
                                            <span class="mdl-radio__label">Gestes rapides, poignée de main ferme, regard direct.</span>
                                        </label>
                                    </p>

                                    <h5>Avant de commencer un travail plaisant mais complexe.</h5>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q4a1">
                                            <input class="mdl-radio__button" id="q4a1" name="question-4" type="radio" value="1">
                                            <span class="mdl-radio__label">Vous imaginez le travail terminé et commencez avec enthousiasme.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q4a2">
                                            <input class="mdl-radio__button" id="q4a2" name="question-4" type="radio" value="2">
                                            <span class="mdl-radio__label">Vous vous entourez de gens compétents pour vous épauler.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q4a3">
                                            <input class="mdl-radio__button" id="q4a3" name="question-4" type="radio" value="3">
                                            <span class="mdl-radio__label">Vous listez les différentes étapes pour y arriver sans oubli et sans faute.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q4a4">
                                            <input class="mdl-radio__button" id="q4a4" name="question-4" type="radio" value="4">
                                            <span class="mdl-radio__label">Vous allez droit à l'essentiel, les détails viendront après les grandes étapes.</span>
                                        </label>
                                    </p>

                                    <h5>Votre principal défaut.</h5>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q5a1">
                                            <input class="mdl-radio__button" id="q5a1" name="question-5" type="radio" value="1">
                                            <span class="mdl-radio__label">Intransigeant, parfois distant.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q5a2">
                                            <input class="mdl-radio__button" id="q5a2" name="question-5" type="radio" value="2">
                                            <span class="mdl-radio__label">Trop gentil, manquant parfois d'affirmation.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q5a3">
                                            <input class="mdl-radio__button" id="q5a3" name="question-5" type="radio" value="3">
                                            <span class="mdl-radio__label">Impatient, coupant la parole parfois.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q5a4">
                                            <input class="mdl-radio__button" id="q5a4" name="question-5" type="radio" value="4">
                                            <span class="mdl-radio__label">Exubérant (très démonstratif), parfois dispersé</span>
                                        </label>
                                    </p>

                                    <h5>Face à vos collègues de travail.</h5>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q6a1">
                                            <input class="mdl-radio__button" id="q6a1" name="question-6" type="radio" value="1">
                                            <span class="mdl-radio__label">Vous préférez ne pas aller au-delà des relations professionnelles.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q6a2">
                                            <input class="mdl-radio__button" id="q6a2" name="question-6" type="radio" value="2">
                                            <span class="mdl-radio__label">Ils peuvent devenir avec le temps des amis.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q6a3">
                                            <input class="mdl-radio__button" id="q6a3" name="question-6" type="radio" value="3">
                                            <span class="mdl-radio__label">Ils sont souvent des copains.</span>
                                        </label>
                                    </p>
                                    <p>
                                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="q6a4">
                                            <input class="mdl-radio__button" id="q6a4" name="question-6" type="radio" value="4">
                                            <span class="mdl-radio__label">Ils pourraient devenir des concurrents éventuels.</span>
                                        </label>
                                    </p>
                                </fieldset>
                                <fieldset class="tab">
                                    <h3>Candidature</h3>
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input" id="choice" name="choice" type="text" readonly>
                                        <label class="mdl-textfield__label" for="choice">Choix</label>
                                        <span class="mdl-textfield__error">FieldError</span>
                                        <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu" for="choice" id="selist">
                                            <c:forEach var="convention" items="${conventions}">
                                                <li class="mdl-menu__item" onclick="setChoice(this)">${convention.label}</li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                    <div id="selection">
                                        <c:forEach var="convention" items="${conventions}">
                                            <div class="pos">
                                                <c:forEach var="position" items="${convention.positions.position}">
                                                    <% chbxCount += 1; %>
                                                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-1<% out.print(chbxCount); %>">
                                                        <input class="mdl-checkbox__input" id="checkbox-1<% out.print(chbxCount); %>" name="choices" type="checkbox" value="${position}">
                                                        <span class="mdl-checkbox__label">${position}</span>
                                                    </label>
                                                </c:forEach>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div style="margin-bottom: 256px;"></div>
                                </fieldset>

                                <div style="overflow:auto;">
                                    <div style="float: right;">
                                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="prevBtn" onclick="nextPrev(-1)" type="button">
                                            Précédent
                                        </button>
                                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="nextBtn" onclick="nextPrev(1)" type="button">
                                            Suivant
                                        </button>
                                    </div>
                                </div>
                                <div style="text-align:center;margin-top:40px;">
                                    <span class="step"></span>
                                    <span class="step"></span>
                                    <span class="step"></span>
                                </div>
                                <br><br><br>
                            </form>
                        </div>
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
        <script src="resources/scripts/formstep.js"></script>
    </body>
</html>
