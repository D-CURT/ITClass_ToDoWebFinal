function sendNextForm(flag) {
    document.next.paramList.value = flag;
    /*if (document.next.paramList == 'recycle') {
        document.checker.flagCheck.value = 'can_restore';
    }*/
    document.next.submit();
}

function sendEditForm(flag) {
    document.editForm.paramEdit.value = flag;

    document.editForm.submit();
}