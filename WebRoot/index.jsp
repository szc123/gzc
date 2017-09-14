<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="teamdao" class="com.gzc.dao.impl.TeamDaoImpl" ></jsp:useBean>
<jsp:useBean id="newsdao" class="com.gzc.dao.impl.NewsDaoImpl" ></jsp:useBean>
<%
pageContext.setAttribute("teamlist", teamdao.findTeam()  );
pageContext.setAttribute("cnxwlist",newsdao.findNews("cnxw",6));
pageContext.setAttribute("zcfglist",newsdao.findNews("zcfg",6));
pageContext.setAttribute("gzdtlist",newsdao.findNews("gzdt",6));
pageContext.setAttribute("gzfclist",newsdao.findNews("gzfc",8));
pageContext.setAttribute("piclist",newsdao.findPicNews());
%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>湖北省武汉市楚信公证处</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="top">
<p>www.hbchuxin.com<br /><button>设为首页</button><button>加入收藏</button></p>
</div>
<div class="banner">
	<ul>
		<li><a href="index.jsp">首页</a></li>
		<li><a href="gywm.jsp">关于我们</a></li>
		<li><a href="gzdt.jsp">公证动态</a></li>
		<li><a href="ywfw.jsp">业务范围</a></li>
		<li><a href="sfbz.jsp">收费标准</a></li>
		<li><a href="bzzn.jsp">办证指南</a></li>
		<li><a href="gzsq.jsp">公证申请</a></li>
		<li><a href="gzzx.jsp">公证咨询</a></li>
		<li><a href="gzbg.jsp">公证表格</a></li>
		<li><a href="lxwm.jsp">联系我们</a></li>
	</ul>
</div>
<div class="main">
	<div class="left fleft">
		<div class="flash"><img src="pic/flash.jpg" /></div>
		<div class="gztd">
			<p><img src="img/name.jpg" /><a href="listTeam.jsp">全部</a></p>
			<ul>
			<c:forEach items="${teamlist}"  var="team"  >
				<li>  <a  href="viewTeam.jsp?tid=${team.tid}"  >     <img src="${team.pic}"  width="140"  height="150"     />  </a>       </li>
			</c:forEach>
			</ul>
		</div>
		<div class="leftdiv">
			<div class="divnew_1 fleft">
				<p class="name"><span>机构简介</span><a href="#"><img src="img/more.gif" /></a></p>
				<p class="nr">  湖北省武汉市楚信公证处（原湖北省公证处）于一九九三年经司法部、省政府批准成立的国家公证机关，根据司法部《公证机构执业管理办法》的规定，二○○六年三月更名为湖北省武汉市楚信公证处。多年来，在湖北省司法厅的直接领导下，在社会各界人士的大力支持下，我处经历了开创、摸索、发展、兴旺的突进式变化，成为省司法厅的一个重要窗口和全省公证业的龙头。我处本着...</p>
			</div>
			<div class="divnew_2 fright">
				<p class="name"><span>处内新闻</span><a href="newslist.jsp?flag=cnxw"><img src="img/more.gif" /></a></p>
				<ul>
				
				  <c:forEach items="${cnxwlist}"  var="cnxw"  >
					<li class="name">・<a href="viewnews.jsp?nid=${cnxw.nid}"    title="${cnxw.content}"      >${cnxw.title}</a></li><li class="time">${cnxw.pubdate}</li>
				 </c:forEach>
					
				</ul>
			</div>
		</div>
		<div class="leftdiv">
			<div class="divnew_1 fleft">
				<p class="name"><span>政策法规</span><a href="newslist.jsp?flag=zcfg"><img src="img/more.gif" /></a></p>
				<ul>
				<c:forEach items="${zcfglist}"  var="zcfg"  >
					<li class="name">・<a href="viewnews.jsp?nid=${zcfg.nid}"    title="${zcfg.content}"      >${zcfg.title}</a></li><li class="time">${zcfg.pubdate}</li>
				 </c:forEach>
				</ul>
			</div>
			<div class="divnew_2 fright">
				<p class="name"><span>公证动态</span><a href="newslist.jsp?flag=gzdt"><img src="img/more.gif" /></a></p>
				<ul>
					<c:forEach items="${gzdtlist}"  var="gzdt"  >
					<li class="name">・<a href="viewnews.jsp?nid=${gzdt.nid}"    title="${gzdt.content}"      >${gzdt.title}</a></li><li class="time">${gzdt.pubdate}</li>
				 </c:forEach>
				</ul>
			</div>
		</div>
		<div class="leftdiv2">
			<div class="leftdiv2bgdown">
				<p class="name"><span>公证风采</span><a href="newslist.jsp?flag=gzfc"><img src="img/more.gif" /></a></p>
				<div class="gzfc">
					<div id="demo01" style="overflow: hidden; margin: 0px 10px; width: 750px; height: 135px" align="center">
                    <table cellspacing="0" cellpadding="0" align="center" border="0">
                        <tbody>
                            <tr>
                                <td id="demo1" valign="middle">
                                    <table cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                                        <tr valign="top">
                                        </tr>
                                        <tr valign="middle">
                                            
                                            
                                            
                                            
                                            
											<c:forEach  items="${piclist}"  var="gzcfpic"   >
										  	 <td align="center">
                                                <a href="viewnews.jsp?nid=${gzcfpic.nid}">
                                                    <img src="${gzcfpic.pic}" alt="${gzcfpic.content}" /></a><br />
                                                <a href="viewnews.jsp?nid=${gzcfpic.nid}"  title="${gzcfpic.content}"  >${gzcfpic.title}</a>
                                                </td>
                                           
										   </c:forEach>
									
												
												
												
												
                                        </tr>
                                    </table>
                                </td>
                                <td id="demo11" valign="top">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <script>
