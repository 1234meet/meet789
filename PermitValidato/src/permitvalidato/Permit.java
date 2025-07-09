/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package permitvalidato;

/**
 *
 * @author patel
 */
public class Permit {
    private String permitNumber;
    private PermitCategory category;

    public Permit(String permitNumber, PermitCategory category) {
        this.permitNumber = permitNumber;
        this.category = category;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public PermitCategory getCategory() {
        return category;
    }

    public String toString() {
        return "Permit Created: " + permitNumber + " in Category: " + category;
    }
}
