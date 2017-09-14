
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true"%>
<%@ page import="java.util.regex.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.jspsmart.upload.*"%>
<%@ page import="com.jspsmart.upload.SmartUpload"%>

<%@ page import="java.awt.*"%>
<%@ page import="javax.imageio.ImageIO"%>
<%@ page import="java.awt.image.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.sun.image.codec.jpeg.*"%>
<%@ page import="javax.servlet.*"%>



<link href="css/css.css" rel="stylesheet" type="text/css">
<style type="text/css">

.style1 {color: #FFFFFF} 
body {
	background-color: #FFFFFF;
}
</style> 

                  


<% 
String basePath = request.getContextPath()+"/";//获取项目路径

		
int maxFileSize=10490000;  //上传最大的文件值10兆
String strN="";  //由日期生成的新文件名字  
String imgTxt="";
String filepath = request.getParameter("filepath");//获取上传路径 pic
SmartUpload mySmartUpload=new SmartUpload();  //上传对象  ，它来源于添加的WEB-INF/lib/jspSmartUpload.jar
mySmartUpload.initialize(pageContext);//加载当前上下文
mySmartUpload.upload();//准给上传   开辟内存中缓冲空间
com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0); //mySmartUpload.getFiles() 获取所有的上传文件，getFile(0) 取得第一文件
if (!myFile.isMissing())   //如果上传的文件存在
{
	 //判断文件的后缀格式getFileExt()获取文件的扩展名(后缀名) ,这里只允许上传jpg和 gif两种格式
    if(myFile.getFileExt().equals("jpg")||myFile.getFileExt().equals("JPG")||myFile.getFileExt().equals("gif")||myFile.getFileExt().equals("GIF")){
    	Date CurrTime=new Date();  //当前时间 
		SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMddHHmmss"); //日期格式
		String strMyDate=formatter.format(CurrTime); //20170329153822  日期数据
		strN=strMyDate+"."+myFile.getFileExt();  //拼装新的文件名字  20170329153822.jpg
		if(myFile.getSize()<=maxFileSize){//在10兆以内的文件就上传
			imgTxt = filepath+"/"+strN;// pic/ 20170329153822.jpg 文件路径
			myFile.saveAs(imgTxt);//上传文件到 pic/ 20170329153822.jpg路径
		}
		
	}else{
    	out.println("<script>alert('只能上传jpg,gif文件!');history.go(-1);</script>");
	}
}
if(myFile.isMissing())
{
	strN="?T";
}

/***************************************************************************************/
/***************************添加水印****************************************************/
/***************************************************************************************/
//		ImageUtils.pressText("大家好", "D:\\Tomcat\\webapps\\jsphomework\\"+imgTxt, "黑体", 12, Color.red, 24, 0, 0,0.2f);
	
		
/***************************************************************************************/




%>
<script>
parent.document.<%=request.getParameter("frmName")%>.<%=request.getParameter("ImgName")%>.value="<%=imgTxt%>" ;

parent.document.getElementById("showimg").innerHTML="<img src=<%=basePath+imgTxt%> width=100  height=100>"


</script>

<table width="90%" border=0 align="left" cellpadding="6" cellspacing="0" bgcolor="#FFFFFF" >
  <tr> 
    <td colspan="3" >

[<a href="uploadIMG.jsp?frmName=<%=request.getParameter("frmName")%>&ImgName=<%=request.getParameter("ImgName")%>&filepath=<%=filepath %>">重新上传</a>]</td>
  </tr>
</table> 