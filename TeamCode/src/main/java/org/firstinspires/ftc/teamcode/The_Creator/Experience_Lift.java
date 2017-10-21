package org.firstinspires.ftc.teamcode.The_Creator;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Exp_Lift",group = "The Creator")
public class Experience_Lift extends LinearOpMode {

    private Hardware_Map robot = new Hardware_Map();

    private Gamepad driver = gamepad1;
    private Gamepad operator = gamepad2;

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();

        double PowerMax, MotorMaxPower = 1.00;
        double PowerLeft, PowerRight;

        while (opModeIsActive()) {
            robot.Claw_L.setPosition(operator.left_trigger);
            robot.Claw_R.setPosition(1.00 - operator.left_trigger);
            if (operator.a) {
                robot.Lift.setTargetPosition(3500);
                robot.Lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            } else if (operator.b) {
                robot.Lift.setTargetPosition(0);
                robot.Lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            PowerLeft = -driver.left_stick_y + driver.left_stick_x;
            PowerRight = -driver.left_stick_y - driver.left_stick_x;
            PowerMax = Math.max(Math.abs(PowerLeft), Math.abs(PowerRight));
            if (PowerMax > MotorMaxPower) {
                PowerLeft = MotorMaxPower;
                PowerRight = MotorMaxPower;
            }
            robot.Base_L.setPower(PowerLeft);
            robot.Base_R.setPower(PowerRight);
            telemetry.addLine("--------------");
            telemetry.addData("Left Claw", robot.Claw_L.getPosition());
            telemetry.addData("Right Claw", robot.Claw_R.getPosition());
            telemetry.addLine("--------------");
            telemetry.update();
        }
    }
}