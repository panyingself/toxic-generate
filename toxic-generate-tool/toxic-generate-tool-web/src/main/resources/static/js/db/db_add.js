
function toDbAdd(url){
    //执行Db-form表达提交
    $.ajax({
        url:$("#db_add_form").attr("action"),
        type:"POST",
        data:$("#db_add_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function dbEditReset() {
    $("#db_add_form").reset();
}