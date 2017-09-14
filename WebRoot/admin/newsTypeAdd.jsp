
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<form name="formnewsType" method="post" action="NewsTypeServlet">  
  <TABLE width=40% height="38" border=0 align="center" cellPadding=0 cellSpacing=0 class="left_txt">
    <TBODY>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif">增加分类</TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">分类名称</TD>
        <TD colspan="6" align="center" background="images/news-title-bg.gif"><input name="tname" type="text" id="tname"></TD>
      </TR>
  <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">分类标识</TD>
        <TD colspan="6" align="center" background="images/news-title-bg.gif"><input name="flag" type="text" id="flag"></TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif"><input name="sbt" type="submit" id="sbt" value="增加"></TD>
      </TR>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
    </TBODY>
  </TABLE>
</form>
</body>
