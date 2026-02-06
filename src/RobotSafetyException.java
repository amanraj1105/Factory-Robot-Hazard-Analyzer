/**
 * Custom exception to handle robot safety violations.
 */
public class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
    }
}