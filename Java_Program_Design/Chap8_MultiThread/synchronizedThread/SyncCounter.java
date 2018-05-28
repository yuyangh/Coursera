package Chap8_MultiThread.synchronizedThread;
class SyncCounter
{
	public static void main(String[] args){ 
		Num2 num = new Num2();
		Thread counter1 = new Counter2(num);
		Thread counter2 = new Counter2(num);
		for( int i=0; i<10; i++ ){
			num.testEquals();
			try{							           
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
		}
	}
}

class Num2
{
	private int x=0;
	private int y=0;
	/*
	use synchronized so that variable is locked during modification
	anytime only one thread is visiting this method
	 */
	synchronized void increase(){ 
		x++; 
		y++; 
	}
	synchronized boolean testEquals(){
		boolean ok = (x==y);
		System.out.println( x + "," + y +" : " + ok);
		return ok;
	}
}

class Counter2 extends Thread
{
	private Num2 num;
	Counter2( Num2 num ){
		this.num = num;
		this.setDaemon(true);
		this.setPriority(MIN_PRIORITY);
		this.start();
	}
	public void run(){
		while(true){
			num.increase();
		}
	}
}
