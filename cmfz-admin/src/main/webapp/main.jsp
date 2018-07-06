<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<script type="text/javascript" src="/cmfz-admin/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/cmfz-admin/themes/IconExtension.css">


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

<script type="text/javascript" src="/cmfz-admin/js/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css" href="/cmfz-admin/themes/default/easyui.css">
<script type="text/javascript" src="/cmfz-admin/script/datagrid-detailview.js"></script>
<script type="text/javascript">

	//二级菜单点击后，在面板上添加选项卡
	function addPanel(menuName,menuURL) {

	    var status = $("#tt").tabs("exists",menuName);

	    if (status){	//选项卡已存在，选中选项卡

            $("#tt").tabs("select",menuName);

		}else{			//选项卡为存在，创建新的选项卡

            $("#tt").tabs("add",{
                title:menuName,
				href:"${pageContext.request.contextPath}/"+menuURL,
                closable:true,
            });
		}


    }
	
	$(function(){

	    $.ajax({		//页面加载时，用ajax异步请求获得菜单栏信息

			dataType:"json",
			url:"${pageContext.request.contextPath}/menu.do",
			success:function (menuList) {
			    //$.each()遍历需要两个参数，menuList	要遍历的对象 ，一个function（）方法，

			    //参数	index	遍历menuList对象时的当前下标
				//		obj		遍历过程中的临时变量

				//遍历响应还回来的结果，添加一级菜单标签
				 $.each(menuList,function (index , obj) {

				     //嵌套遍历，将一级菜单里的子集菜单放在con里，添加到分类的子项
				     var con = "" ;
				     $.each(obj.menuList,function (index , child) {
						 con += "<p style='text-align: center'><a type=\"easyui-linkbutton\" data-options=\"iconCls:'"+child.menuIcon+"'\" onclick=\" addPanel('"+child.menuName+"','"+child.menuURL+"') \">"+child.menuName+"</a></p>" ;
                     })

				     $("#aa").accordion("add",{

						 title:obj.menuName,
						 iconCls:obj.menuIcon,
						 selected:false,
						 content:con,

					 });

                 })
            }

		});
		

	    $("#aa").accordion({

            onSelect:function () {

            },

        });

	})
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">

		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>