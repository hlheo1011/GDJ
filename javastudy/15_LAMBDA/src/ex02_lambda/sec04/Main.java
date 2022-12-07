package ex02_lambda.sec04;

public class Main {

   public static void main(String[] args) {
      
      Soil soil = new Soil();
      
      /*
      // 어떤 자동차가 오는지 임시객체
      soil.sellOil(new Car() {
         @Override
         public void addOil() {
            int oil = 30;
            soil.setTotalOil(soil.getTotalOil() - oil);  // 주유소가 가지고있는 오일양 - 오일양
            soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
            System.out.println("감사합니다 BMW");
         }
      });
      
      // 자동차가 올때마다 복사가능
      soil.sellOil(new Car() {
         @Override
         public void addOil() {
            int oil = 50;
            soil.setTotalOil(soil.getTotalOil() - oil);  // 주유소가 가지고있는 오일양 - 오일양
            soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
            System.out.println("감사합니다 소나타");
         }
      });
      */
      
      
      
      soil.sellOil(() -> {
            int oil = 30;
            soil.setTotalOil(soil.getTotalOil() - oil);
            soil.setEarning(soil.getEarning() + oil * soil.getPayPerLiter());
            System.out.println("감사합니다 BMW");
      });
      
      System.out.println(soil.getTotalOil());
      System.out.println(soil.getEarning());

   }

}