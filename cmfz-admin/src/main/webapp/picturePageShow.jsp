<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
	 
	 	$("#tb").datagrid({
            url:"${pageContext.request.contextPath}/pageshow.do",

            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,

            columns:[[
                {field:"pictureId",title:"标识编号",width:50},
                {field:"pictureName",title:"文件名",width:30},
                {field:"pictureDescription",title:"描述信息",width:30},
                {field:"pictureStatus",title:"轮播图状态",width:30},
                {field:"pictureDate",title:"轮播图创建时间",width:30},

            ]],

            view: detailview,
/*
rowData  是当前选中行的对象
用其点上文件名


* */
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picturePath + '" style="height:50px;"></td>' +
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
		$("#addPic").dialog({	//点击增加弹出一个注册的窗口
			
			width:500,
			height:400,
			modal:true,		//定义是否将窗体显示为模式化窗口
			shadow:true,	//在窗体显示的时候显示阴影
			href:"/cmfz-admin/addPic.jsp",
			buttons:[
			         {
			        	 iconCls:"icon-save" ,text:"添加",handler:function(){
			        		 //提交表单到后台进行注册
			        		 $("#ff").form("submit",{
			        			 url:"http://localhost:8088/cmfz-admin/registpic.do",
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
                                             msg:"轮播图已添加",
                                             timeout:2000,
                                             showType:"slider",
                                         });
                                         $("#addPic").dialog("close");
									 }

			        			 }
			        		 });
 
			        	 },
			         },
			  		],
			
		});
	 
	}
	
	function remove(){
		
		var value = $("#tb").datagrid("getSelected");	//获得
		console.log(value);
		$.ajax({
			type:"POST",
			url:"http://localhost:8088/cmfz-admin/remove.do",
			data:"pictureId="+value.pictureId,
			success:function(message){

				if(message == "ok"){

                    //成功后，刷新页面
                    $("#tb").datagrid("reload");
					 $.messager.show({
							title:"我的消息",
							msg:"轮播图已删除",
							timeout:2000,
							showType:"slider",
					 });
				}
			}
		});

	}

    function update(){

        //选中要修改的行
        var value = $("#tb").datagrid("getSelected");
		alert(value.pictureId);

        $("#updatePic").dialog({

            width:500,
            height:400,
            modal:true,		//定义是否将窗体显示为模式化窗口
            shadow:true,	//在窗体显示的时候显示阴影
            href:"/cmfz-admin/updatePicForm.jsp",
            onOpen: function(){

                $("#updateff").form("load",{
                    pictureId:value.pictureId,
                    pictureName:value.pictureName,
                    pictureDescription:value.pictureDescription,
                    pictureStatus:value.pictureStatus
                });

            },
            buttons:[
                {
                    iconCls:"icon-edit" ,
					text:"修改",
					handler:function(){

						//提交表单到后台进行修改
						$("#updateff").form("submit",{
							url:"http://localhost:8088/cmfz-admin/modifyPic.do",
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
										msg:"轮播图已修改",
										timeout:2000,
										showType:"slider",
									});
									$("#updatePic").dialog("close");
								}

							}
						});

					},
                },
            ],

        });


    }

 	function searchAll(value,name){
 		
		console.log(value+"-----"+name );
	} 
</script>

<table id="tb">
	<div id="like">
 	 
 		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增',onClick:add"></a> 
 		
 		<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true,text:'删除' ,onClick:remove"></a>
		
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改' ,onClick:update" ></a>
		

	
 	</div> 
</table>
<div id="addPic"></div>
<div id="updatePic"></div>