/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;
public class RemueveEspacios {
    public String quitaEspacios(String texto) {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
        texto = "";
        while(tokens.hasMoreTokens()){
            texto += " "+tokens.nextToken();
        }
        texto = texto.toString();
        texto = texto.trim();
        return texto;
    }
    
    String deleteFromChar(String cadena){
        String cad="";
        int chara=0;
        for (int x=0; x < cadena.length(); x++) {
            if (cadena.charAt(x) == '*'){
                chara++;
                cad=cadena.substring(0, x);                
                break;
            }
        }
        if(chara==0){
            return cadena;
        }
        return cad;
    }
    
}
