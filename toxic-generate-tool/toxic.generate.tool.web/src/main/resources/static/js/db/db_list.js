function toDbView(url){
    $("#api-main").load(url);
}

function dbListQuery() {
    alert("jobListQuery start");
}

function deleteDb(url,returnUrl) {
    $.ajax({
        url:url,
        type:"POST",
        success:function (result) {
            $("#api-main").load(returnUrl);
        }
    })
}

