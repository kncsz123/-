package exp5.stickman.entity; 

import exp5.stickman.exception.StickInitializationException;

public class Stick {
	private Joint firstJoint, secondJoint;
	
	public Stick(Joint joint1, Joint joint2) {
		if(joint1 != joint2) {
			firstJoint = joint1;
			secondJoint = joint2;
		}else {
			throw new StickInitializationException("两个关节相同");
		}	
	}
	
	// 判断当前枝干是否包含关节点
	public boolean contain(Joint joint) {
		return (firstJoint == joint) || (secondJoint == joint); 
	}
	
	// 返回枝干中目标关节点的邻居
	public Joint neighbour(Joint joint) {
		Joint n = null;
		if(contain(joint)) {
			n = firstJoint == joint ? secondJoint : firstJoint;
		}
		return n;
	}
	
	// 同时包含两个不同关节点
	public boolean equals(Stick stick) {
		return this.contain(stick.firstJoint) && this.contain(stick.secondJoint);
	}
	
	// 返回枝干坐标x1,y2,x2,y2
	public double[] coordinates() {
		return new double[] {firstJoint.getX(),firstJoint.getY(),secondJoint.getX(),secondJoint.getY()};
	}

	public Joint getFirstJoint() {
		return this.firstJoint;
	}
	
	public Joint getSecondJoint() {
		return this.secondJoint;
	}
	
}
