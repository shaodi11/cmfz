<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
	 
	 	$("#logtb").datagrid({
            url:"${pageContext.request.contextPath}/logPageShow.do",

            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,

            columns:[[
                {field:"logId",title:"id",width:50},
                {field:"userName",title:"操作者",width:30},
                {
                    field:"logDate",title:"执行时间",width:30,
					formatter:function (value,row,index) {
                        var date = new Date(value);
						var year = date.getFullYear();
						var month = date.getMonth();
						var day = date.getDay();
						var hour = date.getHours();
						var minus = date.getMinutes();
                    	var second = date.getSeconds();
                    	return year+"年"+month+"月"+day+"日"+hour+"时"+minus+"分"+second+"秒";
                    }
				},
                {field:"logResource",title:"执行类",width:30},
                {field:"logAction",title:"执行类型",width:30},
                {field:"logMessage",title:"执行参数",width:30},
                {field:"logResult",title:"执行结果",width:30},
            ]],

            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                   // '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/guruPic/' + rowData.guruPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>操作者: ' + rowData.userName + '</p>' +
                    '<p>执行参数: ' + rowData.logMessage + '</p>' +
                    '<p>执行结果: ' + rowData.logResult + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

           // toolbar:"#logLike",//顶部面板
	 		striped:true,	//数据间样式交叉展示
	 		pagination : true,	//为true 时 DataGrid控件底部会显示分页工具栏，自动将page和rows传给后台
			pageList : [ 1, 2, 4, 6, 8, 10 ],
			pageSize : 4,	//设置初始页面数量
			fitColumns: true,//根据内容的大小自动设置表格的宽度
			singleSelect:true,
		 
	 	});
	 	
	 
	});
 
	function add(){
		$("#addGuru").dialog({	//注册的对话框窗口

			width:500,
			height:300,
			modal:true,		//定义是否将窗体显示为模式化窗口
			shadow:true,	//在窗体显示的时候显示阴影
			href:"/cmfz-admin/addGuru.jsp",
			buttons:[
			         {
			        	 iconCls:"icon-save" ,
						 text:"添加",
						 handler:function(){
			        		 //提交表单到后台进行注册
			        		 $("#ff").form("submit",{
			        			 url:"${pageContext.request.contextPath}/registGuru.do",
			        			 onSubmit:function(){
                                     var isValid = $(this).form('validate');
                                     if (!isValid){
                                         $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                                     }
                                     return isValid;	// 返回false终止表单提交

			        			 },
			        			 success:function(message){
			        			     if(message == "ok"){
                                         //成功后，刷新页面
                                         $("#logtb").datagrid("reload");
                                         $.messager.show({
                                             title:"我的消息",
                                             msg:"上师已添加",
                                             timeout:2000,
                                             showType:"slider",
                                         });
                                         $("#addGuru").dialog("close");
									 }

			        			 }
			        		 });

			        	 },
			         },
			  		],

		});

	}


</script>

<table id="logtb">
	<div id="logLike">
<%--

 		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增',onClick:add"></a>

 		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改' ,onClick:update"></a>

		<input id="likeselect" class="easyui-textbox" style="width:150px" data-options="prompt:'请您输入关键字'" name="guruName" />

		<a class="easyui-linkbutton" data-options="iconCls:'icon-zoom',plain:true,text:'查询' ,onClick:selectName"></a>
--%>

	</div>
</table>

