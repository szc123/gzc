// UploadWebHelper.java; class file size 3099 bytes

package net.fiyu.edit;

import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class UploadWebHelper
{
  org.dom4j.Document document;
  EditWebhelper ew;
  public String filename;

  public UploadWebHelper() {
    filename = "D:/style2.xml";
    document = null;
    ew = null;
  }

  public UploadBean InitPara() {
    UploadBean bean;
    String sToolBar;
    java.util.List list;
    bean = new UploadBean();
    sToolBar = "";
    try {
      list = document.selectNodes("Edit_Style/style");
      bean.setSfileext(getNodeValue(list, "sfileext"));
      bean.setSfilesize(getNodeValue(list, "sfilesize"));
      bean.setSflashext(getNodeValue(list, "sflashext"));
      bean.setSflashsize(getNodeValue(list, "sflashsize"));
      bean.setSimageext(getNodeValue(list, "simageext"));
      bean.setSimagesize(getNodeValue(list, "simagesize"));
      bean.setSmediaext(getNodeValue(list, "smediaext"));
      bean.setSmediasize(getNodeValue(list, "smediasize"));
      bean.setSremoteext(getNodeValue(list, "sremoteext"));
      bean.setSremotesize(getNodeValue(list, "sremotesize"));
      bean.setSuploaddir(getNodeValue(list, "suploaddir"));
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    document = null;
    return bean;
  }

  public UploadWebHelper getInstance() {
    UploadWebHelper uw;
    org.dom4j.io.SAXReader saxReader;
    uw = new UploadWebHelper();
    try {
      saxReader = new org.dom4j.io.SAXReader();
      document = saxReader.read(new java.io.File(filename));
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return uw;
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
    UploadWebHelper w;
    UploadBean bean;
    w = new UploadWebHelper();
    w.getInstance();
    bean = w.InitPara();
    System.out.println(bean.getSfileext());
  }
}
