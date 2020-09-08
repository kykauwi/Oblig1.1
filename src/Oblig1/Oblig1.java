package Oblig1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    //Oppgave 1 (Metoder: ferdig)
    public static int maks(int[]a){
        if (a.length == 0){
            throw new NoSuchElementException("Denne tabellen er tom!");
        }

        for (int i= 0; i < a.length-1; i++){
                if (a[i] > a[i+1]){
                    int temp= a[i];a[i]=a[i+1];a[i+1]= temp; // bytter plass på a[i] og a[j] hvis den er sann.
                }
        }

        int max= a[a.length-1];

        return max;
    }

    public static int ombyttinger(int[] a){
        int teller= 0;

        for (int i= 0; i < a.length-1; i++){
                if (a[i] > a[i+1]){
                    int temp= a[i];
                    a[i]=a[i+1];
                    a[i+1]= temp;
                    teller++; // teller som øker for hver gang et et ombytte skjer.
            }
        }
        return teller;
    }

    //Oppgave 2 (Metode: ferdig)
    public static int antallUlikeSortert(int[]a){
        int teller= 1;

        if (a.length == 0){
            return 0;
        }

        boolean sortert= false;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] <= a[j]) {
                    sortert = true;
                } else {
                    sortert = false;
                    throw new IllegalStateException
                            ("Tabellen er ikke sortert i stigende rekkefølge!");
                }
            }
        }
        int j= 0;
        for (int i= 1; i < a.length; i++){
            for (j= 0; j < a.length; j++){
                if (a[i] == a[j]){
                    break;
                }
            }
            if (i == j){
                teller++;
            }
        }
        return teller;
    }

    // Oppgave 3 (Metode: ferdig)
    public static int antallUlikeUsortert(int[]a){
        if (a.length == 0){
            return 0;
        }

        int teller= 1;
        int j= 0;

        for (int i = 1; i < a.length; i++){
            for ( j= 0; j < a.length; j++){
                if (a[i] == a[j]){
                    break;
                }
            }
            if (i == j){
                teller++;
            }
        }
        return teller;
    }


 //Oppgave 4 - delsortering
    public static void delsortering(int[] a){
        if (a.length<=1){       //Trenger ikke sortere dersom det er 0 eller 1 element
            return;
        }
        int left = 0;
        int right = a.length-1;
        boolean partall = false;
        boolean oddetall = false;
        for (int i =0; i<a.length; ++i){
            while (a[left]%2!=0  && left<a.length-1){   //sjekker for oddetall
                left++;
                oddetall = true;
            }
            while (a[right]%2==0 && right>0) {          //sjekker for partall
                right--;
                partall = true;
            }
            if(left<right ){                        //Bytter plass paa oddetall og partall
                int temp = a[left];
                a[left] = a[right];
                a[right]=temp;
            }
        }
        if(partall && oddetall){                //Hvis arrayet har baade partall og odetall sorter dette
        sorter(a,0,left-1);
        sorter(a,left,a.length-1);
        }
        else{                                   // hvis arrayet har enten bare partall eller oddetall sorter dette
            sorter(a,0,a.length-1);
        }
    }

    //Oppgave 5
    public static void rotasjon(char[]a){
        if (a.length-1 >0){
        char temp = a[a.length - 1];

        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }

        a[0] = temp;
        }

    }
    //Oppgave 6
    public static void rotasjon(char[]a, int k){
        if (k < 0){
            for (int i= 0; k < 0; k++) {
                for (int j = 0; j < a.length - 1; j++) {
                    char temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        else {
            for(int i = 0; i < k; i++){
                for (int j= a.length-1; j > 0; j--){
                    char temp= a[j];
                    a[j]= a[j-1];
                    a[j - 1]= temp;
                }
            }
        }
    }

        //Oppgave 7a-fletting

    public static String flett(String s, String t) {
        String returner = "";
        int length = 0;
        if (s.length() > t.length()) {          //Sjekker hvilken String som er lengst for aa hente lengden
            length = s.length();
        } else {
            length = t.length();
        }
        for (int i = 0; i < length; i++) {
            if (s.length() > i) {               //Hvis i er mindre enn lengden paa strengen skal den legge til ny bokstav i returner strengen og gaa til neste streng sitt tilsvarende element
                char a = s.charAt(i);
                returner += String.valueOf(a);
            }
            if (t.length() > i) {
                char b = t.charAt(i);
                returner += String.valueOf(b);
            }
        }
        return returner;
    }

        //Oppgave 7b-fletting

        public static String flett(String... s){
        String returner = "";
        int maxlength =0;
            for(String a : s){                      //Gaar gjennom strengene som tas inn for aa finne den lengste
                if(a.length()>maxlength){
                    maxlength=a.length();
                }
                }
            for (int i = 0; i<maxlength;i++){       //Forsikrer oss om at vi ikke gaar forbi den lengste strengen
                for (String a:s){
                    if (a.length()>i) {             //Looper gjennom hver streng sitt element (i) for aa legge det inn i returner strengen
                        char b = a.charAt(i);
                        returner += String.valueOf(b);
                    }
                }
            }
            return returner;
        }

        //Oppgave 8

        public static int [] indekssortering(int[]a){
        int [] indekstabell = new int [a.length];
        int [] hjelpetabell = new int [a.length];

        for (int i =0; i<a.length;i++){                 //oppretter en hjelpetabell for aa ikke endre paa selve arrayet som tas inn
            hjelpetabell[i] = a[i];
        }
        for (int i = 0; i<indekstabell.length; i++){            //Oppretter en indekstabell med lengde som a for aa kunne flytte på disse
            indekstabell[i] = i;
        }

            for (int i= 0; i < hjelpetabell.length; i++) {
                for (int j = i + 1; j < hjelpetabell.length; j++) {         //Sorterer hjelpetabellen og samtidig flytter paa indexene i tilsvarende posisjon i indextabellen naar den flytter paa to tall i arrrayet
                    if (hjelpetabell[i] > hjelpetabell[j]) {
                        int temp = hjelpetabell[i];
                        hjelpetabell[i] = hjelpetabell[j];
                        hjelpetabell[j] = temp;
                        int temp2 = indekstabell[i];
                        indekstabell[i] = indekstabell[j];
                        indekstabell[j] = temp2;
                    }
                }
            }

        return indekstabell;
        }
    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }
    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }


    public static void main(String[] args) {
        int[] a = {2,20,7,4,1,6,10,5,19};
        int[] b = {4,2,8,10,6};
        int [] e ={3,9,1,27,15};
        char[]d= {'a','b','c','d','e'};
        String[] c= {"Hei","Hallo", "Hoi", "data"};
        String s = "Hei";
        String t= "Hallo";

       // rotasjon(d, -3);
     //   indekssortering(b);
        delsortering(a);
        delsortering(b);
        delsortering(e);

    }
    // Hjelpemetoder
    public static void sorter(int [] a, int begin, int end ){
        if (begin >= end) {
            return;
        }

        int pivotIndex = begin + (end - begin) / 2;
        int pivot = a[pivotIndex];
        int i = begin;
        int j = end;

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                Oblig1Test.bytt(a,i,j);
                i++;
                j--;
            }
        }

        if (begin < j) {
            sorter(a, begin, j);
        }
        if (end > i) {
            sorter(a, i, end);
        }
    }

}

