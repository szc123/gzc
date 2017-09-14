
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.gzc.bean.NewsType" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


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
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">新闻分类 </div></td>  
		
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><TABLE width=98% height="38" border=0 align="center" cellPadding=0 cellSpacing=0 class="left_txt">
      <TBODY>
        <TR>
          <TD height="5" colspan="5"></TD>
        </TR>
        
        
        <TR>
          <TD height="28" align="center" background="images/news-title-bg.gif">序号</TD>
          <TD align="center" background="images/news-title-bg.gif">分类名称</TD>
          <TD align="center" background="images/news-title-bg.gif">分类标识</TD>
          <TD colspan="2" align="center" background="images/news-title-bg.gif" class="left_txt">操作</TD>
        </TR>





<!-- forEach 循环  items 获取到集合或者数组      var 每次从集合或者数组中取出一个值出来      varStatus  循环的状态  -->
       <c:forEach  items="${newsTypelist}"    var="newsTypeBean"   varStatus="vs" >   
         <TR>
         <TD height="28" align="center" background="images/news-title-bg.gif">${vs.index+1 }</TD>
         <TD align="center" background="images/news-title-bg.gif"><a href="NewsServlet?nowpage=1&tid=${newsTypeBean.tid}">${newsTypeBean.tname }</a></TD>
         <TD align="center" background="images/news-title-bg.gif">${newsTypeBean.flag}</TD>
         <TD align="center" background="images/news-title-bg.gif" class="left_txt">
         
         
           <a href="newsTypeUpdate.jsp?tid=${newsTypeBean.tid }" >           修改</a>         </TD>
         <TD align="center" background="images/news-title-bg.gif" class="left_txt">
         
       <a href="NewsTypeServlet?tid=${newsTypeBean.tid }" > 删除</a>         </TD>
         </TR>
		</c:forEach>
		
	


        <TR>
          <TD height="5" colspan="5"></TD>
        </TR>
      </TBODY>
    </TABLE></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
