package com.ssafy.dto;

public class HouseInfo {
   
   private int no;
   private String dong;
   private String AptName;
   private String buildYear;
   
   public HouseInfo(int no, String dong, String aptName, String buildYear) {
      this.no = no;
      this.dong = dong;
      AptName = aptName;
      this.buildYear = buildYear;
   }
   
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public String getDong() {
      return dong;
   }
   public void setDong(String dong) {
      this.dong = dong;
   }
   public String getAptName() {
      return AptName;
   }
   public void setAptName(String aptName) {
      AptName = aptName;
   }
   public String getBuildYear() {
      return buildYear;
   }
   public void setBuildYear(String buildYear) {
      this.buildYear = buildYear;
   }
   @Override
   public String toString() {
      return "HouseInfo [no=" + no + ", dong=" + dong + ", AptName=" + AptName + ", buildYear=" + buildYear + "]";
   }   
   
}