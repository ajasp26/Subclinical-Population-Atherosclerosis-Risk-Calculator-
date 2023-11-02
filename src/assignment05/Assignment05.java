package assignment05;

import java.util.Scanner;

/**
 *
 * @author ajasp
 */
public class Assignment05 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter patient's age (between 20 and 39):");
        int age = scanner.nextInt();
        System.out.println("Enter patient's sex (male or female):");
        String sex = scanner.next().toLowerCase();

        System.out.println("Enter LDL (mg/dL):");
        int ldl = scanner.nextInt();
        System.out.println("Enter Triglycerides (mg/dL):");
        int triglycerides = scanner.nextInt();
        System.out.println("Enter Apolipoprotein B (mg/dL):");
        int apolipoprotein = scanner.nextInt();
        System.out.println("Enter HDL Cholesterol (mg/dL):");
        int hdl = scanner.nextInt();
        System.out.println("Enter Systolic Blood Pressure (mm Hg):");
        int systolic = scanner.nextInt();
        System.out.println("Enter Diastolic Blood Pressure (mm Hg):");
        int diastolic = scanner.nextInt();
        System.out.println("Enter Fasting Glucose (mg/dL):");
        int fastingGlucose = scanner.nextInt();
        System.out.println("Enter Coronary Artery Calcium Score:");
        int cac = scanner.nextInt();

        int riskPoints = 0;

        riskPoints += calculateLDLScore(ldl);
        riskPoints += calculateTriglyceridesScore(triglycerides);
        riskPoints += calculateApolipoproteinScore(apolipoprotein);
        riskPoints += calculateHDLScore(hdl);
        riskPoints += calculateBloodPressureScore(systolic, diastolic);
        riskPoints += calculateFastingGlucoseScore(fastingGlucose);
        riskPoints += calculateCACScore(cac);

        if (sex.equals("male")) {
            riskPoints++;
        }

        if (age >= 20 && age <= 24 && riskPoints > 0) {
            riskPoints++;
        } else if (age >= 25 && age <= 29 && riskPoints > 0) {
            riskPoints += 2;
        } else if ((age >= 30 && age <= 34) || (age >= 35 && age <= 39) && riskPoints > 0) {
            riskPoints += 3;
        }

        System.out.println("The total risk points: " + riskPoints);
    }

    private static int calculateLDLScore(int ldl) {
        if (ldl < 100) {
            return 0;
        } else if (ldl >= 100 && ldl <= 129) {
            return 1;
        } else if (ldl >= 130 && ldl <= 159) {
            return 2;
        } else if (ldl >= 160 && ldl <= 189) {
            return 3;
        } else {
            return 4;
        }
    }

    private static int calculateTriglyceridesScore(int triglycerides) {
        if (triglycerides < 150) {
            return 0;
        } else if (triglycerides >= 150 && triglycerides <= 200) {
            return 1;
        } else if (triglycerides >= 200 && triglycerides <= 299) {
            return 2;
        } else if (triglycerides >= 300 && triglycerides <= 499) {
            return 3;
        } else if (triglycerides >= 500 && triglycerides <= 999) {
            return 4;
        } else {
            return 6;
        }
    }
    private static int calculateApolipoproteinScore(int apolipoprotein) {
        if (apolipoprotein < 90) {
            return 0;
        } else if (apolipoprotein >= 90 && apolipoprotein <= 110) {
            return 1;
        } else if (apolipoprotein >= 110 && apolipoprotein <= 129) {
            return 2;
        } else if (apolipoprotein >= 130 && apolipoprotein <= 154) {
            return 3;
        } else {
            return 5;
        }
    }

    private static int calculateHDLScore(int hdl) {
        if (hdl < 40) {
            return 1;
        } else if (hdl >= 40 && hdl <= 59) {
            return 0;
        } else {
            return -1;
        }
    }

    private static int calculateBloodPressureScore(int systolic, int diastolic) {
        if (systolic <= 120 && diastolic <= 70) {
            return 0;
        } else if (systolic >= 121 && systolic <= 129 && diastolic > 70 && diastolic < 80) {
            return 1;
        } else {
            return 4;
        }
    }

    private static int calculateFastingGlucoseScore(int fastingGlucose) {
        if (fastingGlucose >= 80 && fastingGlucose <= 100) {
            return 0;
        } else if (fastingGlucose >= 101 && fastingGlucose <= 125) {
            return 2;
        } else {
            return 5;
        }
    }

    private static int calculateCACScore(int cac) {
        if (cac == 0) {
            return 0;
        } else if (cac >= 1 && cac <= 19) {
            return 2;
        } else if (cac >= 20 && cac <= 99) {
            return 4;
        } else {
            return 8;
        }
    }
}
    

