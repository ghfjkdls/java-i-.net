package projekt;

public class Compute extends Thread{
	private int begin=0, end=0;
	public static double a1, a2, a3;
	public static double[][] array = new double[8][2]; 
	
	public Compute(double aa1, double aa2, double aa3) {
		a1=aa1;
		a2=aa2;
		a3=aa3;
	}
	
	public Compute(int beginC, int endC) {
	      this.begin = beginC;
	      this.end = endC;
	   }
	
	public double[][] resolve(){
        System.out.println("test klasy "+array.length+" "+a1+" "+a2+" "+a3);
        for(int i=0; i<array.length; i++) {
        	array[i][0] = i;
        	array[i][1] =0;
        }
        Compute thread1 = new Compute(0, 1);
        thread1.setName("one");
        Compute thread2 = new Compute(2, 3);
        thread2.setName("two");
        Compute thread3 = new Compute(4, 5);
        thread3.setName("three");
        Compute thread4 = new Compute(6, 7);
        thread4.setName("four");
        thread1.start(); thread2.start(); thread3.start(); thread4.start();
        while(thread1.isAlive() || thread2.isAlive()
        		|| thread3.isAlive() || thread4.isAlive()) {
            //serwer czeka az skoncza sie watki
          }
        //for(int i=0; i<array.length; i++) {
           //      System.out.println("koniec: "+array[i][0]+" "+array[i][1]);
           //  }
		
		return array;
	}
	
	public void run() {
        System.out.println("test watku "+begin+" "+end);
        for(int i=begin; i<=end; i++) {
        	array[i][1] = a1*i*i + a2*i + a3;
            System.out.println("test obliczen "+i+" "+array[i][0]+" "+array[i][1]);
        }
        
	}
}
