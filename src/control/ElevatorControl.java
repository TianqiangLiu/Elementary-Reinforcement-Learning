package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import laModel.Krinsky;
import laModel.Krylov;
import laModel.Lri;
import laModel.Tsetlin;
import laModel.la;

public class ElevatorControl {
	la laMode;
	Map<Integer, Integer> map;
	ArrayList<Double> arrayList;
	final static Integer EXPERIMENTS_INTEGER = 100;
	final static Integer STEPS_INTEGER = 1000;
	final static Integer TEST_INTEGER = 100;
	static Integer POSITION_INTEGER;

	public ElevatorControl(String args[]) {
		switch (args[1]) {
		case "Tsetlin":
			laMode = new Tsetlin();
			POSITION_INTEGER = 2;
			break;
		case "Krinsky":
			laMode = new Krinsky();
			POSITION_INTEGER = 2;
			break;
		case "Krylov":
			laMode = new Krylov();
			POSITION_INTEGER = 5;
			break;
		case "L":
			laMode = new Lri();
			POSITION_INTEGER = 2;
			break;

		}
		map = new HashMap<Integer, Integer>();
		map.put(1, 2);
		map.put(2, 3);
		map.put(3, 1);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		arrayList = new ArrayList<Double>();

	}

	public void start(String[] args) {
		Random r = new Random();
		double accureRateInteger = 0;
		double total = 0;
		double waitTime = 0.0;
		for (int i = 0; i < EXPERIMENTS_INTEGER; i++) {

			for (int j = 0; j < STEPS_INTEGER; j++) {
				int tem = laMode.waitWhere();
				int maptem = map.get(tem);
				double f1 = 0.8 * maptem + 0.4 * Math.ceil(maptem / 2.0)
						+ r.nextGaussian() * Double.parseDouble(args[0]);
				waitTime = waitTime+f1;
//				 System.out.println("The number "+tem+" is: "+f1);
				if (arrayList.size() < POSITION_INTEGER) {
					arrayList.add(f1);
					Collections.sort(arrayList);
				} else {
					int position = (int) (arrayList.size() / POSITION_INTEGER);
					// System.out.println("position" + arrayList.get(position));
					if (f1 <= arrayList.get(position)) {
						laMode.rewardSystem(0);
					} else {
						laMode.rewardSystem(1);
					}
					arrayList.add(f1);
					Collections.sort(arrayList);
				}

				if (j > STEPS_INTEGER - TEST_INTEGER) {
					total = accureRateInteger / (j - (STEPS_INTEGER - 1000) + 1);
					if (tem == 3)
						accureRateInteger++;
//					 System.out.println("The 3 numbers is : " + accureRateInteger +
//					 "\n The rate is : " + total);
				}

			}
			laMode.reNew();
		}
		System.out.println("The 3 numbers is : " + accureRateInteger + "\n The rate is : " + accureRateInteger / (EXPERIMENTS_INTEGER*TEST_INTEGER));
		System.out.println("The wait time average is " + (waitTime/((double)STEPS_INTEGER*(double)EXPERIMENTS_INTEGER)));

	}
}
