<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#updateff").form();
	});

</script>
<form id="updateff" method="post">
	<div style="margin-left: 100px;margin-top: 20px">

		ID：<input class="easyui-textbox" data-options="width:150," style="margin:20px;readonly:true;" name="pictureId"/><br><br>
		文件名称：<input class="easyui-textbox" data-options="width:150," style="margin:20px;" name="pictureName"/><br><br>
		描述信息： <input class="easyui-textbox" data-options="width:170," name="pictureDescription"/><br><br>
		轮播状态： <input class="easyui-textbox" data-options="width:150," style="margin:20px;" name="pictureStatus"/><br><br>

	</div>


</form>