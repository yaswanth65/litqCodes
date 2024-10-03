// Subclass IP Address Java

import java.util.Scanner;
public class Main {
    public static String identifyClass(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            return "Wrong IP Address";
        }
        try {
            int abc = Integer.parseInt(parts[0]);
            int def = Integer.parseInt(parts[1]);
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return "Wrong IP Address";
                }
            }
            if (def >= 0 && def <= 63) {
                return "Class L";
            } else if (def >= 64 && def <= 127) {
                return "Class M";
            } else if (def >= 128 && def <= 191) {
                return "Class N";
            } else if (def >= 192 && def <= 255) {
                return "Class P";
            }
        } catch (NumberFormatException e) {
            return "Wrong IP Address";
        }
        return "Wrong IP Address";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        if (ipAddress.trim().isEmpty()) {
            System.out.println("Wrong IP Address");
        } else {
            String result = identifyClass(ipAddress);
            System.out.println(result);
        }
        scanner.close();
    }
}
