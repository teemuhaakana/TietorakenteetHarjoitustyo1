import java.util.Calendar;
import java.util.Random;

//Luokka järjestämisalgoritmien testaamista varten
public class TestausOhjelma {
	//Metodi, joka luo parametrinä annetun kokoisen taulukon
	 public static int[] luoTaulukko(int koko) {
	        int[] taulukko = new int[koko];
	        //Hyödynnetään Javan Random-luokkaa satunnaisten lukujen muodostamiseen
	        Random random = new Random();
	        //Täytetään taulukko satunnaisilla luvuilla 
	        for (int i = 0; i < koko; i++) {
	            taulukko[i] = random.nextInt(30000000);
	        }
	        //palautetaan taulukko, jotta sitä voidaan käyttää itse main-metodissa
	        return taulukko;
	    }
	 
	    public static void main(String[] args) {
	    	//Määritetään halutut taulukoiden koot
	    	//Lomitusjärjestämisen (mergesort) testaamista varten suuremmat taulukot
	        int[] koot = {5000000, 10000000, 20000000, 50000000, 100000000};
	        //Luodaan kullekin koolle kolme eri sisältöistä taulukkoa
	        for (int koko : koot) {
	            for (int i = 0; i < 3; i++) {
	            	//Kutsutaan metodia, joka luo satunnaisia lukuja sisältävän taulukon
	                int[] taulukko = luoTaulukko(koko);
	                //Luodaan olio lomituslajittelun luokasta
	                MergeSort mergesortObjekti  = new MergeSort();
	                //aloitusaika
	                Calendar aika1 = Calendar.getInstance();
	                long alkuaika = aika1.getTimeInMillis();
	                //järjestetään taulukko
	                mergesortObjekti.mergeSort(taulukko);
	                //loppuaika
	                Calendar aika2 = Calendar.getInstance();
	                long loppuaika = aika2.getTimeInMillis();
	                //loppuajan ja aloitusajan erotus
	                long kulunutaika = loppuaika-alkuaika;
	                //tulostetaan taulukon koko ja kulunut aika
	                System.out.println("Lomituslajittelu: Taulukon koko: " +koko+ " Kulunut aika: "+kulunutaika);
	            }
	        }
	        //Kuplajärjestämisen (bubblesort) testaaminen (pienemmät taulukot, koska hitaampi)
	        int[] koot2 = {15625, 31250, 62500, 125000, 250000};
	        //Luodaan kullekin koolle kolme eri sisältöistä taulukkoa
	        for (int koko : koot2) {
	            for (int i = 0; i < 3; i++) {
	                int[] taulukko = luoTaulukko(koko);
	                BubbleSort bubblesortObjekti  = new BubbleSort();
	                Calendar aika1 = Calendar.getInstance();
	                long alkuaika = aika1.getTimeInMillis();
	                //järjestetään kuplajärjestämisellä
	                bubblesortObjekti.bubbleSort(taulukko);
	                Calendar aika2 = Calendar.getInstance();
	                long loppuaika = aika2.getTimeInMillis();
	                long kulunutaika = loppuaika-alkuaika;
	                //tulostetaan taulukon koko ja kulunut aika
	                System.out.println("Kuplajärjestäminen: Taulukon koko: " +koko+ " Kulunut aika: "+kulunutaika);
	            }
	        }
	    }
}
