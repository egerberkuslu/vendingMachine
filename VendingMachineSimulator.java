package vendingmachine;


public class VendingMachineSimulator {
   public static void main(String[] args) {
       CoinSet cs = new  CoinSet();
	   VendingMachineInterface vmI = new VendingMachineInterface();
       VendingMachine vm = new VendingMachine();
      
       vm.loadCoinSetDefault();
       cs.TotalCoinInMachine();
       vm.loadProducts();
       vmI.run();
   }
}
