package pasaporte;

public class colaPersonas {
    
    private Nodo H;
    private Nodo T;
    private int Nproc;
    
    public colaPersonas(){
        H=T=null;
        Nproc=0;
    }
    public boolean IsEmpty() {
      if (H == null){
         System.out.println("\nLista vacia...");
         return true;
      }
      return false;
    }
    public synchronized void addToTail(String name){
        String info = "P" + (++Nproc);
        Nodo q = new Nodo(info, null);
        if (T == null){
            H=T=q;
            notifyAll();
        }
        else{
            T.SetNext(q);
            T=q;
        }
        System.out.println(name + "  : " + info);
        mostrarTodos();
   }
   public synchronized void sendToTail(){
        Nodo q = H;
        H=H.Getnext();
        T.SetNext(q);
        T=q;
   }
   public synchronized void Advance(colaPersonas sec){
       Nodo q = H;
       H=H.Getnext();
       sec.addToTail(q.Getinfo());
       notifyAll();
   }
   public synchronized String GetNodo(){
       Nodo q=H;
       return q.Getinfo();
   }
   public synchronized Nodo deleteFromHead(){
       Nodo q = H;
       try{
          if (IsEmpty())
          //return null;
          wait();
       } 
       catch (InterruptedException e){} 
       if (H==T)
           H=T=null;
       else
           H=H.Getnext();
       mostrarTodos();
       notifyAll();  
       return q;
   }
   public synchronized void mostrarTodos(){
      System.out.println("\n");
      Nodo q = H;
      if (!IsEmpty()) 
         while (q!=null)
         {
            System.out.print(q.Getinfo() + " ");
            q = q.Getnext() ;
         }
      System.out.println("\n");
   }
  
}
