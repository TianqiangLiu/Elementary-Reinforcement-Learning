package laModel;


public class Tsetlin implements la{
	private Integer state;
	private Integer nInteger;
	public Tsetlin() {
		state = 1;
		nInteger=10;
	}
	public Integer waitWhere() {
		if(state<=nInteger) {
			return 1;
		}else if(state<=2*nInteger) {
			return 2;
		}
		else if(state<=3*nInteger) {
			return 3;
		}
		else if(state<=4*nInteger) {
			return 4;
		}
		else if(state<=5*nInteger) {
			return 5;
		}
		else if(state<=6*nInteger) {
			return 6;
		}
		return -1;

	}
	public void rewardSystem(int reward) {
		//System.out.println(state);
		if(reward == 0) {
			if(state!=1&&state!=nInteger+1&&state!=(2*nInteger)+1
				&&state!=(3*nInteger)+1&&state!=(4*nInteger)+1&&
				state!=(5*nInteger)+1) {
				
				state=state-1;
			}
		}else {
			if(state!=nInteger&&state!=(2*nInteger)
					&&state!=(3*nInteger)&&state!=(4*nInteger)&&
					state!=(5*nInteger)&&state!=(6*nInteger)) {
					
					state=state+1;
				}
			else if(state==nInteger) {
				state = 2*nInteger;
			}else if(state==2*nInteger) {
				state = 3*nInteger;
			}else if(state==3*nInteger) {
				state = 4*nInteger;
			}else if(state==4*nInteger) {
				state = 5*nInteger;
			}else if(state==5*nInteger) {
				state = 6*nInteger;
			}
			else if(state==6*nInteger) {
				state = nInteger;
			}
		}
	}
	@Override
	public void reNew() {
		state = 1;
		nInteger=10;
		
	}

}
