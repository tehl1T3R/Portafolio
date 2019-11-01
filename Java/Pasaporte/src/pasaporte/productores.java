package pasaporte;

public class productores extends Thread{
    private colaPersonas p;
    
    public productores(String name, colaPersonas p){
        this.p = p;
	setName(name);
    }
    public void run(){
        while (true){
            p.addToTail(getName());
            try{
		sleep((int)(Math.random()*100));
                } catch (InterruptedException e) {} 
        }
    }
}
