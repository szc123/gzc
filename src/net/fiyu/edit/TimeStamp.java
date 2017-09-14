// TimeStamp.java; class file size 2715 bytes

package net.fiyu.edit;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeStamp
{
  private String am_pm;
  private java.util.Calendar c;
  private String date;
  private String day;
  private String hour;
  private String minute;
  private String month;
  private String nanos;
  private String second;
  private String year;

  public TimeStamp() {
    int i;
    int j;
    c = new java.util.GregorianCalendar();
    year = Integer.toString(c.get(1));
    i = c.get(2);
    i++;
    month = Integer.toString(i);
    day = Integer.toString(c.get(5));
    j = c.get(10);
    minute = Integer.toString(c.get(12));
    second = Integer.toString(c.get(13));
    nanos = Integer.toString(c.get(14));
    i = c.get(9);
    if (i == 1) {
      hour = new StringBuffer().append(hour).append(12).toString();
    }
    hour = Integer.toString(j);
    am_pm = Integer.toString(i);
  }

  public String Time_Article() {
    date = new StringBuffer().append(add(year)).append(add(month)).append(add(day)).append(add(hour)).append(add(minute)).append(add(second)).append(add(nanos)).toString();
    return date;
  }

  public String Time_Date() {
    date = new StringBuffer().append(add(year)).append("-").append(add(month)).append("-").append(add(day)).append(" ").append(add(hour)).append(":").append(add(minute)).append(":").append(add(second)).toString();
    return date;
  }

  public String Time_Stamp() {
    date = new StringBuffer().append(add(year)).append(add(month)).append(add(day)).append(add(hour)).append(add(minute)).append(add(second)).append(add(nanos)).toString();
    return date;
  }

  public String Time_YMD() {
    date = new StringBuffer().append(add(year)).append(add(month)).append(add(day)).append(add(hour)).append(add(minute)).append(add(second)).toString();
    return date;
  }

  public String add(String s) {
    int i;
    i = s.length();
    if (i == 1) {
      s = new StringBuffer().append("0").append(s).toString();
    }
    return s;
  }

  public String getAm_pm() {
    return add(am_pm);
  }

  public String getDay() {
    return add(day);
  }

  public String getHour() {
    return add(hour);
  }

  public String getMinute() {
    return add(minute);
  }

  public String getMonth() {
    return add(month);
  }

  public String getNanos() {
    return add(nanos);
  }

  public String getSecond() {
    return add(second);
  }

  public String getYear() {
    return add(year);
  }
}
