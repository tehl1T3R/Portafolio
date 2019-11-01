package pasaporte;
public class Pasaporte {
    public static void main(String[] args) {
         colaPersonas c1= new colaPersonas();
         colaPersonas c2= new colaPersonas();
         colaPersonas c3= new colaPersonas();

         productores h1 = new productores("Productor 1: ",c1);
         productores h2 = new productores("Productor 2: ",c1);
         productores h3 = new productores("Productor 3: ",c1);
         comprobante h4 = new comprobante("Comprobante: ",c1,c2);
         registro h5 = new registro("Registro 1: ",c2,c3);
         registro h6 = new registro("Registro 2: ",c2,c3);
         Fotografia h7 = new Fotografia("Fotografia: ",c3);
         
         h1.start();
         h2.start();
         h3.start();
         h4.start();
         h5.start();
         h6.start();
         h7.start();
         
    }
    
}
