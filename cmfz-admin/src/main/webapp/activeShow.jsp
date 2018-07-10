<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>

<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')

    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/upload.do' ; // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    var $text1 = $('#text1')

    editor.customConfig.onchange = function (html) {
        $text1.val(html);
    }
    editor.create()
    // 初始化 textarea 的值
    $text1.val(editor.txt.html())

    $(function () {

        $("#actor").combobox({
            url:'${pageContext.request.contextPath}/selectGuru.do',
            valueField:'guruName',
            textField:'guruName',
        });


        $("#btn").linkbutton({
            onClick:function () {
                $("#activeForm").form("submit",{
                    url:"http://localhost:8088/cmfz-admin/registArticle.do",
                    onSubmit:function(){
                        var isValid = $(this).form('validate');
                        if (!isValid){
                            $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                        }
                        return isValid;	// 返回false终止表单提交

                    },
                    success:function(message){

                        if (message == "ok"){

                            //修改成功后，刷新页面
                            $("#activeForm").form("reset");

                            $.messager.show({
                                title:"我的消息",
                                msg:"文章已修改",
                                timeout:2000,
                                showType:"slider",
                            });
                            $("#updatePic").dialog("close");

                        }

                    }
                })
            }
        });

        $("#reset").linkbutton({

			onClick:function () {
				$("#activeForm").form("reset");
            }
		});

    })


</script>

	<form id="activeForm" method="post" style="margin: 20px">

		文章标题 ：<input class="easyui-textbox" data-options="prompt:'请您输入文章标题...'" name="articleTitle"> <br><br>

		文章作者 ：<input id="actor" name="articleName" value="=====请选择法师=====" ><br><br>

		文章状态 ：<input name="articleStatus" class="easyui-switchbutton" data-options="onText:'上架',offText:'未上架'"><br><br>

		文章内容：<textarea id="text1" name="articleIntroduction" style="width:100%; height:200px;display: none;"></textarea>

		<div id="editor">
			<p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
		</div>

		<a class="easyui-linkbutton" id="btn" style="margin: 10px " data-options="iconCls:'icon-add'" >提交</a>&nbsp;&nbsp;&nbsp;

		<a class="easyui-linkbutton" id="reset" style="margin: 10px " data-options="iconCls:'icon-add'">重置</a>&nbsp;&nbsp;&nbsp;


	</form>
