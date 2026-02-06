import java.util.Scanner;

/**
 * FactoryRobotHazardAnalyzer - UC6
 *
 * Uses a custom exception to handle invalid robot hazard inputs.
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = scanner.nextDouble();

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // consume newline

            System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
            String machineryState = scanner.nextLine();

            double hazardRisk = calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Validates inputs and calculates hazard risk score.
     *
     * @param armPrecision arm precision value
     * @param workerDensity number of workers
     * @param machineryState machinery condition
     * @return hazard risk score
     * @throws RobotSafetyException if validation fails
     */
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState) throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20");
        }

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state");
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}