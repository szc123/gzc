<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ;
		
%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>/admin/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style></head>

<body >

<form name="form" method="post" action="upfileIMG.jsp?frmName=<%=request.getParameter("frmName")%>&ImgName=<%=request.getParameter("ImgName")%>&filepath=<%=request.getParameter("filepath") %>"  enctype="multipart/form-data">
<table bgcolor="#EAEAF3"width="90%" border=0 cellspacing=0 cellpadding=0>
<tr><td height="30" bgcolor="#FFFFFF">
<input type="hidden" name="fname">
<input name="file1" type="file" size="15">
<input type="submit" name="Submit" value=" 上传文件 " onClick="fname.value=file1.value">
</td>
</tr>
</table>
</form>



</body>
</html>

