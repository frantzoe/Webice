let currentTab = 0; // Current tab is set to be the first tab (0)
let currentPos;
let selected = false;
showTab(currentTab); // Display the crurrent tab
setChecks();

function showTab(n) {
    // This function will display the specified tab of the form...
    const x = document.getElementsByClassName("tab");
    x[n].style.display = "block";
    //... and fix the Previous/Next buttons:
    if (n === 0) {
        document.getElementById("prevBtn").style.display = "none";
    } else {
        document.getElementById("prevBtn").style.display = "inline";
    }
    if (n === (x.length - 1)) {
        document.getElementById("nextBtn").innerHTML = "Soumettre";
    } else {
        document.getElementById("nextBtn").innerHTML = "Suivant";
    }
    //... and run a function that will display the correct step indicator:
    fixStepIndicator(n)
}

function nextPrev(n) {
    // This function will figure out which tab to display
    const x = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (currentTab === 0 && n === 1 && !validateForm()) return false;
    // Hide the current tab:
    if (currentTab === 1 && n === 1 && !validateQuiz()) return false;
    // **
    if (currentTab === 2 && n === 1 && !validateCand()) return false;
    // **
    x[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form...
    if (currentTab >= x.length) {
        // ... the form gets submitted:
        document.getElementById("regForm").submit();
        return false;
    }
    // Otherwise, display the correct tab:
    showTab(currentTab);
}

function validateForm() {
    // This function deals with validation of the form fields
    let x, y, i, valid = true;
    x = document.getElementsByClassName("tab");
    y = x[currentTab].getElementsByTagName("input");
    // A loop that checks every input field in the current tab:
    for (i = 0; i < y.length; i++) {
        // If a field is empty...
        if (y[i].value === "" || y[i].validity.patternMismatch) {
            // **
            y[i].required = true;
            y[i].parentElement.MaterialTextfield.change();
            // **
            valid = false;
        }
    }
    // If the valid status is true, mark the step as finished and valid:
    if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
    } else {
        showSnack('Veillez à Bien Remplir Toutes les Cases');
    }
    return valid; // return the valid status
}

function validateQuiz() {
    // This function deals with validation of the form fields
    let valid = true;
    for (let i = 1; i <= 6; i++) {
        const qry = 'input[name="question-' + i + '"]:checked';
        const rdg = document.querySelectorAll(qry).length;
        if (rdg !== 1) {
            console.log("Question " + i + " unchecked " + rdg);
            valid = false;
        }
    }
    // If the valid status is true, mark the step as finished and valid:
    if (valid) {
        document.getElementsByClassName("step")[currentTab].className += " finish";
    } else {
        showSnack('Veuillez Répondre à Toute les Questions');
    }

    return valid; // return the valid status
}

function validateCand() {
    const checked = document.querySelectorAll(".mdl-checkbox__input:checked").length;
    if (checked < 1) {
        showSnack('Veuillez Selectionner au Moins une Offre');
        return false;
    }
    return true;
}

function fixStepIndicator(n) {
    // This function removes the "active" class of all steps...
    let i, x = document.getElementsByClassName("step");
    for (i = 0; i < x.length; i++) {
        x[i].className = x[i].className.replace(" active", "");
    }
    //... and adds the "active" class on the current step:
    x[n].className += " active";
}

function goBack() {
    window.history.back();
}

function setChoice(element) {
    const positions = document.getElementsByClassName("pos");
    const choice = document.getElementById("choice");
    const index = [...element.parentElement.children].indexOf(element);
    choice.parentElement.MaterialTextfield.change(element.innerText);
    if (selected) {
        const checks = positions[currentPos].querySelectorAll(".mdl-checkbox__input:checked");
        for (let i = 0; i < checks.length; i++) {
            checks[i].parentElement.MaterialCheckbox.uncheck();
        }
        positions[currentPos].style.display = "none";
    } else {
        selected = true;
    }
    positions[index].style.display = "block";

    currentPos = index;
}

function setGenre(n) {
    document.getElementById("gender").parentElement.MaterialTextfield.change(n);
}

function setChecks() {
    const checks = document.querySelectorAll(".mdl-checkbox__input");
    for (let i = 0; i < checks.length; i++) {
        checks[i].onclick = selectiveCheck;
    }
}

function selectiveCheck() {
    const max = 3;
    const checked = document.querySelectorAll(".mdl-checkbox__input:checked");
    return checked.length < max;
}

function showSnack(message) {
    'use strict';
    const snackbarContainer = document.querySelector('#registration_snackbar');
    const data = {message: message};
    snackbarContainer.MaterialSnackbar.showSnackbar(data);
}
