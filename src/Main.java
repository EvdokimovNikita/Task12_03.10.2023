import java.util.Scanner;

public class Main {
    // имеется ноутбук с N USB портами, так же два типа переходника: на 2 гнезда (цена A р/шт) и на 5 гнезд (цена B р/шт),
    // рассчитать минимальную стоимость подключения для X числа устройств.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число портов компьютера: ");
        Integer quantityUSBPort = scanner.nextInt();
        System.out.println("Введите цену за 2-й адаптер:");
        Integer priceDoubleAdapter = scanner.nextInt();
        System.out.println("Введите цену за 5-й адаптер:");
        Integer priceFiveAdapter = scanner.nextInt();
        System.out.println("Введите количество гаджетов");
        Integer quantityGadgetsOfConnection = scanner.nextInt();
        scanner.close();
        calculation(quantityUSBPort, priceDoubleAdapter, priceFiveAdapter, quantityGadgetsOfConnection);

    }

    public static void calculation(Integer quantityUSBPort, Integer priceDoubleAdapter, Integer priceFiveAdapter, Integer quantityGadgetsOfConnection) {
        int portsNeeded = quantityGadgetsOfConnection - quantityUSBPort;
        if (portsNeeded <= 0) {
            System.out.println("Адаптеры не требуются");
        } else {
            int priceUseFiveAdapter = ((portsNeeded) / 4) * priceFiveAdapter + priceFiveAdapter;
            int priceUseMixAdapter = ((portsNeeded) / 4) * priceFiveAdapter + (portsNeeded % 4) * priceDoubleAdapter;
            int priceUseTwoAdapter = portsNeeded * priceDoubleAdapter;
            int minPrice = Math.min(priceUseFiveAdapter, Math.min(priceUseTwoAdapter, priceUseMixAdapter));
            System.out.println(minPrice);
        }
    }
}
