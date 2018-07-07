<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#add").linkbutton({
			width:'100',
		});
	});

</script>
<form id="ff" method="post" enctype="multipart/form-data">
	<div style="margin-left: 100px;margin-top: 20px">

		文件上传：<input class="easyui-filebox" data-options="width:180," style="margin:20px;" name="myFile"/><br><br>
		描述信息： <input class="easyui-textbox" data-options="width:170,"  name="pictureDescription"/><br><br>

	</div>

</form>