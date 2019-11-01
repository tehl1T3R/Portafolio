/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

public class Compilador {
    int et=0,var=0,mnem=0,val=0,org=0;
    String variables[]=new String[10000];
    String valorEt[]=new String[10000];
    String valores[]=new String[10000];
    String etiquetas[]=new String[10000];
    String mem="",memA="";
    String opcode="";
    int b;
    int bytes[][]={
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,3,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,0,2},
	{0,0,3,3,4,0,0,0},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,4,4,5,0,0,0},
	{0,0,0,0,0,0,0,2},
	{0,0,4,4,5,0,0,0},
	{0,0,3,3,4,0,0,0},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,0,2},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,4,3,3,3,4,0,0},
	{0,3,2,2,3,3,0,0},
	{0,4,3,3,3,4,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
	{0,0,0,2,3,3,0,0},
	{0,0,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,3,2,2,3,3,0,0},
	{0,3,2,2,3,3,0,0},
	{0,3,2,2,3,3,0,0},
	{0,4,3,3,3,4,0,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,2,2,3,3,0,0},
	{0,0,2,2,3,3,0,0},
	{0,0,2,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,2,2,3,3,0,0},
	{0,0,2,2,3,3,0,0},
	{0,0,3,3,3,4,0,0},
	{0,2,2,2,3,3,0,0},
	{0,2,2,2,3,3,0,0},
	{0,3,2,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,2,3,3,0,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,1,0},
	{0,0,0,0,0,0,2,0},
    };
    String reservadas[]={"EQU","ORG","FCB","END"};    
    String mnemonicos[][]={
        {"aba","0","0","0","0","0","1B","0"},
        {"abx","0","0","0","0","0","3A","0"},
        {"aby","0","0","0","0","0","18 3A","0"},
        {"adca","89","99","A9","18 A9","B9","0","0"},
        {"adcb","C9","D9","E9","18 E9","F9","0","0"},
        {"adda","8B","9B","AB","18 AB","BB","0","0"},
        {"addb","CB","DB","EB","18 EB","FB","0","0"},
        {"addd","C3","D3","E3","18 E3","F3","0","0"},
        {"anda","84","94","A4","18 A4","B4","0","0"},
        {"andb","C4","D4","E4","18 E4","F4","0","0"},
        {"asl","0","0","68","18 68","78","0","0"},
        {"asla","0","0","0","0","0","48","0"},
        {"aslb","0","0","0","0","0","58","0"},
        {"asld","0","0","0","0","0","5","0"},
        {"asr","0","0","67","18 67","77","0","0"},
        {"asra","0","0","0","0","0","47","0" },
        {"asrb","0","0","0","0","0","57","0" },
        {"bcc","0","0","0","0","0","0","24" },
        {"bclr","0","15","1D","18 1D","0","0"},
        {"bcs","0","0","0","0","0","0","25"},
        {"beq","0","0","0","0","0","0","27" },
        {"bge","0","0","0","0","0","0","2C"} ,
        {"bgt","0","0","0","0","0","0","2E"} ,
        {"bhi","0","0","0","0","0","0","22" },
        {"bhs","0","0","0","0","0","0","24" },
        {"bita","85","95","A5","18 A5","B5","0","0" },
        {"bitb","C5","D5","E5","18 E5","F5","0","0" },
        {"ble","0","0","0","0","0","0","2F"},
        {"bio","0","0","0","0","0","0","25"},
        {"bis","0","0","0","0","0","0","23"},
        {"bit","0","0","0","0","0","0","2D"},
        {"bml","0","0","0","0","0","0","2B"},
        {"bne","0","0","0","0","0","0","26"},
        {"bpl","0","0","0","0","0","0","2A"},
        {"bra","0","0","0","0","0","0","20"},
        {"brclr","0","13","1F","18 1F","0","0","0"},
        {"brn","0","0","0","0","0","0","21"},
        {"brset","0","12","1E","18 1E","0","0","0" },
        {"bset","0","14","1C","18 1C","0","0","0" },
        {"bsr","0","0","0","0","0","0","8D"},
        {"bvc","0","0","0","0","0","0","28"},
        {"bvs","0","0","0","0","0","0","29"},
        {"cba","0","0","0","0","0","11","0"},
        {"clc","0","0","0","0","0","0C","0" },
        {"cli","0","0","0","0","0","0E","0" },
        {"clr","0","0","6F","18 6F","7F","0","0" },
        {"clra","0","0","0","0","0","4F","0" },
        {"clrb","0","0","0","0","0","5F","0" },
        {"clv","0","0","0","0","0","0A","0" },
        {"cmpa","81","91","A1","18 A1","B1","0","0" },
        {"cmpb","C1","D1","E1","18 E1","F1","0","0" },
        {"com","0","0","63","18 63","73","0","0" },
        {"coma","0","0","0","0","0","43","0" },
        {"comb","0","0","0","0","0","53","0" },
        {"cpd","1A 83","1A 93","1A A3","CD A3","1A B3","0","0" },
        {"cpx","8C","9C","AC","CD AC","BC","0","0" },
        {"cpy","18 8C","18 9C","1A AC","18 AC","18 BC","0","0" },
        {"daa","0","0","0","0","0","19","0" },
        {"dec","0","0","6A","18 6A","7A","0","0" },
        {"deca","0","0","0","0","0","4A","0" },
        {"decb","0","0","0","0","0","5A","0" },
        {"des","0","0","0","0","0","34","0" },
        {"dex","0","0","0","0","0","0 9","0" },
        {"dey","0","0","0","0","0","18 9","0" },
        {"eora","88","98","A8","18 A8","B8","0","0" },
        {"eorb","C8","D8","E8","18 E8","F8","0","0" },
        {"fdiv","0","0","0","0","0","0 3","0" },
        {"idiv","0","0","0","0","0","0 2","0" },
        {"inc","0","0","6C","18 6C","7C","0","0"} ,
        {"inca","0","0","0","0","0","4C","0" },
        {"incb","0","0","0","0","0","5C","0" },
        {"ins","0","0","0","0","0","31","0" },
        {"inx","0","0","0","0","0","0 8","0"} ,
        {"iny","0","0","0","0","0","18 08","0"} ,
        {"jmp","0","0","0","0","7E","0","0" },
        {"jsr","0","9D","AD","18 AD","BD","0","0"} ,
        {"ldaa","86","96","A6","18 A6","B6","0","0"} ,
        {"ldab","C6","D6","E6","18 E6","F6","0","0"} ,
        {"ldd","CC","DC","EC","18 EC","FC","0","0" },
        {"lds","8E","9E","AE","18 AE","BE","0","0" },
        {"ldx","CE","DE","EE","CD EE","FE","0","0" },
        {"ldy","18 CE","18 DE","1A EE","18 EE","18 FE","0","0" },
        {"lsl","0","0","68","18 68","78","0","0" },
        {"lsla","0","0","0","0","0","48","0" },
        {"lslb","0","0","0","0","0","58","0" },
        {"lsld","0","0","0","0","0","0 5","0"} ,
        {"lsr","0","0","64","18 64","74","0","0"} ,
        {"lsra","0","0","0","0","0","44","0" },
        {"lsrb","0","0","0","0","0","54","0" },
        {"lsrd","0","0","0","0","0","0","4","0"} ,
        {"mul","0","0","0","0","0","3D","0" },
        {"neg","0","0","60","18 60","70","0","0"} ,
        {"nega","0","0","0","0","0","40","0" },
        {"negb","0","0","0","0","0","50","0" },
        {"nop","0","0","0","0","0","0 1","0" },
        {"oraa","8A","9A","AA","18 AA","BA","0","0" },
        {"orab","CA","DA","EA","18 EA","FA","0","0" },
        {"psha","0","0","0","0","0","36","0" },
        {"pshb","0","0","0","0","0","37","0" },
        {"pshx","0","0","0","0","0","3C","0" },
        {"pshy","0","0","0","0","0","18 3C","0"} ,
        {"pula","0","0","0","0","0","32","0" },
        {"pulb","0","0","0","0","0","33","0" },
        {"pulx","0","0","0","0","0","38","0" },
        {"puly","0","0","0","0","0","18 38","0" },
        {"rol","0","0","69","18 69","79","0","0" },
        {"rola","0","0","0","0","0","49","0" },
        {"rolb","0","0","0","0","0","59","0" },
        {"ror","0","0","66","18 66","76","0","0"} ,
        {"rora","0","0","0","0","0","46","0" },
        {"rorb","0","0","0","0","0","56","0" },
        {"rti","0","0","0","0","0","3B","0" },
        {"rts","0","0","0","0","0","39","0" },
        {"sba","0","0","0","0","0","10","0" },
        {"sbca","82","92","A2","18 A2","B2","0","0" },
        {"sbcb","C2","D2","E2","18 E2","F2","0","0" },
        {"sec","0","0","0","0","0","0D","0" },
        {"sei","0","0","0","0","0","0F","0" },
        {"sev","0","0","0","0","0","0B","0" },
        {"staa","0","97","A7","18 A7","B7","0","0" },
        {"stab","0","C7","D7","18 E7","F7","0","0" },
        {"std","0","DD","ED","18 ED","FD","0","0" },
        {"stop","0","0","0","0","0","CF","0" },
        {"sts","0","9F","AF","18 AF","BF","0","0" },
        {"stx","0","DF","EF","CD EF","FF","0","0" },
        {"sty","0","18 DF","1A EF","18 EF","FF","0","0" },
        {"suba","80","90","A0","18 A0","B0","0","0" },
        {"subb","C0","D0","E0","18 E0","F0","0","0" },
        {"subd","83","93","A3","18 A3","B3","0","0" },
        {"swi","0","0","0","0","0","3F","0" },
        {"tab","0","0","0","0","0","16","0" },
        {"tap","0","0","0","0","0","0 6","0"} ,
        {"tba","0","0","0","0","0","17","0" },
        {"tets","0","0","0","0","0","0","0","0" },
        {"tpa","0","0","0","0","0","0 7","0" },
        {"tst","0","0","6D","18 6D","7D","0","0"},
        {"tsta","0","0","0","0","0","4D","0"},
        {"tstb","0","0","0","0","0","5D","0"},
        {"tsx","0","0","0","0","0","30","0"},
        {"tsy","0","0","0","0","0","18 30","0"},
        {"txs","0","0","0","0","0","35","0"},
        {"tys","0","0","0","0","0","18 35","0"},
        {"wai","0","0","0","0","0","3E","0"},
        {"xgdx","0","0","0","0","0","8F","0"},
        {"xgdy","0","0","0","0","0","18 8F","0"}
    };
    String inher[]={
            "aba","abx","aby","asla","aslb","asld","cba","clc","cli","clra",
            "clrb","clv","coma","comb","daa","deca","decb","des","dex","dey",
            "fdiv","idiv","inca","incb","ins","inx","iny","lsla","lslb","lsld",
            "lsra","lsrb","lsrd","mul","nega","negb","nop","psha","pshb","pshx",
            "pshy","pula","pulb","pulx","puly","rola","rolb","rora","rorb","rti",
            "rts","sba","sec","sei","sev","stop","swi","tab","tap","tba","tets",
            "tpa","tsta","tstb","tsx","tsy","txs","tys","wai","xgdx","xgdy"
        };
    String relativo[]={
            "BCC","BCS","BEQ","BGE","BGT","BHI","BHS","BLE","BIO","BLS","BLT","BMI","BNE","BPL","BRA","BRN","BSR","BVS"
    };
    boolean rel(String linea){
        for (int i = 0; i <= 19; i++) {
            if(linea.compareToIgnoreCase(relativo[i])==0)                
                return true;
        }
        return false;
    }
    boolean inh(String linea){
        for (int i = 0; i <= 69; i++) {
            if(linea.compareToIgnoreCase(inher[i])==0)                
                return true;
        }
        return false;
    }
    boolean imm(String linea){
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)=='#')
                return true;
        }
        
        return false;
    }
    
    boolean indX(String linea){
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)==','&&linea.charAt(i)=='x'||linea.charAt(i)=='X')
                return true;
        }
        return false;
    }
    boolean indY(String linea){
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)==','&&linea.charAt(i)=='y'||linea.charAt(i)=='Y')
                return true;
        }
        return false;
    }
    boolean ext(String linea){
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)=='$'){
                linea=linea.replace("$","");
            }
        }
        int x=Integer.parseInt(linea,16);
        if(x>256||x<65536){
            return true;
        }
        return false;
    }
    boolean directo(String linea){
        System.out.println(linea);
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)=='$'){
               linea=linea.replace("$","");
               //linea=linea.substring(1,linea.length());
            }
        }
        System.out.println(linea);
        int x=Integer.parseInt(linea,16);
        System.out.println(linea);
        if(x<256){
            return true;
        }
        return false;
    }
    void creaVariables(String linea){
        
        int cont=0,esp2=0,esp1=0;
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)==' '){
                cont++;                
                if(cont==1){
                    esp1=i;
                } 
                if(cont ==2){
                    esp2=i;
                }
            }
        }
        if(cont==2&&(linea.substring(0, esp1).compareToIgnoreCase("BRCLR")!=0&&(linea.substring(0, esp1).compareToIgnoreCase("reset")!=0))){
            variables[var]=linea.substring(0, esp1);            
            valorEt[var]=linea.substring(esp2, linea.length());
            var++;
        }
    }
    void creaEtiquetas(String linea){
        int cont=0;
        int ln=0;
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)==' '&&linea.charAt(0)!='*'){
                cont++;                
            }else {
                if(linea.charAt(i)=='\n'){
                    ln=i;
                }
            }
        }
        for (int i = 0; i <=69; i++) {
            if (cont==0&&linea.compareTo("\n")!=0&&linea.compareTo("")!=0){                
                if(linea.compareToIgnoreCase(inher[i])!=0){
                etiquetas[et]=linea;
                et++;
                break;
            }   }
        }
        
    }
    boolean sintaxis(String linea){
        creaVariables(linea);
        creaEtiquetas(linea);
        int cont=0,esp1=0,esp2=0, found=0;
        if(linea.compareTo("\n")!=0&&linea.compareTo("")!=0){
            for (int i = 0; i < linea.length(); i++) {
                if(linea.charAt(i)==' '){
                    cont++;                
                    if(cont==1){
                        esp1=i;
                    } 
                    if(cont==2){
                        esp2=i;
                    }
                }
            }
            if(cont==2){
                for (int i = 0; i < var; i++) {
                    if(variables[i].compareToIgnoreCase(linea.substring(0, esp1))==0||linea.substring(0, esp1).compareTo("BRCLR")==0||linea.substring(0, esp1).compareTo("RESET")==0||linea.substring(esp1, esp2).compareToIgnoreCase("EQU")!=0){
                        found++;
                    }
                }
            }
            if(cont==1){
                for (int i = 0; i < mnemonicos.length; i++) {
                    for (int j = 0; j < reservadas.length; j++) {
                        if(mnemonicos[i][0].compareToIgnoreCase(linea.substring(0, esp1))==0||reservadas[j].compareToIgnoreCase(linea.substring(0, esp1))==0){
                            
                            found++;
                            break;
                        }    
                    }
                }
                
            }
            if (cont==0){
                for (int i = 0; i < 68; i++) {
                    for (int j = 0; j < et; j++) {
                        if(inher[i].compareToIgnoreCase(linea)==0||etiquetas[j].compareToIgnoreCase(linea)==0){
                            found++;
                            break;
                            
                        }    
                    }                    
                }
            }
        }else{
            found=1;
        }
        
        if(found==0){
            return true;
        }
        return false;
    }
    int mDir(String valor){
        
        int i=1;
        while (i <=7) { 
            switch(i){
                case 1:   
                    if(imm(valor)){
                        return 1;
                    }
                break;
                case 2:   
                    if(directo(valor)){
                        return 2;
                    }
                break;
                case 3:   
                    if(indX(valor)){
                        return 3;
                    }
                break;
                case 4:   
                    if(indY(valor)){
                        return 4;
                    }
                break;
                case 5:   
                    if(ext(valor)){
                        return 5;
                    }
                break;
                case 6:   
                    if(inh(valor)){
                        return 6;
                    }
                break;
                case 7:   
                    if(rel(valor)){
                        return 7;
                    }
                break;
                
                
            }
            i++;
        }
        
        return 0;
    }
    String direcOpc(String a){       
    String mnem="",vari="",vacio="";
        int cont=0,esp1=0,dir=0;
        if(a.compareToIgnoreCase("")==0)
        	return vacio;
        for(int i=0;i<et;i++){
        	if(a.compareToIgnoreCase(etiquetas[i])==0){
        		return vacio;
        	}
        }
        for(int i=0;i<a.length();i++){
        	if(a.charAt(i)==' ')
        		cont++;
        	if(cont==2)
        		return vacio;
        }
        if(cont==0){
            for (int i = 0; i < 145; i++) {
                if(a.compareToIgnoreCase(mnemonicos[i][0])==0){
                    opcode=mnemonicos[i][6];
                }
            }
        }
            
        cont=0;
		do{
            if(a.charAt(cont)==' '){
                mnem = a.substring(0,cont);
                vari = a.substring(cont+1,a.length());
            }
            cont++;
        }while(a.charAt(cont-1)!=' ');
        
        for(int i=0;i<var;i++){
            if(vari.compareTo(variables[i])==0){
                vari=valorEt[i];
            }
        }
        System.out.println("vari es "+vari);
        System.out.println("entrando a mdir");
        dir=mDir(vari);          
        if(vari.charAt(0)=='#'){
           vari=(vari.substring(1,vari.length()));
        }
        if(vari.charAt(0)=='$'){
           vari=(vari.substring(1,vari.length()));
           for(int i=0;i<vari.length();i++){
                if(vari.charAt(i)==','){
                    vari=(vari.substring(0,i));
                }
            }
        }
        else{
            int x=Integer.parseInt(vari);
            String cadena=Integer.toHexString(x);
            vari=cadena;
        }
        String opc, met="";
		for(int i=0;i<145;i++){
			if(mnem.compareToIgnoreCase(mnemonicos[i][0])==0){
				met=mnemonicos[i][dir];
			}
		}
		opc=met.concat(vari);
                System.out.println("opcode "+opc);
		return opc;
	
    }
    String memoria(int b){
        int memo;
        if(b!=-1){
            memo=Integer.parseInt(mem);
            memo+=(b);
            mem = Integer.toHexString(memo);
            return mem;
        }
        return "";
    }
    void compilador(String linea){
        int dir=0,cont=0,esp1=0,esp2=0;
        String valor="";
        
        for (int i = 0; i < linea.length(); i++) {
            if(linea.charAt(i)==' '){
                cont++;
                if(cont==1){
                    esp1=i;
                }
                if(cont==2){
                    esp2=i;
                }
            }
        }
        if(cont==1){
            if(linea.substring(0, esp1).compareToIgnoreCase("ORG")==0){
                mem=linea.substring(esp1+1, linea.length()); 
                org++;
            }
            if(linea.substring(0, esp1).compareToIgnoreCase("END")==0){
                mem="";
            }
        }
        
        
        opcode=direcOpc(linea);
        
    }
}
