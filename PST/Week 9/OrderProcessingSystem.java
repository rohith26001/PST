import java.util.*;

class OrderException extends Exception {
    OrderException(String msg) {
        super(msg);
    }
}

public class OrderProcessingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String product = sc.next();
            int qty = sc.nextInt();
            int stock = sc.nextInt();

            try {
                if (qty > stock) {
                    throw new OrderException("Order " + id + " failed: Insufficient stock");
                }
                System.out.println("Order " + id + " processed successfully");
            } catch (OrderException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}