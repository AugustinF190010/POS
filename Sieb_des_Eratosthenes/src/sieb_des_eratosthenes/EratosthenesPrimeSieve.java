/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieb_des_eratosthenes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    private int obergrenze;
    List<Integer> zahlen = new ArrayList<>();
    List<Integer> primzahlen = new ArrayList<>();

    public EratosthenesPrimeSieve(int pObergrenze) {
        obergrenze = pObergrenze;
    }

    public void fill() {
        for (int i = 2; i <= obergrenze; i++) {
            zahlen.add(i);
        }
    }

    public void sieb() {
        int zahl = 0;
        while (!zahlen.isEmpty()) {
            zahl = zahlen.get(0);

            int i = 0;
            while (i < zahlen.size()) {

                if (zahlen.get(i) % zahl == 0) {
                    if (zahl == zahlen.get(i)) {
                        primzahlen.add(zahlen.get(i));
                    }
                    zahlen.remove(i);
                } else {
                    i++;
                }
            }

        }
    }

    @Override
    public boolean isPrime(int p) {
       
        if(primzahlen.contains(p)){
            return true;
        }
        return false;
    }

    @Override
    public void printPrimes() {
       
        System.out.println(primzahlen);
    }
    
    public void summenAlgorythmus(int pObergrenze){
      
       int summe = 4;
       int erg;
       int x;
       int y;
       boolean b;
       while(summe <= pObergrenze){
           b = true;
           for(int i = 0; i < summe&&b; i++){
               for(int j = 0; j < summe; j++){
                   x =primzahlen.get(i);
                   y =primzahlen.get(j);
                   erg = x+y;
                   if(summe == erg){
                       System.out.println(summe+ " summe: "+summe+" = "+ x+ " + "+y);
                       b = false;
                       break;
                   }
               }
           }
           summe += 2;
       }
        
        
    }

    public static void main(String[] args) {
        
        EratosthenesPrimeSieve s = new EratosthenesPrimeSieve(180);
        s.fill();
        s.sieb();
        s.printPrimes();
        System.out.println(s.isPrime(7));
        System.out.println(s.isPrime(1));
        System.out.println(s.isPrime(12));
        System.out.println(s.isPrime(19));
        s.summenAlgorythmus(19);
        
    }

}
