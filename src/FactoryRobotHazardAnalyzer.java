import java.util.Scanner;

/**
 * FactoryRobotHazardAnalyzer - UC4
 *
 * Validates robot hazard inputs using conditional logic.
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = scanner.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // consume newline

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = scanner.nextLine();

        // Validation
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
        } else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
        } else if (!machineryState.equals("Worn")
                && !machineryState.equals("Faulty")
                && !machineryState.equals("Critical")) {
            System.out.println("Error: Unsupported machinery state");
        } else {

            double machineRiskFactor = 0.0;

            if (machineryState.equals("Worn")) {
                machineRiskFactor = 1.3;
            } else if (machineryState.equals("Faulty")) {
                machineRiskFactor = 2.0;
            } else if (machineryState.equals("Critical")) {
                machineRiskFactor = 3.0;
            }

            double hazardRisk =
                    ((1.0 - armPrecision) * 15.0) +
                            (workerDensity * machineRiskFactor);

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);
        }
    }
}