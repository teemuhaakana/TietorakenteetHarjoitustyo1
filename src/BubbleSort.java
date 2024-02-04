//Luokka kuplajärjestämiselle
public class BubbleSort {
  public void bubbleSort(int[] taulukko) {
     
	//Boolean-muuttuja, joka seuraa, jatketaanko taulukon iterointia, vai onko kaikki
	//taulukon parit vaihdettu jo
	//Asetetaan arvo true, jotta while-loop alkaa
    boolean vaihdettu = true;
    
    while (vaihdettu) {
      vaihdettu = false;
      //For-silmukka, joka käy taulukon alkiot läpi
      for (int i = 0; i < taulukko.length - 1; i++) {
    	 //Selvitetään onko nykyinen taulukon alkio seuraavaa alkiota suurempi
        if (taulukko[i] > taulukko[i + 1]) {
        	//jos on, asetetaan Boolean-muuttuja vaihdettu arvoon true
          vaihdettu = true;
          //tallennetaan nykyinen alkio temp-muuttujaan
          int temp = taulukko[i];
          //vaihdetaan alkioiden paikkoja
          taulukko[i] = taulukko[i + 1];
          //taulukon seuraavasta alkiosta tulee nykyinen alkio ja näin saadaan alkiopari vaihdettua
          taulukko[i + 1] = temp;
        }
      }
    }
  }
}