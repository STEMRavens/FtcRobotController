package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

// This code tells the car how to drive
public class ArcadeDrive {
    private DcMotor rightDrive, leftDrive, intakeMotor, launchMotor;
    private CRServo intakeServo;
    public void init(HardwareMap hwMap) {
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        intakeMotor = hwMap.get(DcMotor.class, "intake_motor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setDirection(DcMotor.Direction.REVERSE);

        launchMotor = hwMap.get(DcMotor.class, "launch");
        launchMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        launchMotor.setDirection(DcMotor.Direction.REVERSE);

        intakeServo = hwMap.get(CRServo.class, "intake_servo");
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

    public void intake() {
        intakeMotor.setPower(-1);
        intakeServo.setPower(1);
    }

    public void stopIntake() {
        intakeMotor.setPower(0);
        intakeServo.setPower(0);
    }

    public void launch() {
        launchMotor.setPower(1);
    }

    public void stopLaunchWheel() {
        launchMotor.setPower(0);
    }

    public void test(ElapsedTime time) {
        intakeServo.setPower(1);
        if (time.seconds() >= 3 && time.seconds() < 5) {
            intakeServo.setPower(0);
            launchMotor.setPower(.5);
        } else if (time.seconds() >= 5 && time.seconds() < 7) {
            launchMotor.setPower(0);
            intakeMotor.setPower(.5);
        } else if (time.seconds() >= 7 && time.seconds() < 9) {
            intakeMotor.setPower(0);
            leftDrive.setPower(.5);
        } else if (time.seconds() >= 9 && time.seconds() < 11) {
            leftDrive.setPower(0);
            rightDrive.setPower(.5);
        } else if (time.seconds() >= 11) {
            rightDrive.setPower(0);
        }
    }
}
