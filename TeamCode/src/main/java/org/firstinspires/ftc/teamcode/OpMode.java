package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ArcadeDrive;

//This code tells the car how to interperet gamepad input

public class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
    ArcadeDrive drive = new ArcadeDrive();
    double forward, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        rotate = gamepad1.right_stick_x;

        drive.drive(forward, rotate);
    }
}
