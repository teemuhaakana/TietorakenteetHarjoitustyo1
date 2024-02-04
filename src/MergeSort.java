//Luokka lomituslajittelulle
public class MergeSort {
	//metodi, jolla lajitellaan kahtia jaettu taulukko
  public void mergeSort(int[] taulukko) {
	  //tallennetaan taulukon pituus muuttujaan
    int taulukonPituus = taulukko.length;
    
    //mikäli taulukon pituus on alle 2 se on jo järjestyksessä
    if (taulukonPituus < 2) {
      return;
    }
    
    //jaetaan taulukko kahteen osaan keskeltä
    int keskiIndeksi = taulukonPituus / 2;
    int[] vasenPuoli = new int[keskiIndeksi];
    int[] oikeaPuoli = new int[taulukonPituus - keskiIndeksi];
    
    //kopioidaan alkuperäisen taulukon alkupuolen alkioita kahtiajaetun taulukon vasemmanpuoleiseen taulukkoon
    for (int i = 0; i < keskiIndeksi; i++) {
       vasenPuoli[i] = taulukko[i];
    }
    //kopioidaan alkuperäisen taulukon alkupuolen alkioita kahtiajaetun taulukon oikeanpuoleiseen taulukkoon
    for (int i = keskiIndeksi; i < taulukonPituus; i++) {
       oikeaPuoli[i - keskiIndeksi] = taulukko[i];
    }
    
    //kutsuu mergesort-metodia rekursiivisesti jolloin jaetaan taulukot vielä pienemmiksi taulukoiksi
    mergeSort(vasenPuoli);
    mergeSort(oikeaPuoli);
    
    //yhdistetään järjestetyt taulukot alkuperäiseen taulukkoon
    merge(taulukko, vasenPuoli, oikeaPuoli);
  }

  private void merge (int[] taulukko, int[] vasenPuoli, int[] oikeaPuoli) {
	 //tallennetaan kahtiajaetun taulukon molempien puolien pituudet muuttujiin
    int vasenKoko = vasenPuoli.length;
    int oikeaKoko = oikeaPuoli.length;
    
    //indeksi i vasemmanpuoleista taulukkoa varten, j oikeanpuoleista ja k yhdistettyä taulukkoa varten
    int i = 0, j = 0, k = 0;
    
    //vertaillaan alkioita ja yhdistetään alkuperäiseen taulukkoon
    while (i < vasenKoko && j < oikeaKoko) {
      if (vasenPuoli[i] <= oikeaPuoli[j]) {
    	  //lisätään yhdistettyyn taulukkoon vasemman puolen alkio jos vasemman osataulukon alkio on pienempi tai yhtä suuri 
    	taulukko[k] = vasenPuoli[i];
        i++;
      }
      else {
    	  //muuten oikean puolen taulukosta alkio yhdistettyyn taulukkoon
        taulukko[k] = oikeaPuoli[j];
        j++;
      }
      k++;
    }
    //lisätään loput alkiot vasemmalta puolelta yhdistettyyn taulukkoon
    while (i < vasenKoko) {
      taulukko[k] = vasenPuoli[i];
      i++;
      k++;
    }
    //lisätään loput alkiot oikealta puolelta yhdistettyyn taulukkoon
    while (j < oikeaKoko) {
      taulukko[k] = oikeaPuoli[j];
      j++;
      k++;
    }
    
  }
}
