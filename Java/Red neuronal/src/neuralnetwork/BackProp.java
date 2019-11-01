package neuralnetwork;

import java.io.IOException;
import java.util.Random;

public class BackProp {
    
    //Cambiar si se cambia la cantidad de muestras de dígitos
    private static final int NUM_MUESTRAS = 56;
    
    //Muestras de dígitos
    private int[][] p = new int[NUM_MUESTRAS][42];
    //Targets para cada dígito
    private int[][] t = new int[8][8];
    
    private double alpha = 0; //Tasa de aprendizaje
    private double maxError = 0.01; //Error máximo permitido
    private int maxIterations = 0; //Número máximo de iteraciones 100M default
    private boolean bIterate = false;
    
    //Salidas de cada capa
    private int[] a0 = new int[42]; //Capa de entrada
    private double[] a1 = new double[8]; //Capa oculta
    private double[] a2 = new double[8]; //Capa de salida
    
    private double[] e = new double[8]; //error
    private double[][] w1 = new double[8][42]; //neuronas x entradas
    private double[][] w2 = new double[8][8];
    private double[][] w2T = new double[8][8];
    private double[] b1 = new double[8];
    private double[] b2 = new double[8];
    private double[] n1 = new double[8];
    
    //Sensibilidades para la etapa de backpropagation
    private double[] s2 = new double[8];
    private double[] s1 = new double[8];
    
    private int k = 0; //Numero de iteración
    private int showData = 0; //Cada cuantas iteraciones mostrar datos
    private int tarCount = 0;
    private int tarPos = 0;
    
    //Instancia de clase que contiene las matrices para representar los dígitos
    Digitos digitos = new Digitos();
    
    //Instancia de clase para redondear digitos
    RoundDecimals round = new RoundDecimals();
    
    //Instancia de clase para generar números aleatorios en el rango de 0 a 1
    Random random;
    
    //Cadena para enviar resultados a interfaz grafica
    private String s = "";
    
    //Método público para establecer los valores de las variables
    public void setParams(double alpha, double maxError, int maxIterations, int showData) {
        this.alpha = alpha;
        this.maxError = maxError;
        this.maxIterations = maxIterations;
        this.showData = showData;
    }
    
    //Método público para obtener los resultados
    public void getResult() {
        initVars();
        iteration();
    }
    
    //Método público para ver los datos iniciales
    public void getInitVars() {
        initVars();
        printVars();
    }
    
    //Método público para detener la ejecución del algoritmo
    public void stopIterations(boolean bIterate) {
        this.bIterate = bIterate;
    }
    
    //Método para escribir los valores actuales de las variables
    private void printVars() {
        s = "";
        //p
        /*s += "p:\n";
        //System.out.println("p:");
        for (int i=0; i<p.length; i++) {
            for (int j=0; j<p[i].length; j++) {
                s += p[i][j] + " ";
                //System.out.print(p[i][j] + " ");
            }
            s += "\n";
            //System.out.println();
        }
        //t
        s += "t:\n";
        //System.out.println("t:");
        for (int i=0; i<t.length; i++) {
            for (int j=0; j<t[i].length; j++) {
                s += t[i][j] + " ";
                //System.out.print(t[i][j] + " ");
            }
            s += "\n";
            //System.out.println();
        }*/
        //w1
        s += "w1:\n";
        //System.out.println("w1:");
        for (int i=0; i<w1.length; i++) {
            for (int j=0; j<w1[i].length; j++) {
                s += round.getRounded(w1[i][j], 2) + " ";
                //System.out.print(round.getRounded(w1[i][j], 2) + " ");
            }
            s += "\n";
            //System.out.println();
        }
        //w2
        s += "w2:\n";
        //System.out.println("w2:");
        for (int i=0; i<w2.length; i++) {
            for (int j=0; j<w2[i].length; j++) {
                s += round.getRounded(w2[i][j], 2) + " ";
                //System.out.print(round.getRounded(w2[i][j], 2) + " ");
            }
            s += "\n";
            //System.out.println();
        }
        //b1
        s += "b1:\n";
        //System.out.println("b1:");
        for (int i=0; i<b1.length; i++) {
            s += round.getRounded(b1[i], 2) + " ";
            //System.out.print(round.getRounded(b1[i], 2) + " ");
        }
        s += "\n";
        //System.out.println();
        //b2
        s += "b2:\n";
        //System.out.println("b2:");
        for (int i=0; i<b2.length; i++) {
            s += round.getRounded(b2[i], 2) + " ";
            //System.out.print(round.getRounded(b2[i], 2) + " ");
        }
        s += "\n";
        //System.out.println();
        //a2
        s += "a2:\n";
        //System.out.println("a2:");
        for (int i=0; i<a1.length; i++) {
            s += round.getRounded(a2[i], 2) + " ";
            //System.out.print(round.getRounded(a2[i], 2) + " ");
        }
        s += "\n";
        //System.out.println();
        //t
        s += "t:\n";
        //System.out.println("a2:");
        for (int i=0; i<a1.length; i++) {
            s += t[tarPos][i] + " ";
            //System.out.print(t[tarPos][i] + " ");
        }
        s += "\n";
        //System.out.println();
        //e
        s += "e:\n";
        //System.out.println("e:");
        for (int i=0; i<e.length; i++) {
            s += round.getRounded(e[i], 2) + " ";
            //System.out.print(round.getRounded(e[i], 2) + " ");
        }
        s += "\n";
        //System.out.println();
        //System.out.println("\nIteracion: " + k);
        s += "Iteracion: " + k + "\n\n";
        NeuralNetworkUI.updateOutput(s);
    }
    
