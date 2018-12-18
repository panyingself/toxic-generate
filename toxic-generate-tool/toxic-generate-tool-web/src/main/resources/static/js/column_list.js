//Demo
layui.use('form', function(){
    var form = layui.form;

    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });
});

$(function () {
    //提交，最终验证。
    $('#send').click(function(){
        $("form :input").trigger('blur');
        var numError = $('form .onError').length;

        if(numError){
            return false;
        }
        else{
            $('#listForm').submit();
        }
    });
    //保存
    $("#saveButton").click(function(){
        var $this = $(this);
        var i="1";

        for(var j=0;j<${tableInfo.listColumn?size};j++){
            i = j+1;
            var note = $("#remarks_"+i).val();
            note += "@"+$("#itemType_"+i).val();
            note += "@"+$("#remark_"+i).val();
            // if($("#isShow_"+i).is(":checked")){
            //     note += $("#isShow_"+i).val();
            // }
            // if($("#isSearch_"+i).is(":checked")){
            //     note += $("#isSearch_"+i).val();
            // }
            // if($("#isFk_"+i).is(":checked")){
            //     note += $("#isFk_"+i).val();
            // }
            //
            // if($("#valid_vnn_"+i).is(":checked")){
            //     note += $("#valid_vnn_"+i).val();
            // }
            // if($("#valid_vi_"+i).is(":checked")){
            //     note += $("#valid_vi_"+i).val();
            // }
            // if($("#valid_vd_"+i).is(":checked")){
            //     note += $("#valid_vd_"+i).val();
            // }
            // if($("#valid_ve_"+i).is(":checked")){
            //     note += $("#valid_ve_"+i).val();
            // }
            // if($("#valid_vm_"+i).is(":checked")){
            //     note += $("#valid_vm_"+i).val();
            // }
            // if($("#valid_vt_"+i).is(":checked")){
            //     note += $("#valid_vt_"+i).val();
            // }
            // note += $("#editControl_"+i+" option:selected").val();
            // if((note.indexOf("#EP")>=0) || (note.indexOf("#EN")>=0)){
            //     if($("#parameter_"+i).val() != "")
            //         note += "（"+$("#parameter_"+i).val()+"）";
            //     //note += "&";
            // }
            // note += $("#logic_"+i+" option:selected").val();

            $("#remarks_"+i).val(note);
            //alert(note)
        }
        var strAct = "${ctx}/initcode";
        $('#listForm').attr("action",strAct);
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/initcode" ,//url
            data: $('#listForm').serialize(),
            success: function (result) {
                if (result == 200) {
                    //配置一个透明的询问框
                    layer.msg('恭喜您，修改参数成功！', {
                        time: 20000, //20s后自动关闭
                        btnAlign: 'c',
                        btn: ['明白了']
                    });
                }
                ;
            },
            error : function() {
                layer.msg('修改参数异常！', {
                    time: 20000, //20s后自动关闭
                    btnAlign: 'c',
                    btn: ['明白了']
                });
            }
        });
    });

    //生成
    $("#generateButton").click(function(){
        var $this = $(this);
        //alert("ssss");
        var strAct = "${ctx}/generate/code";
        $('#listForm').attr("action",strAct);

        $('#listForm').submit();
    });



});