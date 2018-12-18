
/*
 * Copyright (c) 2018. toxic
 */

function toDbEdit(url){
    //执行user-form表达提交
    $.ajax({
        url:$("#db_edit_form").attr("action"),
        type:"POST",
        data:$("#db_edit_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function dbEditReset() {
    $("#db_edit_form").reset();
}