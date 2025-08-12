/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package permit;

public class BursaryService {
    // Example policy: eligible if year >= 2 AND average >= 80
    public boolean getsBursary(int currentYear, double gradeAverage) {
        if (currentYear < 1) throw new IllegalArgumentException("currentYear");
        if (Double.isNaN(gradeAverage) || gradeAverage < 0 || gradeAverage > 100)
            throw new IllegalArgumentException("gradeAverage");
        return currentYear >= 2 && gradeAverage >= 80.0;
    }
}