    //Método para inicializar los valores de w y b
    private void initVars() {
        random  = new Random();
        int count = 0;
        
        //Cargamos las matrices que representan a los digitos en forma de vector
        for (int i=0; i<8; i++) {
            for (int j=0; j<7; j++) {
                p[count] = digitos.getDigitVector(i+1, j);
                count++;
            }
            
        }
        //Cargamos los vectores de los target para cada valor
        t = digitos.getTargetList();
        
        //Inicializamos los pesos aleatoriamente con valores entre 0 y 1
        for (int i=0; i<w1.length; i++) {
            for (int j=0; j<w1[i].length; j++) {
                w1[i][j] = random.nextDouble();
                //w1[i][j] = random.nextInt(2) - 1;
                //w1[i][j] = ((double)(random.nextInt(80)) - 40) / 10;
            }
            for (int j=0; j<w2.length; j++) {
                w2[i][j] = random.nextDouble();
            }
        }
        
        //Inicializamos los bias aleatoriamente con valores entre 0 y 1
        for (int i=0; i<b1.length; i++) {
            b1[i] = random.nextDouble();
            b2[i] = random.nextDouble();
            //b1[i] = random.nextInt(2) - 1;
            //b1[i] = ((double)(random.nextInt(80)) - 40) / 10;
        }
        
        //inicializamos el resto de variables a utilizar con valores en cero
        /*for(int i=0; i<p.length; i++) {
            a1[i] = 0;
            e[i] = 0;
            n1[i] = 0;
        }*/
        
    }
    
