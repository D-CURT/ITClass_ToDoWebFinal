

function sendChangedData(flag) {
    document.next.paramList.value = flag;
    document.next.submit();
}

function sendEditForm(flag) {
    document.editForm.paramEdit.value = flag;
    document.editForm.submit();
}

function sendEditTaskForm(flag) {
    document.editTaskForm.paramEdit.value = flag;
    document.editTaskForm.submit();
}

/*function sendToEditTask(id, titleTask, contentTask) {
    var tmp_titleTask = document.createElement("input");
    tmp_titleTask.type = "hidden";
    tmp_titleTask.name = "titleTask";
    tmp_titleTask.value = String(titleTask);

    var tmp_contentTask = document.createElement("input");
    tmp_contentTask.type = "hidden";
    tmp_contentTask.name = "contentTask";
    tmp_contentTask.value = String(contentTask);

    var tmp_IDTask = document.createElement("input");
    tmp_IDTask.type = "hidden";
    tmp_IDTask.name = "id";
    tmp_IDTask.value = String(id);

    var tmp_form = document.createElement("form");
    tmp_form.name = "toJSPForm";
    tmp_form.action = "editTask.jsp";
    tmp_form.method = "post";

    tmp_form.appendChild(tmp_contentTask);
    tmp_form.appendChild(tmp_titleTask);
    tmp_form.appendChild(tmp_IDTask);
    document.body.appendChild(tmp_form);

    tmp_form.submit();
}*/

function sendViewData(id, flag) {
    document.editForm.paramEdit.value = flag;
    document.editForm.idTask.value = id;
    document.editForm.submit();
}