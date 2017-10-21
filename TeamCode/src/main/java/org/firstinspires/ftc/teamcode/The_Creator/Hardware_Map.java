package org.firstinspires.ftc.teamcode.The_Creator;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware_Map {

    public DcMotor Base_L, Base_R, Lift;
    public Servo Claw_L, Claw_R;

    public void init(HardwareMap hardwareMap) {
        Base_L = hardwareMap.dcMotor.get("Left_drive");
        Base_R = hardwareMap.dcMotor.get("Right_drive");
        Lift = hardwareMap.dcMotor.get("Lift");
        Claw_L = hardwareMap.servo.get("Claw_left");
        Claw_R = hardwareMap.servo.get("Claw_Right");

        Claw_L.setPosition(0.00);
        Claw_R.setPosition(1.00);

        Base_R.setDirection(DcMotor.Direction.REVERSE);

        Lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Lift.setTargetPosition(0);
        Lift.setPower(0.5);
        Lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
