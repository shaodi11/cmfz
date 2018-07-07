<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
	 
	 	$("#tb").datagrid({
            url:"${pageContext.request.contextPath}/guruPageShow.do",

            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,

            columns:[[
                {field:"guruId",title:"上师编号",width:50},
                {field:"guruName",title:"上师法名",width:30},
                {field:"guruIntroduction",title:"描述信息",width:30},
            ]],

            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.guruPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.attr1 + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

            toolbar:"#like",//顶部面板
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
                                         $("#tb").datagrid("reload");
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
	

    function update(){

        //选中要修改的行
        var value = $("#tb").datagrid("getSelected");

        $("#updateGuru").dialog({

            width:500,
            height:400,
            modal:true,		//定义是否将窗体显示为模式化窗口
            shadow:true,	//在窗体显示的时候显示阴影
            href:"/cmfz-admin/updateGuruForm.jsp",
            onOpen: function(){

                $("#updateff").form("load",{
                    guruId:value.guruId,
                    guruName:value.guruName,
                    guruIntroduction:value.guruIntroduction
                });

            },
            buttons:[
                {
                    iconCls:"icon-edit" ,
					text:"修改",
					handler:function(){

						//提交表单到后台进行修改
						$("#updateff").form("submit",{
							url:"http://localhost:8088/cmfz-admin/modifyGuru.do",
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
                                    $("#tb").datagrid("reload");
									$.messager.show({
										title:"我的消息",
										msg:"上师信息已修改",
										timeout:2000,
										showType:"slider",
									});
									$("#updateGuru").dialog("close");
								}

							}
						});

					},
                },
            ],

        });

    }

    //模糊查询
    function selectName(){

		//获取要查询的上师名关键字
        var name = $("#likeselect").val();
        $("#tb").datagrid({
            url:"${pageContext.request.contextPath}/guruPageLikeShow.do?guruName="+name,

            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,

            columns:[[
                {field:"guruId",title:"上师编号",width:50},
                {field:"guruName",title:"上师法名",width:30},
                {field:"guruIntroduction",title:"描述信息",width:30},
            ]],

            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.guruPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.attr1 + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

            toolbar:"#like",//顶部面板
            striped:true,	//数据间样式交叉展示
            pagination : true,	//为true 时 DataGrid控件底部会显示分页工具栏，自动将page和rows传给后台
            pageList : [ 1, 2, 4, 6, 8, 10 ],
            pageSize : 4,	//设置初始页面数量
            fitColumns: true,//根据内容的大小自动设置表格的宽度
            singleSelect:true,

        });

    }

	//文件导出
    function exportExcel() {
        window.open("${pageContext.request.contextPath}/exportExcel.do");
    }

    //文件导入
    function importExcel() {

        alert("importExcel");
        $("#addGuru").dialog({	//注册的对话框窗口

            width:500,
            height:300,
            modal:true,		//定义是否将窗体显示为模式化窗口
            shadow:true,	//在窗体显示的时候显示阴影
            href:"/cmfz-admin/importExcel.jsp",
            buttons:[
                {
                    iconCls:"icon-save" ,
                    text:"提交",
                    handler:function(){
                        //提交表单到后台进行注册
                        $("#ff").form("submit",{
                            url:"${pageContext.request.contextPath}/importExcel.do",
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
                                    $("#tb").datagrid("reload");
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

<table id="tb">
	<div id="like">
 	 
 		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增',onClick:add"></a> 
 		
 		<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'修改' ,onClick:update"></a>

		<a onclick="importExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'批量导入'"></a>

		<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'导出文件' ,onClick:exportExcel"></a>

		<input id="likeselect" class="easyui-textbox" style="width:150px" data-options="prompt:'请您输入关键字'" name="guruName" />

		<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'查询' ,onClick:selectName"></a>

	</div>
</table>
<div id="addGuru"></div>
<div id="updateGuru"></div>
<div id="upload"></div>
<div id="download"></div>