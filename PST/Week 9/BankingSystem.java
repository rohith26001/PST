import java.util.*;

class Account {
    int accNo;
    String name;
    int balance;

    Account(int accNo, String name, int balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

class Bank {
    HashMap<Integer, Account> map = new HashMap<>();

    void addAccount(Account a) {
        map.put(a.accNo, a);
    }

    void deposit(int accNo, int amount) {
        if (!map.containsKey(accNo)) {
            System.out.println("Account not found");
            return;
        }
        Account a = map.get(accNo);
        a.balance += amount;
        System.out.println("Deposited " + amount + " to " + a.name);
    }

    void withdraw(int accNo, int amount) {
        if (!map.containsKey(accNo)) {
            System.out.println("Account not found");
            return;
        }
        Account a = map.get(accNo);
        if (a.balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            a.balance -= amount;
            System.out.println("Withdrawn " + amount + " from " + a.name);
        }
    }

    void transfer(int from, int to, int amount) {
        if (!map.containsKey(from) || !map.containsKey(to)) {
            System.out.println("Account not found");
            return;
        }

        Account a = map.get(from);
        Account b = map.get(to);

        if (a.balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            a.balance -= amount;
            b.balance += amount;
            System.out.println("Transferred " + amount + " from " + a.name + " to " + b.name);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Bank bank = new Bank();

        for (int i = 0; i < n; i++) {
            bank.addAccount(new Account(sc.nextInt(), sc.next(), sc.nextInt()));
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            String op = sc.next();

            if (op.equals("DEPOSIT")) {
                bank.deposit(sc.nextInt(), sc.nextInt());
            } else if (op.equals("WITHDRAW")) {
                bank.withdraw(sc.nextInt(), sc.nextInt());
            } else if (op.equals("TRANSFER")) {
                bank.transfer(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        }
    }
}