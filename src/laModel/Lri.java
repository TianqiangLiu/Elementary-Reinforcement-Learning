package laModel;

import java.util.ArrayList;
import java.util.Random;

public class Lri implements la{
	final static double LAMBDA = 1000.0/6.0;
	Integer state;
	ArrayList<Double> arrayList;
	public Lri() {
		state = 1;
		arrayList = new ArrayList<Double>();
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(1.0-(LAMBDA*5));
	}
	@Override
	public Integer waitWhere() {
		Random random = new Random();
		double tem = random.nextDouble()*1000;
		if(tem<=arrayList.get(0)) {
			state = 1;
			return 1;
		}else if(tem<=arrayList.get(0)+arrayList.get(1)) {
			state = 2;
			return 2;
		}
		else if(tem<=arrayList.get(0)+arrayList.get(1)+arrayList.get(2)) {
			state = 3;
			return 3;
		}
		else if(tem<=arrayList.get(0)+arrayList.get(1)+arrayList.get(2)+arrayList.get(3)) {
			state = 4;
			return 4;
		}
		else if(tem<=arrayList.get(0)+arrayList.get(1)+arrayList.get(2)+arrayList.get(3)+arrayList.get(4)) {
			state = 5;
			return 5;
		}
		else{
			state = 6;
			return 6;
		}
	}

	@Override
	public void rewardSystem(int reward) {
		if(reward==0) {
			double sum = 1000.0;
			for (int i = 0; i < arrayList.size(); i++) {
				if(i!=state-1) {
					double tem = arrayList.get(i)*0.9;
					sum = sum - tem;
					arrayList.set(i, tem);
				}
			}
			arrayList.set(state-1, sum);
//			System.out.println(arrayList.get(state-1));
		}
		
	}
	@Override
	public void reNew() {
		state = 1;
		arrayList = new ArrayList<Double>();
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(LAMBDA+0);
		arrayList.add(1.0-(LAMBDA*5));
		
	}

}
