import java.util.Scanner;

class Ticket {
    private int ticketNo;
    private String customerName;
    private int seatNo;

    Ticket(int ticketNo, String customerName, int seatNo) {
        this.ticketNo = ticketNo;
        this.customerName = customerName;
        this.seatNo = seatNo;
    }

    public void display() {
        System.out.println("\n--- Ticket Info ---");
        System.out.println("Name: " + customerName);
        System.out.println("Ticket no: " + ticketNo);
        System.out.println("Seat no: " + seatNo);
        System.out.println("-------------------\n");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] seatNo = new int[10];  
        int ticketCounter = 1;

        while (true) {
            System.out.println("Available seats:");
            for (int i = 0; i < 10; i++) {
                if (seatNo[i] == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter seat number to book (0-9): ");
            int selectedSeat = sc.nextInt();
            sc.nextLine(); 

            if (selectedSeat < 0 || selectedSeat >= 10) {
                System.out.println("Invalid seat number. Try again.\n");
                continue;
            }

            if (seatNo[selectedSeat] == 1) {
                System.out.println("Seat is already booked. Choose another one.\n");
                continue;
            }

            seatNo[selectedSeat] = 1;
            Ticket t = new Ticket(ticketCounter, name, selectedSeat);
            t.display();
            ticketCounter++;

            System.out.print("Do you want to book another ticket? (yes/no): ");
            String answer = sc.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                System.out.println("Thank you!");
                break;
            }
        }
    }
}