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

function sendToEditTask(id ,contentTask) {
    var tmp_contentTask = document.createElement("input");
    tmp_contentTask.type = "hidden";
    tmp_contentTask.name = "contentTask";
    tmp_contentTask.value = contentTask;

    var tmp_IDTask = document.createElement("input");
    tmp_IDTask.type = "hidden";
    tmp_IDTask.name = "id";
    tmp_IDTask.value = id;

    var tmp_form = document.createElement("form");
    tmp_form.name = "toJSPForm";
    tmp_form.action = "editTask.jsp";
    tmp_form.method = "post";

    tmp_form.appendChild(tmp_contentTask);
    tmp_form.appendChild(tmp_IDTask);
    document.body.appendChild(tmp_form);

    tmp_form.submit();

}