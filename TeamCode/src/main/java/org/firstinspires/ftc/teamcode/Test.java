package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.ArcadeDrive;

@Autonomous
public class Test extends OpMode {
    ElapsedTime time = new ElapsedTime();
    ArcadeDrive drive = new ArcadeDrive();
    boolean startCounting = true;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        while (startCounting) {
            time.reset();
            startCounting = false;
        }

        drive.test(time);

    }
}
