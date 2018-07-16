function sendNextForm(flag) {
    document.next.paramList.value = flag;
    document.next.submit();
}

function sendEditForm(flag) {
    document.editForm.paramEdit.value = flag;
    document.editForm.submit();
}