var Picspeed=22
demo11.innerHTML=demo1.innerHTML
function Marquee1(){
if(demo11.offsetWidth-demo01.scrollLeft<=0)
demo01.scrollLeft-=demo1.offsetWidth
else{
demo01.scrollLeft++
}
}
var MyMar1=setInterval(Marquee1,Picspeed)
demo01.onmouseover=function() {clearInterval(MyMar1)}
demo01.onmouseout=function() {MyMar1=setInterval(Marquee1,Picspeed)}
                </script>




<ul class="gzfc_ul">
 <c:forEach items="${gzfclist}"  var="gzfc"   varStatus="vs"  >
<li class="name">・<a href="viewnews.jsp?nid=${gzfc.nid}"  title="${gzfc.content}"     >${gzfc.title}</a></li><li class="time">${gzfc.pubdate}</li>
${  vs.index==3?"</ul><ul class=gzfc_ul>":""     }
 </c:forEach>	
</ul>
					
					
					
					
					
				</div>
			</div>
		</div>
	</div>
	<div class="right fright">
		<div class="notice">
			<p class="name"><span>通知公告</span><a herf="#"><img src="img/more.gif" /></a></p>
			<marquee direction="up" onmousemove="this.stop();" onmouseout="this.start();" scrollamount="3"><img src="img/item1.gif" /> 为方便当事人办理公证,湖北省武汉市楚信公证处实行六天工作制。<br />
    <img src="img/item1.gif" /> 接待大厅全天对外开放，欢迎来电、来访！<br />
业务咨询：027-87363962、87831068、87304006 </marquee>
		</div>
		<div class="divname">
			<p class="name">机构职能</p>
			<ul class="jgzn">
				<li><a href="#">机构简介</a></li>
				<li><a href="#">公正团队</a></li>
				<li><a href="#">组织机构图</a></li>
			</ul>
		</div>
		<div class="divname">
			<p class="name">公证表格</p>
			<ul class="gzbg">
				<li><a href="#">公证申请表</a></li>
				<li><a href="#">公证证明表</a></li>
				<li><a href="#">继承权证明表</a></li>
				<li><a href="#">申办学历公证的证明</a></li>
				<li><a href="#">经济事项公证申请表</a></li>
				<li><a href="#">申办出生公证的证明</a></li>
				<li><a href="#">申办经历公证的证明</a></li>
				<li><a href="#">申办亲属关系公证证明</a></li>
			</ul>
		</div>
		<div class="divname">
			<p class="name">特色服务</p>
			<ul class="tsfw">
				<li><a href="#">涉外公证</a></li>
				<li><a href="#">保全证据公证</a></li>
				<li><a href="#">继承公证</a></li>
				<li><a href="#">夫妻财产约定公证</a></li>
				<li><a href="#">提存公证</a></li>
			</ul>
		</div>
		<div class="rightdown"><a href="#"><img src="img/piclink01.jpg" /></a><a href="wszx.jsp"><img src="img/piclink02.jpg" /></a><a href="#"><img src="img/piclink03.jpg" /></a><br /><img class="map" src="img/map.jpg" /></div>
	</div>
</div>
<div class="link"><select><option>各部委网站</option></select><select><option>北京市委办局网站</option></select><select><option>其他省市司法厅局网站</option></select>
</div>
<div class="footer">
	<p>湖北省武汉市楚信公证处  版权所有  2009-2011<br />
地址：湖北省武汉市武昌区水果湖广场B座3楼 邮编：430071 业务咨询：027-87363962、87831068、87304006 投诉监督电话：027-87233500<br />
E-mail：gongzheng@hbchuxin.com 公交车可以乘坐14、108、411、552、709、701、578路公共汽车或者1路电车到水果湖站下车</p>
</div>
</body>
</html>












































