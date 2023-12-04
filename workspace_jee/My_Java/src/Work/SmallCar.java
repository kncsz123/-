package Work;

public class SmallCar {
	private boolean braked;
	private int energy;
	private int speed;
	private int location;
	
	private Road road;
	
	private final static int MAX_ENERGY = 100;
	private final static int RADIST_TO_ENERGYTE = 2;
	private final static int ENERGY_TO_SPEED = 3;//比率
	private final static int SPEED_LOSS = 2;
	
	
	public boolean isRunning() {
		return !braked && (speed !=0 || energy != 0);
	}
	
	public int getLocation() {
    	return location;
    }
	
	public int setLocation(int location) {
		this.location = location;
		return location;
	}
	public void setRoad(Road r) {
		road = r;
	}
	//小车单次运行
	public void run() {
		if(isRunning()){
			setLocation(getLocation()+speed);//移动
			
			//释放后得到加速度
			if(energy != 0) {
				speed += ENERGY_TO_SPEED;
				energy--;
			}
			speed -= SPEED_LOSS;
			if(speed < 0) speed = 0;
			
			road.update(this);
		}
	}
	//蓄力
	//玩家后推小车，积蓄能量
	public void accumulate(int dist){
	    energy += RADIST_TO_ENERGYTE * dist;
	    if(energy > MAX_ENERGY) energy = MAX_ENERGY;
	}

	//小车制动与解除制动
	public void braked(){
	    this.braked = true;
	    this.speed = 0;
	}
	public void released(){
	    this.braked = false;
	}
}




