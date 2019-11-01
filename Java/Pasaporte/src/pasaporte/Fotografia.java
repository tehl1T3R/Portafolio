package pasaporte;

public class Fotografia extends Thread{
    private colaPersonas foto;
    
    public Fotografia(String name,colaPersonas c){
        foto=c;
        setName(name);
    }
    
    public void run(){
        while(true){
            if(foto.IsEmpty()==true){
                try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){}
            }
            else if(foto.IsEmpty()==false){
                String nom;
                nom= foto.GetNodo();
                System.out.println("El tramite de "+ nom +" termino, y se retira con su pasaporte");
                foto.deleteFromHead();
            }
            try{
                sleep((int)(Math.random()*100));
            }catch (InterruptedException e){} 
    }
    }
}