/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package permit;

/**
 *
 * @author patel
 */
public class Main {
        public static void main(String[] args) {
        // Create permits with enum values
        Permit buildingPermit = new Permit(PermitCategory.BUILDING);
        Permit customPermit = new Permit(PermitCategory.MEET_CATEGORY);

        // Print them
        System.out.println(buildingPermit);
        System.out.println(customPermit);
    }
}
