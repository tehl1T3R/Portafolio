package pasaporte;

public class Nodo {
	private String info;
	private Nodo next;
        
	public Nodo(String num){
            info=num;
            next=null;       
	}
	public Nodo(String num, Nodo n){
            info=num;
            next=n;
        }
        public String Getinfo(){
            return info;
        }
        public void Setinfo(String newd){
            info=newd;
        }
        public Nodo Getnext(){
            return next;
        }
        public void SetNext(Nodo nex){
            this.next=nex;
        }
        
}
