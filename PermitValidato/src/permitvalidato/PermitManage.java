/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package permitvalidato;

import java.util.Scanner;

/**
 *
 * @author patel
 */
public class PermitManage {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String permitNumber;
        boolean isValid;

        do {
            System.out.print("Enter Permit Number (Format: P1234): ");
            permitNumber = scanner.nextLine();
            isValid = PermitValidator.isValidPermitNumber(permitNumber);
            if (!isValid) {
                System.out.println("Invalid format. Please try again.");
            }
        } while (!isValid);

        System.out.println("Select Permit Category:");
        for (PermitCategory category : PermitCategory.values()) {
            System.out.println("- " + category);
        }

        System.out.print("Enter category: ");
        String categoryInput = scanner.nextLine().toUpperCase();

        try {
            PermitCategory selectedCategory = PermitCategory.valueOf(categoryInput);
            Permit newPermit = new Permit(permitNumber, selectedCategory);
            System.out.println(newPermit);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category selected.");
        }

        scanner.close();
    } 
}
