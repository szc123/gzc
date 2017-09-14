<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.gzc.bean.Users"%>
<jsp:useBean id="usersdao"  class="com.gzc.dao.impl.UsersDaoImpl" ></jsp:useBean>
<%
pageContext.setAttribute("users",usersdao.findById(Integer.parseInt(request.getParameter("id"))));
%>





<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<body>
<form name="formUsers" method="post" action="UsersServlet">
  <TABLE width=40% height="38" border=0 align="center" cellPadding=0 cellSpacing=0 class="left_txt">
    <TBODY>
      <TR>
        <TD height="5" colspan="7">  <input type="hidden"    name="id"  value=${users.id }   />      </TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif">修改新用户</TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">用户名</TD>
        <TD colspan="6" align="center" background="images/news-title-bg.gif"><input name="uname" type="text" id="uname"   value="${users.uname}"    ></TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">密&nbsp;&nbsp;&nbsp;码</TD>
        <TD colspan="6" align="center" background="images/news-title-bg.gif"><input name="upwd" type="text" id="upwd"  value="${users.upwd }"  ></TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif"><input name="sbt" type="submit" id="sbt" value="修改"></TD>
      </TR>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
    </TBODY>
  </TABLE>
</form>
</body>
