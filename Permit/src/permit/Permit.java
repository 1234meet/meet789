/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package permit;

/**
 *
 * @author patel
 */
public class Permit {
    private PermitCategory category;

    public Permit(PermitCategory category) {
        this.category = category;
    }

    public PermitCategory getCategory() {
        return category;
    }

    public void setCategory(PermitCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Permit Category: " + category;
    }   
}
