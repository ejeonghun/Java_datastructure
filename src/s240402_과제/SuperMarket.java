package s240402_과제;

// 대기큐와 서버는 각각 1개 이며, 손님 도착과 서비스는 독립 수행된다.
// 손님 도착 시 대기큐에 입력하고, 도착 순서대로 손님에게 서비스를 수행한다.
// 손님별 서비스 시간과 평균 대기시간을 출력하시오.
import java.util.LinkedList;
import java.util.Queue;

class Customer {
    String name;
    int arrivalTime;
    int serviceTime;

    public Customer(String name, int arrivalTime, int serviceTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
}

public class SuperMarket {
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer("A", 20, 5),
                new Customer("B", 22, 4),
                new Customer("C", 23, 2),
                new Customer("D", 30, 3)
        };

        Queue<Customer> queue = new LinkedList<>();
        for (Customer customer : customers) {
            queue.add(customer);
        }

        int currentTime = 0;
        int totalWaitTime = 0;

        while (!queue.isEmpty()) {
            Customer customer = queue.poll();
            if (customer.arrivalTime > currentTime) {
                currentTime = customer.arrivalTime;
            }

            System.out.println("고객: " + customer.name);
            System.out.println("도착시간: " + customer.arrivalTime);
            System.out.println("시작: " + currentTime);

            totalWaitTime += currentTime - customer.arrivalTime;
            currentTime += customer.serviceTime;

            System.out.println("종료: " + currentTime);
            System.out.println();
        }

        double averageWaitTime = (double) totalWaitTime / customers.length;

        System.out.printf("평균 대기 시간: %.2f\n", averageWaitTime);
    }
}