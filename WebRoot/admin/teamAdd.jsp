
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

<!-- window.content_html.getHTML() 在打开的窗口window中取找到名字name=content_html的窗口 里面的HTML内容getHTML()  -->
<!--document.formTeam.infomation.value  document 当前整个页面的代码中去找到表单formTeam里面名字叫做infomation的文本区域  的值value - -->
<script type="text/javascript">

    function subForm(){
    document.formTeam.infomation.value=window.content_html.getHTML(); 
    document.formTeam.submit();
    
    }

</script>



<body>
<form action="TeamServlet" method="post" name="formTeam" id="formTeam">  
  <TABLE width=90% height="38" border=0 align="center" cellPadding=0 cellSpacing=0 class="left_txt">
    <TBODY>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif">增加团队</TD>
      </TR>
      <TR>
        <TD width="17%" height="28" align="center" background="images/news-title-bg.gif">姓名</TD>
        <TD width="83%" colspan="6" align="left" background="images/news-title-bg.gif"><input name="tname" type="text" id="tname">
		
		
		
		
		</TD>
      </TR>
      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">相片</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif">
		
		
		<div id="showimg" ></div>
		
		
		
		<input name="pic" type="hidden" id="pic">
		<!--frmName 当前表单名字  ImgName 上传控件名字  filepath 上传文件的路径      -->
   <iframe src="uploadIMG.jsp?frmName=formTeam&ImgName=pic&filepath=upload" name="uploadpic"    width=100% marginwidth="0" height=30 marginheight="0" scrolling=no  frameborder=0>
               
   
   </iframe>
		
		</TD>
      </TR>
	  
	  
	   <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">性别</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="sex" type="radio" value="1" checked>
          男
          <input name="sex" type="radio" value="0">
          女</TD>
	   </TR>
	  
	  
	  
	   <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">职位</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="position" type="text" id="position"></TD>
      </TR>
	  
	  
	   <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">分管</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="workinfo" type="text" id="workinfo"></TD>
      </TR>
	    <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">顺序</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif"><input name="sort" type="text" id="sort"></TD>
      </TR>
	      <TR>
        <TD height="28" align="center" background="images/news-title-bg.gif">简介</TD>
        <TD colspan="6" align="left" background="images/news-title-bg.gif">
		
		
		<textarea name="infomation" cols="40" rows="8" id="content"  style="display: none" ></textarea>
		
		
		 <iframe id="contents"  name="content_html"
src="../webeditor/eWebEditor.jsp?id=content&style=standard"
frameborder="0" scrolling="no" width="650" height="350"></iframe>
		
		
		
		</TD>
	      </TR>
	  
      <TR>
        <TD height="28" colspan="7" align="center" background="images/news-title-bg.gif"><input name="sbt" type="button"    onclick="subForm()"    id="sbt" value="增加"></TD>
      </TR>
      <TR>
        <TD height="5" colspan="7"></TD>
      </TR>
    </TBODY>
  </TABLE>
</form>
</body>
