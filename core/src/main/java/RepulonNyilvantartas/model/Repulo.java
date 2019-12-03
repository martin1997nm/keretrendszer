package RepulonNyilvantartas.model;

import RepulonNyilvantartas.exceptions.RosszDatum;
import RepulonNyilvantartas.exceptions.RosszEvjarat;
import RepulonNyilvantartas.exceptions.RosszNszam;

import java.time.LocalDate;
import java.util.Objects;

public class Repulo {
    private String gyarto;
    private String tipus;
    private String nszam;
    private LocalDate uzembehelyezes_datuma;
    private int teljesitmeny;
    private int suly;
    private int ajtok_szama;
    private int hajtomuvek_szama;
    private int ulesek_szama;
    private int fesztav;
    private int evjarat;
    private String szin;
    private Allapot allapot;

    public Repulo() {
    }


    public Repulo(String gyarto, String tipus, String nszam, LocalDate uzembehelyezes_datuma, int tejesitmeny, int suly, int hajtomuvek_szama, int ulesek_szama, int fesztav, int evjarat, String szin, Allapot allapot) throws RosszDatum, RosszNszam, RosszEvjarat {
        this.gyarto = gyarto;
        this.tipus = tipus;
        setNszam(nszam);
        setUzembehelyezes_datuma(uzembehelyezes_datuma);
        this.teljesitmeny = tejesitmeny;
        this.suly = suly;
        this.ajtok_szama = hajtomuvek_szama;
        this.hajtomuvek_szama = ulesek_szama;
        this.fesztav = fesztav;
        setEvjarat(evjarat);
        this.szin = szin;
        this.allapot = allapot;
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getNszam() {
        return nszam;
    }

    public void setNszam(String nszam) throws RosszNszam {
        if(nszam.matches("^\\w\\d\\d\\d\\d\\d$")){
            this.nszam = nszam;
        }
        else{
            throw new RosszNszam(nszam);
        }
    }

    public LocalDate getUzembehelyezes_datuma() {
        return uzembehelyezes_datuma;
    }

    public void setUzembehelyezes_datuma(LocalDate uzembehelyezes_datuma) throws RosszDatum {
        if(uzembehelyezes_datuma.isBefore(LocalDate.MIN) ||
                uzembehelyezes_datuma.isAfter(LocalDate.now())){
            throw new RosszDatum(uzembehelyezes_datuma.toString());
        }
        this.uzembehelyezes_datuma = uzembehelyezes_datuma;
    }

    public int getTeljesitmeny() {
        return teljesitmeny;
    }

    public void setTeljesitmeny(int loero) {
        this.teljesitmeny = loero;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }

    public int getHajtomuvek_szama() {
        return hajtomuvek_szama;
    }

    public void setHajtomuvek_szama(int ajtok_szama) {
        this.hajtomuvek_szama = hajtomuvek_szama;
    }

    public int getUlesek_szama() {
        return ulesek_szama;
    }

    public void setUlesek_szama(int ulesek_szama) {
        this.ulesek_szama = ulesek_szama;
    }

    public int getFesztav() {
        return fesztav;
    }

    public void setKerek_atmero(int kerek_atmero) {
        this.fesztav = kerek_atmero;
    }

    public int getEvjarat() {
        return evjarat;
    }

    public void setEvjarat(int evjarat) throws RosszEvjarat {
        if(evjarat<0 || evjarat> LocalDate.now().getYear()){
            throw new RosszEvjarat(String.valueOf(evjarat));
        }
        this.evjarat = evjarat;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szinkod) {
        this.szin = szinkod;
    }

    public Allapot getAllapot() {
        return allapot;
    }

    public void setAllapot(Allapot allapot) {
        this.allapot = allapot;
    }

    @Override
    public String toString() {
        return "Repulo{" +
                "gyarto='" + gyarto + '\'' +
                ", tipus='" + tipus + '\'' +
                ", nszam='" + nszam + '\'' +
                ", uzembehelyezes_datuma=" + uzembehelyezes_datuma +
                ", teljesitmeny=" + teljesitmeny +
                ", suly=" + suly +
                ", hajtomuvek_szama=" + hajtomuvek_szama +
                ", ulesek_szama=" + ulesek_szama +
                ", kerek_atmero=" + fesztav +
                ", evjarat=" + evjarat +
                ", szinkod='" + szin + '\'' +
                ", allapot=" + allapot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repulo repulo = (Repulo) o;
        return teljesitmeny == repulo.teljesitmeny &&
                suly == repulo.suly &&
                ajtok_szama == repulo.ajtok_szama &&
                ulesek_szama == repulo.ulesek_szama &&
                fesztav == repulo.fesztav &&
                evjarat == repulo.evjarat &&
                Objects.equals(gyarto, repulo.gyarto) &&
                Objects.equals(tipus, repulo.tipus) &&
                Objects.equals(nszam, repulo.nszam) &&
                Objects.equals(uzembehelyezes_datuma, repulo.uzembehelyezes_datuma) &&
                Objects.equals(szin, repulo.szin) &&
                allapot == repulo.allapot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gyarto, tipus, nszam, uzembehelyezes_datuma, teljesitmeny, suly, ajtok_szama, ulesek_szama, fesztav, evjarat, szin, allapot);
    }
}
