package pasaporte;

public class registro extends Thread{
    private colaPersonas regis;
    private colaPersonas foto;
    
    public registro(String name,colaPersonas c, colaPersonas d){
        regis=c;
        setName(name);
        foto=d;
    }
    public void run(){
        while(true){
            if(regis.IsEmpty()==true){
                try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){} 
            }
            else if(regis.IsEmpty()==false){
                String nom;
                nom= regis.GetNodo();
                System.out.println("El registro de "+ nom +" culmino exitosamente, avance a tomar su fotografía");
                regis.Advance(foto);
            }
            try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){} 
        }
    }
}
