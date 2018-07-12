<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript">

	$(function() {
	 
	 	$("#gurutb").datagrid({
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
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/guruPic/' + rowData.guruPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>上师法名: ' + rowData.guruName + '</p>' +
                    '<p>上师简介: ' + rowData.guruIntroduction + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

            toolbar:"#gurulike",//顶部面板
	 		striped:true,	//数据间样式交叉展示
	 		pagination : true,	//为true 时 DataGrid控件底部会显示分页工具栏，自动将page和rows传给后台
			pageList : [ 1, 2, 4, 6, 8, 10 ],
			pageSize : 4,	//设置初始页面数量
			fitColumns: true,//根据内容的大小自动设置表格的宽度
			singleSelect:true,
		 
	 	});
	 	
	 
	});


<shiro:hasPermission name="manager:regist" >
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
			        		 $("#guruaddff").form("submit",{
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
                                         $("#gurutb").datagrid("reload");
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
</shiro:hasPermission>

<shiro:hasPermission name="manager:modify">
 
    function update(){

        //选中要修改的行
        var value = $("#gurutb").datagrid("getSelected");
        alert(value.guruId+"  \  "+value.guruName);

        $("#updateGuru").dialog({

            width:500,
            height:400,
            modal:true,		//定义是否将窗体显示为模式化窗口
            shadow:true,	//在窗体显示的时候显示阴影
            href:"${pageContext.request.contextPath}/updateGuruForm.jsp",
            onOpen: function(){

                $("#updateguruff").form("load",{
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
						$("#updateguruff").form("submit",{
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
                                    $("#gurutb").datagrid("reload");
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
</shiro:hasPermission>   
    
<shiro:hasPermission name="manager:likeShow">
    //模糊查询
    function selectName(){

		//获取要查询的上师名关键字
        var name = $("#likeselect").val();
        $("#gurutb").datagrid({
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
            //rowData 为当前所指的实体
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/guruPic/' + rowData.guruPic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>上师法名: ' + rowData.guruName + '</p>' +
                    '<p>上师简介: ' + rowData.guruIntroduction + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

            toolbar:"#gurulike",//顶部面板
            striped:true,	//数据间样式交叉展示
            pagination : true,	//为true 时 DataGrid控件底部会显示分页工具栏，自动将page和rows传给后台
            pageList : [ 1, 2, 4, 6, 8, 10 ],
            pageSize : 4,	//设置初始页面数量
            fitColumns: true,//根据内容的大小自动设置表格的宽度
            singleSelect:true,

        });

    }
</shiro:hasPermission>

<shiro:hasPermission name="manager:exportExcel">
	//文件导出
    function exportExcel() {
        //会打开一个新的页面，操作后跳回原页面
        //window.open("${pageContext.request.contextPath}/exportExcel.do");

		//会去执行所给路径的代码，给他什么执行什么，当前页面不会改动
        location.href="${pageContext.request.contextPath}/exportExcel.do";
    }
</shiro:hasPermission>

<shiro:hasPermission name="manager:importExcel">
    //文件导入
    function importExcel() {

        $("#upload").dialog({	//文件导出的对话框窗口

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
                        $("#importexcelff").form("submit",{
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
                                    $("#gurutb").datagrid("reload");
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
</shiro:hasPermission>

</script>

<table id="gurutb">
	<div id="gurulike">
 	 
 		<a onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
 		
 		<a onclick="update()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改' "></a>
		
		<a onclick="importExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-20130406125519344_easyicon_net_16',plain:true,text:'批量导入'"></a>

		<a onclick="exportExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-20130406125647919_easyicon_net_16',plain:true,text:'导出文件' "></a>

		<input id="likeselect" class="easyui-textbox" style="width:150px" data-options="prompt:'请您输入关键字'" name="guruName" />

		<a onclick="selectName()" class="easyui-linkbutton" data-options="iconCls:'icon-zoom',plain:true,text:'查询'"></a>
		
	</div>
</table>
<div id="addGuru"></div>
<div id="updateGuru"></div>
<div id="upload"></div>

