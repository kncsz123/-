package Work;

public class Test {

	public static void main(String[] args){
		System.out.println(calc(10));
    }
    public static double calc(int n){
        double value = 0.0;
        for(int i=1;i < n;i++){
            value += 1.0/i;
        }
        return value;
    }
}
