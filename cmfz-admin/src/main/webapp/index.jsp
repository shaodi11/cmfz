<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>

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
