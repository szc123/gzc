<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.gzc.bean.News"%>
<jsp:useBean id="dao"  class="com.gzc.dao.impl.NewsDaoImpl" ></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("news",dao.findById(  Integer.parseInt(request.getParameter("nid"))));
%>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="css/calendar.css" >
<script type="text/javascript" src="js/calendar.js" ></script>  
<script type="text/javascript" src="js/calendar-zh.js" ></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>


<style type="text/css">
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


<!-- window.content_html.getHTML() 在打开的窗口window中取找到名字name=content_html的窗口 里面的HTML内容getHTML()  -->
<!--document.formNews.infomation.value  document 当前整个页面的代码中去找到表单formNews里面名字叫做infomation的文本区域  的值value - -->
<script type="text/javascript">

    function subForm(){
    document.formNews.content.value=window.content_html.getHTML(); 
    document.formNews.submit();
    
    }

</script>



<body>
<form name="formNews" method="post" action="NewsServlet">
  <TABLE width=90% height="38" border=0 align="center" cellPadding=0 cellSpacing=0 class="left_txt">
    <TBODY>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif">修改团队</TD>
      </TR>
      <TR>
        <TD width="17%" height="28" align="center" background="images/news-title-bg.gif">标题</TD>
        <TD width="83%" colspan="6" align="left" background="images/news-title-bg.gif"><input name="title" type="text" id="title"   value=${news.title }  >
		
		<input  type="hidden"  name="nid" value="${news.nid}"  >
		<input  type="hidden"  name="tid" value="${news.tid}"  >
		<input  type="hidden"  name="nowpage" value="${param.nowpage}"  >
		</TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">图片</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif">
        
        
        <div id="showimg" >
        <c:if test="${!  empty news.pic }">
        <img  src="../${news.pic }"   width="100"  height="100"   >  
        </c:if>
        
        </div>
            <input name="pic" type="hidden" id="pic"   value=${news.pic }   >
            
            
            
            
            <!--frmName 当前表单名字  ImgName 上传控件名字  filepath 上传文件的路径      -->
            <iframe src="uploadIMG.jsp?frmName=formNews&ImgName=pic&filepath=upload" name="uploadpic"    width=100% marginwidth="0" height=30 marginheight="0" scrolling=no  frameborder=0> </iframe></TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">置顶</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="istop" type="radio" value="1"    ${news.istop==1?"checked":"" }    >
          是
            <input name="istop" type="radio" value="0"   ${news.istop==0?"checked":"" }    >
            否</TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">时间</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="pubdate" type="text" id="pubdate"   value=${news.pubdate }    onclick="return showCalendar('pubdate', 'y-mm-dd');"    ></TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">作者</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="author" type="text" id="author"   value=${news.author }  ></TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">顺序</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="sort" type="text" id="sort"   value=${news.sort}   ></TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">内容</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif">
		
		
		<textarea name="content" cols="40" rows="8" id="content"    style="display: none"  > ${news.content } </textarea>
		
		
				
	
		
		
		 <iframe id="contents"  name="content_html"
src="../webeditor/eWebEditor.jsp?id=content&style=standard"
frameborder="0" scrolling="no" width="650" height="350"></iframe>
		
		
		
		
		
		
		</TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif"><input name="sbt" type="button"   onClick="subForm()"      id="sbt" value="修改"></TD>
      </TR>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
    </TBODY>
  </TABLE>
</form>
</body>
