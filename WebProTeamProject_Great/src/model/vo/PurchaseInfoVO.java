package model.vo;

public class PurchaseInfoVO {
   

   private String date;
   private String proname;
   private int proprice;
   private int proamount;
   private String img_urls;
   private String delivery_date;
   private String userId;
   
   public PurchaseInfoVO() {
      
   }
   
   public PurchaseInfoVO(String date, String proname, int proprice, int proamount, String img_urls,
         String delivery_date,String userId) {
      super();
      this.date = date;
      this.proname = proname;
      this.proprice = proprice;
      this.proamount = proamount;
      this.img_urls = img_urls;
      this.delivery_date = delivery_date;
      this.userId = userId;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getProname() {
      return proname;
   }

   public void setProname(String proname) {
      this.proname = proname;
   }

   public int getProprice() {
      return proprice;
   }

   public void setProprice(int proprice) {
      this.proprice = proprice;
   }

   public int getProamount() {
      return proamount;
   }

   public void setProamount(int proamount) {
      this.proamount = proamount;
   }

   public String getImg_urls() {
      return img_urls;
   }

   public void setImg_urls(String img_urls) {
      this.img_urls = img_urls;
   }

   public String getDelivery_date() {
      return delivery_date;
   }

   public void setDelivery_date(String delivery_date) {
      this.delivery_date = delivery_date;
   }

   @Override
   public String toString() {
      return "PurchaseInfoVO [date=" + date + ", proname=" + proname + ", proprice=" + proprice + ", proamount="
            + proamount + ", img_urls=" + img_urls + ", delivery_date=" + delivery_date + "]";
   }

}