package pasaporte;

public class comprobante extends Thread{
    private colaPersonas procesos;
    private colaPersonas regis;
    
    public comprobante(String name,colaPersonas c, colaPersonas d){
        procesos=c;
        setName(name);
        regis=d;
    }
    public void run(){
        while(true){
             int i=(int)(Math.random()*5);
            String nom= procesos.GetNodo();
            if(i<2){
                System.out.println("Documentos erroneos de: "+ nom +" vuelva a formarse");
                procesos.sendToTail();
            }
            else{
                System.out.println(nom+" avance al registro");
                procesos.Advance(regis);
            }
            try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){} 
        }
    }
    
}
  
