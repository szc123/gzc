// UploadBean.java; class file size 2712 bytes

package net.fiyu.edit;

public class UploadBean
{
  private String sfileext;
  private String sfilesize;
  private String sflashext;
  private String sflashsize;
  private String simageext;
  private String simagesize;
  private String smediaext;
  private String smediasize;
  private String sremoteext;
  private String sremotesize;
  private String suploaddir;

  public UploadBean() {
  }

  public String getSfileext() {
    return sfileext;
  }

  public String getSfilesize() {
    return sfilesize;
  }

  public String getSflashext() {
    return sflashext;
  }

  public String getSflashsize() {
    return sflashsize;
  }

  public String getSimageext() {
    return simageext;
  }

  public String getSimagesize() {
    return simagesize;
  }

  public String getSmediaext() {
    return smediaext;
  }

  public String getSmediasize() {
    return smediasize;
  }

  public String getSremoteext() {
    return sremoteext;
  }

  public String getSremotesize() {
    return sremotesize;
  }

  public String getSuploaddir() {
    return suploaddir;
  }

  static public void main(String[] args) {
    UploadBean uploadBean1;
    uploadBean1 = new UploadBean();
  }

  public void setSfileext(String sfileext) {
    this.sfileext = sfileext;
  }

  public void setSfilesize(String sfilesize) {
    this.sfilesize = sfilesize;
  }

  public void setSflashext(String sflashext) {
    this.sflashext = sflashext;
  }

  public void setSflashsize(String sflashsize) {
    this.sflashsize = sflashsize;
  }

  public void setSimageext(String simageext) {
    this.simageext = simageext;
  }

  public void setSimagesize(String simagesize) {
    this.simagesize = simagesize;
  }

  public void setSmediaext(String smediaext) {
    this.smediaext = smediaext;
  }

  public void setSmediasize(String smediasize) {
    this.smediasize = smediasize;
  }

  public void setSremoteext(String sremoteext) {
    this.sremoteext = sremoteext;
  }

  public void setSremotesize(String sremotesize) {
    this.sremotesize = sremotesize;
  }

  public void setSuploaddir(String suploaddir) {
    this.suploaddir = suploaddir;
  }
}
