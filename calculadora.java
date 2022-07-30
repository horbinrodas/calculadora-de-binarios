import java.lang.Math;
import java.util.*;

public class calculadora {
    public static void main(String[] args) throws Exception {
        Scanner in= new Scanner(System.in); 
        int n;
        do{
            System.out.println("CALCULADORA DE BINARIOS\n");
            System.out.print("1.) BINARIO A DECIMAL \n");
            System.out.print("2.) DECIMAL A BINARIO \n");
            System.out.print("3.) SUMA \n");
            System.out.print("4.) RESTA\n");
            System.out.print("5.) SALIR\n");
            
            n = in.nextInt();
            int x;
            long a,b;
            switch(n){
                case 1:
                    System.out.println("Ingrese un numero binario: ");
                    a = in.nextLong();
                    binarioDecimal(a);
                    break;

                case 2:
                    System.out.println("Ingrese un numero decimal: ");
                    x = in.nextInt();
                    decimalBinario(x);
                    break;

                case 3:
                    System.out.println("1er numero binario: ");
                    a = in.nextLong();
                    System.out.println("2do numero binario: ");
                    b = in.nextLong();
                    sumadorBinario(a, b);
                    break;
                
                case 4:
                    System.out.println("1er numero binario: ");
                    a = in.nextLong();
                    System.out.println("2do numero binario: ");
                    b = in.nextLong();
                    restadorBinario(a, b);
                    break;
                
                case 5:
                    System.out.println("Saliendo de programa");
                    System.exit(0);
                    break;
            }
        }while(n!=5);
        in.close();
    }

    static void binarioDecimal(long binario){
        double temp; double i=0; int resultado = 0;
        while(binario>0){
            temp = binario%10;
            if(temp != 0 && temp != 1){
                System.out.println("Ingreso un numero no binario");
                break;
            }
            resultado += temp * Math.pow(2, i);
            binario/=10;
            i++;
        }
        System.out.println("Decimal: " + resultado+"\n");
    }
    
    static void decimalBinario(int decimal){
        ArrayList<Integer> r = new ArrayList<Integer>();
        while(decimal>0){
            r.add(decimal%2);
            decimal /= 2;
        }
        while(r.size()<4)
            r.add(0);
        System.out.println("Binario: ");
        for(int i=r.size()-1;i>=0;i--)
            System.out.print(r.get(i));
        System.out.println("\n");
    }

    static ArrayList<Long> array(long a){
        ArrayList<Long> ar = new ArrayList<Long>();
        while(a>0){
            ar.add(a%10);
            a/=10;
        }
        return ar;
    }

    static void sumadorBinario(long a, long b){
        ArrayList<Long> ar = new ArrayList<Long>();
        ArrayList<Long> br = new ArrayList<Long>();
        ArrayList<Long> r = new ArrayList<Long>();
        ar = array(a);
        br = array(b);
        while(ar.size()<br.size())
            ar.add((long)0);
        while(br.size()<ar.size())
            br.add((long)0);
        long acarreo=0;
        for(int i=0; i<ar.size(); i++){
            long temp;
            temp = ar.get(i)+br.get(i)+acarreo;
            if(temp == 0){
                r.add((long) 0);
                acarreo = 0;
            }
            if(temp == 1){
                r.add((long) 1);
                acarreo = 0;
            }
            if(temp == 2){
                r.add((long) 0);
                acarreo = 1;
            }
            if(temp == 3){
                r.add((long) 1);
                acarreo = 1;
            }
        }
        System.out.print("Resultado de suma = ");
        for(int i = r.size()-1;i>=0;i--)
            System.out.print(r.get(i));
        System.out.println("\n");
    }

    static void restadorBinario(long a, long b){
        ArrayList<Long> ar = new ArrayList<Long>();
        ArrayList<Long> br = new ArrayList<Long>();
        ArrayList<Long> r = new ArrayList<Long>();
        ar = array(a);
        br = array(b);
        while(ar.size()<br.size())
            ar.add((long)0);
        while(br.size()<ar.size())
            br.add((long)0);
        long acarreo=0;
        for(int i=0; i<ar.size(); i++){
            long temp;
            temp = ar.get(i)-acarreo;
            if(temp == 0 && br.get(i) == 0){
                r.add((long)0);
                acarreo = 0;
            }
            if(temp == 1 && br.get(i) == 0){
                r.add((long) 1);
                acarreo = 0;
            }
            if(temp == 1 && br.get(i) == 1){
                r.add((long) 0);
                acarreo = 0;
            }
            if(temp == 0 && br.get(i) == 1){
                r.add((long) 1);
                acarreo = 1;
            }
        }
        System.out.print("Resultado de suma = ");
        for(int i = r.size()-1;i>=0;i--)
            System.out.print(r.get(i));
        System.out.println("\n");
    }
}