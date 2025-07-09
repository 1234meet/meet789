/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package permitvalidato;

/**
 *
 * @author patel
 */
class PermitValidator {
    public static boolean isValidPermitNumber(String permitNumber) {
        // Permit number format validation: starts with P followed by 4 digits (e.g., P1234)
        return permitNumber != null && permitNumber.matches("^P\\d{4}$");
    }
}
