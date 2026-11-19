package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// This code tells the car how to drive
public class ArcadeDrive {
    private DcMotor rightDrive, leftDrive;

    public void init(HardwareMap hwMap) {
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void drive(double forward, double rotate) {
        double rightPower = forward - rotate;
        double leftPower = forward + rotate;

        double maxPower = 1;
        double maxSpeed = 1;

        maxPower = Math.max(maxPower, Math.abs(leftPower));
        maxPower = Math.max(maxPower, Math.abs(rightPower));

        leftDrive.setPower(leftPower / maxPower * maxSpeed);
        rightDrive.setPower(rightPower / maxPower * maxSpeed);
    }

    public void stop() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
