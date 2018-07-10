<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		$("#updateff").form();
	});

</script>
<form id="updateguruff" method="post" enctype="multipart/form-data">
	<div style="margin-left: 100px;margin-top: 20px">

		ID：<input class="easyui-textbox" data-options="width:150," style="margin:20px;readonly:true;" name="guruId"/><br><br>

		上师法名： <input class="easyui-textbox" data-options="width:150," style="margin:20px;" name="guruName"/><br><br>

		头像：<input class="easyui-filebox" data-options="width:180," style="margin:20px;" name="myFile"/><br><br>

		描述信息： <input class="easyui-textbox" data-options="width:170,"  name="guruIntroduction"/><br><br>


	</div>


</form>