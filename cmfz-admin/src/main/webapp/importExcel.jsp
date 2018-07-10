<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#add").linkbutton({
			width:'100',
		});
	});

</script>
<form id="importexcelff" method="post" enctype="multipart/form-data">
	<div style="margin-left: 100px;margin-top: 20px">

		上传文件：<input class="easyui-filebox" data-options="width:180," style="margin:20px;" name="fileExcel"/><br><br>

	</div>

</form>