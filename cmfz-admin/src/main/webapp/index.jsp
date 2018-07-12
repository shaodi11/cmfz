<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="div1">
    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
</div>
<textarea id="text1" style="width:100%; height:200px;"></textarea>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1')
    var $text1 = $('#text1')
    editor.customConfig.onchange = function (html) {
        alert($text1.val()+"开始");
        $text1.val(html);

        alert($text1.val()+"end");
    }
    editor.create()
    // 初始化 textarea 的值
    $text1.val(editor.txt.html())


</script>
<hr>
<hr>

<%--判断是否认证成功，认证成功时显示--%>
<shiro:authenticated>
欢迎：<shiro:principal></shiro:principal>
</shiro:authenticated>

<shiro:notAuthenticated>
    请登录！
</shiro:notAuthenticated>


<%--通过 记住我，或认证通过时，显示内容--%>
<shiro:user>
    yes! is me
</shiro:user>

<%--游客，未认证显示--%>
<shiro:guest></shiro:guest>

<%--判断主体是否有指定的角色，有则展示内容--%>
<shiro:hasRole name="root">
    this is root
</shiro:hasRole>

<%--缺失此角色时，显示内容--%>
<shiro:lacksRole name="xx">
    not has xx role
</shiro:lacksRole>

<%--有任意角色时，均显示内容--%>
<shiro:hasAnyRoles name="root,xx,admin">

    hsa root,xx,admin  anyone

</shiro:hasAnyRoles>

<%--对资源有此权限时--%>
<shiro:hasPermission name="manager:regist">
    has regist
</shiro:hasPermission>

<shiro:hasPermission name="user:regist">

    !!!!!!!!!!!!!!!!!!!!!!11

</shiro:hasPermission>


