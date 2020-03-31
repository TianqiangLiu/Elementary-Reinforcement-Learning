import control.ElevatorControl;

public class Elevator {
	public static void main(String args[]) {
		ElevatorControl game = null;
		if(args.length>=1) {
			 game= new ElevatorControl(args);
		}else {
			System.exit(0);
		}
		
		game.start(args);
	}
}
