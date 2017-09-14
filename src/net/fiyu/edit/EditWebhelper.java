// EditWebhelper.java; class file size 6239 bytes

package net.fiyu.edit;

import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class EditWebhelper
{
  String[] aButtonCode;
  String[] aButtonHTML;
  org.dom4j.Document document;
  org.dom4j.Document document2;
  EditWebhelper ew;
  public String filename;
  public String filename2;
  String sStyleDir;
  int size;

  public EditWebhelper() {
    size = 255;
    filename = "D:/style2.xml";
    filename2 = "D:/button2.xml";
    document = null;
    document2 = null;
    ew = null;
    sStyleDir = "blue";
    aButtonCode = new String[size];
    aButtonHTML = new String[size];
  }

  public String Code2HTML(String s_Code) {
    String CodeToHTML;
    int i;
    CodeToHTML = "";
    i = 0;
    while (i < size) {
      if (aButtonCode[i].equals(s_Code)) {
        CodeToHTML = aButtonHTML[i];
        return CodeToHTML;
      }
      i++;
    }
    return CodeToHTML;
  }

  public void InitButtonArray() {
    java.util.List list;
    java.util.List list2;
    java.util.Iterator it;
    java.util.Iterator it2;
    int i;
    int option;
    org.dom4j.Attribute attribute;
    org.dom4j.Element button;
    try {
      list = document2.selectNodes("Edit_Button/bcode");
      list2 = document2.selectNodes("Edit_Button/bcode/@name");
      it = list.iterator();
      it2 = list2.iterator();
      i = 0;
      option = 0;
      while (it.hasNext()) {
        attribute = (org.dom4j.Attribute) it2.next();
        button = (org.dom4j.Element) it.next();
        aButtonCode[i] = attribute.getValue();
        option = Integer.parseInt(memoString(button, "btype").getTextTrim());
        {
          switch (option) {
          case 0:
            aButtonHTML[i] = new StringBuffer().append("<DIV CLASS=\"").append(memoString(button, "bclass").getTextTrim()).append("\" TITLE=\"").append(memoString(button, "btitle").getTextTrim()).append("\" onclick=\"").append(memoString(button, "bevent").getTextTrim()).append("\"><IMG CLASS=\"Ico\" SRC=\"buttonimage/").append(sStyleDir).append("/").append(memoString(button, "bimage").getTextTrim()).append("\"></DIV>").toString();
            break;
          case 1:
            aButtonHTML[i] = new StringBuffer().append("<SELECT CLASS=\"").append(memoString(button, "bclass").getTextTrim()).append("\" onchange=\"").append(memoString(button, "bevent").getTextTrim()).append("\">").append(memoString(button, "bhtml").getTextTrim()).append("</SELECT>").toString();
            break;
          case 2:
            aButtonHTML[i] = new StringBuffer().append("<DIV CLASS=\"").append(memoString(button, "bclass").getTextTrim()).append("\">").append(notNull(memoString(button, "bhtml").getTextTrim())).append("</DIV>").toString();
          }
        }
        i++;
      }
      size = i;
    }
    catch (  Exception e) {
      e.printStackTrace();
    }
  }

  public EditBean InitPara() {
    EditBean bean;
    String sToolBar;
    java.util.List list;
    String[] aButton;
    int i;
    String[] aButton2;
    int j;
    bean = new EditBean();
    sToolBar = "";
    try {
      list = document.selectNodes("Edit_Style/style");
      bean.setSAutoRemote(getNodeValue(list, "sautoremote"));
      bean.setSStyleName("standard");
      bean.setSBaseUrl(getNodeValue(list, "sbaseurl"));
      bean.setSDetectFromWord(getNodeValue(list, "sdetectfromword"));
      bean.setSInitMode(getNodeValue(list, "sinitmod"));
      bean.setSStyleID(getNodeValue(list, "sid"));
      bean.setSStyleDir(getNodeValue(list, "sdir"));
      bean.setNStateFlag(getNodeValue(list, "sstateflag"));
      sStyleDir = getNodeValue(list, "sdir");
      InitButtonArray();
      aButton = getNodeValue(list, "stoolbar1").split("\\|");
      sToolBar = "<table border=0 cellpadding=0 cellspacing=0 width='100%' class='Toolbar' id='eWebEditor_Toolbar'>";
      sToolBar = new StringBuffer().append(sToolBar).append("<tr><td><div class='yToolbar'>").toString();
      i = 0;
      while (i < aButton.length) {
        if (aButton[i].equalsIgnoreCase("MAXIMIZE")) {
          aButton[i] = "Minimize";
        }
        sToolBar = new StringBuffer().append(sToolBar).append(Code2HTML(aButton[i])).toString();
        i++;
      }
      sToolBar = new StringBuffer().append(sToolBar).append("</div></td></tr>").toString();
      aButton2 = getNodeValue(list, "stoolbar2").split("\\|");
      sToolBar = new StringBuffer().append(sToolBar).append("<tr><td><div class='yToolbar'>").toString();
      j = 0;
      while (j < aButton2.length) {
        if (aButton2[j].equalsIgnoreCase("MAXIMIZE")) {
          aButton2[j] = "Minimize";
        }
        sToolBar = new StringBuffer().append(sToolBar).append(Code2HTML(aButton2[j])).toString();
        j++;
      }
      sToolBar = new StringBuffer().append(sToolBar).append("</div></td></tr></table>").toString();
      bean.setSToolBar(sToolBar);
      bean.setSStyleName(getNodeValue(list, "sdir"));
      bean.setSStyleUploadDir(getNodeValue(list, "suploaddir"));
      bean.setSVersion("\u98de\u9c7c\u4fee\u6539\u7248");
      bean.setSReleaseDate("2004-11-30");
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    document = null;
    return bean;
  }

  public EditWebhelper getInstance() {
    EditWebhelper ew;
    org.dom4j.io.SAXReader saxReader;
    ew = new EditWebhelper();
    try {
      saxReader = new org.dom4j.io.SAXReader();
      document = saxReader.read(new java.io.File(filename));
      document2 = saxReader.read(new java.io.File(filename2));
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return ew;
  }

  public String getNodeValue(java.util.List list, String Node) {
    java.util.Iterator it;
    org.dom4j.Element styleElement;
    java.util.Iterator memo;
    org.dom4j.Element memostring;
    it = list.iterator();
    if (it.hasNext()) {
      styleElement = (org.dom4j.Element) it.next();
      memo = styleElement.elementIterator(Node);
      if (memo.hasNext()) {
        memostring = (org.dom4j.Element) memo.next();
        return memostring.getTextTrim();
      }
      return "";
    }
    return "";
  }

  static public void main(String[] args) {
    EditWebhelper editWebhelper1;
    EditBean bean;
    editWebhelper1 = new EditWebhelper();
    editWebhelper1.filename = "D:/style2.xml";
    editWebhelper1.getInstance();
    bean = editWebhelper1.InitPara();
    System.out.println(bean.getSToolBar());
  }

  public org.dom4j.Element memoString(org.dom4j.Element button, String Node) {
    java.util.Iterator memo;
    org.dom4j.Element memostring;
    memo = button.elementIterator(Node);
    if (memo.hasNext()) {
      memostring = (org.dom4j.Element) memo.next();
      return memostring;
    }
    return null;
  }

  public String notNull(String str) {
    String s;
    s = str;
    if (str == null) {
      return "";
    }
    return s;
  }
}