    //Método que realiza las iteraciones del algorimo
    private void iteration() {
        bIterate = true;
        int posMuestra = 0;
        int tamMuestra = p.length;
        //int clasifCorrecta = 0;
        //int numIteracion = 0;
        int counter = 0;
        int minError = 0;
        k = 0;
        int iError = 0;
        double[][] mulTemp = new double[8][8];
        tarCount = 0;
        tarPos = 0;
        
        while (bIterate) {
            /*System.out.println("posMuestra=" + posMuestra);
            System.out.println("tarCount=" + tarCount);
            System.out.println("tarPos=" + tarPos);
            try {
                System.in.read();
            } catch (IOException ex) {
                
            }*/
            k++;
            counter++;
            if (counter == showData) { //1M iteraciones
                printVars();
                counter = 0;
            }
            
            /*
                Etapa de forward propagation
            */
            
            //Se elige un valor para a0
            a0 = p[posMuestra];
            //Calculamos a1 = f1(n1) donde n1 = (w1 * a0 + b1)
            //La función f1 es logsig = (1 / (1 + E^-n))
            //Se calcula n1
            for(int i=0; i<n1.length; i++) {
                n1[i] = 0; // inicializar en cero antes de utilizar
                for (int j=0; j<a0.length; j++) {
                    n1[i] += w1[i][j]*a0[j];
                }
                n1[i] += b1[i];
            }
            //Se calcula a1
            for(int i=0; i<a1.length; i++) {
                a1[i] = 1 / (1 + Math.pow(Math.E, -n1[i]));
            }
            
            //Calculamos a2 = f2(n2) donde n2 = (w2 * a1 + b2)
            //La función f2 es purelin = a2 = n2
            //Por lo que a2 = (w2 * a1 + b2)
            for(int i=0; i<a2.length; i++) {
                a2[i] = 0; // inicializar en cero antes de utilizar
                for (int j=0; j<a1.length; j++) {
                    a2[i] += w2[i][j]*a1[j];
                }
                a2[i] += b2[i];
            }
            
            //Como ya no hay más capas, se calcula el error
            //e = t - a2
            for (int i=0; i<e.length; i++) {
                e[i] = t[tarPos][i] - a2[i];
            }
            tarCount++;
            if (tarCount > 6) { //7 representaciones
                tarCount = 0;
                tarPos++;
                if (tarPos > 7) tarPos = 0; //8 digitos
            }
            
            //Verificamos si el error es igual o muy cercano a cero
            iError = 0;
            for (int i=0; i<e.length; i++) {
                if (e[i] <= maxError && e[i] >= -maxError)
                    iError++;
            }
            if (iError == e.length) {
                //Si el error es muy cercano a cero, se prueba con otro valor de la muestra
                minError++;
                //Si todos los errores ya son menores al valor establecido, se detiene la iteración
                if (minError == tamMuestra) {
                    bIterate = false;
                } else { //De lo contrario, se hace una nueva iteración con los valores de w y b actuales para un nuevo punto p
                    posMuestra++;
                    //Si llegamos al valor final de la muestra, comenzar con el primero
                    if (posMuestra >= tamMuestra) posMuestra = 0;
                }
            } else { //De lo contrario, se actualizan valores de peso y bias
                minError = 0;
                /*
                    Etapa de backward propagation
                */
                
                //Comenzamos con la capa de salida
                //s2 = -2 * diff(f2(n2)) * e
                //Donde diff(f2(n2)) = 1
                for (int i=0; i<s2.length; i++) {
                    s2[i] = -2 * e[0];
                }
                
                //s1 = diff(f1(n1)) * w2T * s2
                //Donde w2T es la transpuesta de w2
                //y diff(f1(n1)) = (1 - a1) * a1
                //Sacamos la transpuesta de w2
                for (int i=0; i<w2.length; i++) {
                    for (int j=0; j<w2[i].length; j++) {
                        w2T[j][i] = w2[i][j];
                    }
                }
                //Calculamos mulTemp = diff(f1(n1)) * w2T
                for (int i=0; i<s1.length; i++) {
                    for (int j=0; j<w2[i].length; j++) {
                        mulTemp[i][j] = ((1 - a1[i]) * a1[i]) * w2T[i][j];
                    }
                }
                
                //Calculamos s1 = mulTemp *s2
                for (int i=0; i<s1.length; i++) {
                    s1[i] = 0;
                    for (int j=0; j<w2[i].length; j++) {
                        s1[i] += mulTemp[i][j] * s2[j];
                    }
                }
                
                //Finalmente se actualizan los pesos y el bias
                //w2 = w2 - alpha * s2 * a1T
                //Donde a1T es la transpuesta de a1
                for (int i=0; i<w2.length; i++) {
                    for(int j=0; j<w2[i].length; j++) {
                        w2[i][j] = w2[i][j] - (alpha * s2[i] * a1[j]);
                    }
                }
                //b2 = b2 - alpha * s2
                for (int i=0; i<b2.length; i++) {
                    b2[i] = b2[i] - alpha * s2[i];
                }
                //w1 = w1 - alpha * s1 * a0T
                for (int i=0; i<w1.length; i++) {
                    for(int j=0; j<w1[i].length; j++) {
                        w1[i][j] = w1[i][j] - (alpha * s1[i] * a0[j]);
                    }
                }
                //b1 = b1 - alpha * s1
                for (int i=0; i<b2.length; i++) {
                    b1[i] = b1[i] - alpha * s1[i];
                }
                
                //Se realiza una nueva iteración con los valores de w y b actualizados para un nuevo punto p
                posMuestra++;
                //Si llegamos al valor final de la muestra, comenzar con el primero
                if (posMuestra >= tamMuestra) posMuestra = 0;
            }
            if (k >= maxIterations) bIterate = false;
        }
        //Mostrar valores finales de las variables
        printVars();
        
    }
    
}
