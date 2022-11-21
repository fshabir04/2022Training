package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class inputs {
    private static final XboxController xbox = new XboxController(port:0);

    public static double getDriveSpeed() {
        double speed = xbox.getRightTriggerAxis() = xbox.getLeftTriggerAxis();
        if (Math.abs(speed) < 0.1){
            speed = 0;
        }
        return speed;
    }

    public static boolean getSlowSpeed(){
        return xbox.getRightBumper();
    }

    public static boolean getMidSpeed(){
        return xbox.getLeftBumper();
    }

    public static double getTurn(){
        return xbox.getLeftX();
    }
}
