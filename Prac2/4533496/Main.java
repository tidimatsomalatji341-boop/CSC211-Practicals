import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BinarySearchtree bst = new BinarySearchtree();
        String filename = "C:\\Users\\tidim\\Desktop\\test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(" ");
                String command = parts[0].toUpperCase();

                try {
                    switch (command) {
                        case "BUILD":
                            for (int i = 1; i < parts.length; i++) {
                                bst.insert(Integer.parseInt(parts[i]));
                            }
                            break;

                        case "INSERT":
                            bst.insert(Integer.parseInt(parts[1]));
                            break;

                        case "DELETE":
                            bst.delete(Integer.parseInt(parts[1]));
                            break;

                        case "IN_ORDER":
                            System.out.print("IN_ORDER: ");
                            bst.print_in_order();
                            System.out.println(); 
                            break;

                        case "SIZE":
                            System.out.println("SIZE: " + bst.getSize());
                            break;

                        case "HEIGHT":
                            System.out.println("HEIGHT: " + bst.height());
                            break;

                        case "SEARCH":
                            int sVal = Integer.parseInt(parts[1]);
                            System.out.println("SEARCH " + sVal + ": " + bst.search(sVal));
                            break;

                        case "KTH_SMALLEST":
                            int k = Integer.parseInt(parts[1]);
                            int result = bst.find_the_kth_smallest(k);
                            if (result != -1) {
                                System.out.println("KTH_SMALLEST: " + result + " (k = " + k + ")");
                            }
                            break;

                        default:
                            System.out.println("Input not valid");
                    }
                } catch (Exception e) {
                    System.out.println("Input not valid");
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + filename);
        }
    }
}