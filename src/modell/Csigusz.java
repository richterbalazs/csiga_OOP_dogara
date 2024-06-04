
package modell;

public class Csigusz {
    
    public enum Szinek{PIROS,KEK,ZOLD}
    
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    private String nev;
    private Szinek szinNev;  
    private String szinKod;
    
//    public Csigusz(){
//        this("Csiga Adel", "narancssarga");
//    }
    
    public Csigusz(String nev) throws Exception {
        this(nev, Szinek.PIROS);
    }
    
    public Csigusz(String nev, Szinek szinNev) throws Exception {
       // this.nev = nev;
        setNev(nev);
//        this.szinNev = szinNev;
        this.szinKod = RESET;
        this.szinNev = szinNev;
        setSzin();
    }
    
    public void setNev(String nev) throws Exception{
        if (nev.length() >= 3) {
            char nevElso = nev.charAt(0);
            if (Character.isLowerCase(nevElso)) {
                nevElso = Character.toUpperCase(nevElso);
                nev = nevElso + nev.substring(1);
            }
            this.nev = nev;
        } else {
            throw new Exception("A név rövid!");
        }
    }
    
    
    
    public String getNev() {
        return nev;
    }

    public String getSzin() {
        return szinNev.toString();
    }
    

    @Override
    public String toString() {
        return szinKod + "Csigusz{" + "nev = " + nev + ", szin = " + szinNev + '}' + RESET;
    }

    private void setSzin() {
        switch(szinNev){
            case PIROS:
                szinKod = Csigusz.RED;
                break;
            case KEK:
                szinKod = Csigusz.BLUE;
                break;
            case ZOLD:
                szinKod = Csigusz.GREEN;
                break;
        }
    }
    
    
    
}
