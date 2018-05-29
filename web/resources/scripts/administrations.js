function conventionDialog(con) {
    'use strict';
    const dialog = document.querySelector('#dialog_convention');
    const closeButton = dialog.querySelector('#dialog_convention_close');
    const submitButton = dialog.querySelector('#dialog_convention_submit');
    const content = dialog.querySelector('#dialog_convention_content');
    //var showButton = document.getElementById(n);
    if (!dialog.showModal) {
        dialogPolyfill.registerDialog(dialog);
    }
    const closeClickHandler = function (event) {
        dialog.close();
    };
    const showClickHandler = function (event) {
        content.innerHTML = '<p>Confirmez-vous vouloir supprimer l\'événement <strong>' + con + '</strong> ?</p>';
        dialog.showModal();
    };
    closeButton.addEventListener('click', closeClickHandler);
    submitButton.addEventListener('click', closeClickHandler);
    showClickHandler('click');
}

function candidacyDialog(can, con) {
    'use strict';
    const dialog = document.querySelector('#dialog_candidacy');
    const closeButton = dialog.querySelector('#dialog_candidacy_close');
    const submitButton = dialog.querySelector('#dialog_candidacy_submit');
    const content = dialog.querySelector('#dialog_candidacy_content');
    if (!dialog.showModal) {
        dialogPolyfill.registerDialog(dialog);
    }
    let closeClickHandler = function (event) {
        dialog.close();
    };
    let showClickHandler = function(event) {
        content.innerHTML = '<p>Confirmez-vous vouloir supprimer la candidature de <strong>' + can + '</strong> à l\'événement <strong>' + con + '</strong> ?</p>';
        dialog.showModal();
    };
    closeButton.addEventListener('click', closeClickHandler);
    submitButton.addEventListener('click', closeClickHandler);
    showClickHandler('click');
}