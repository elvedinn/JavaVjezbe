import java.util.ArrayList;

class Zaposleni {
    private int id;
    private String ime;
    private String prezime;
    protected double plataPoSatu;
    protected double ukupanBrojSati;

    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSati = ukupanBrojSati;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;} 
    
    public String getIme() {return ime;}
    public void setIme(String ime) {this.ime = ime;}
    
    public String getPrezime() {return prezime;}
    public void setPrezime(String prezime) {this.prezime = prezime;}
    
    public double getPlataPoSatu() {return plataPoSatu;}
    
    public double getUkupanBrojSati() {return ukupanBrojSati;}
    public void setUkupanBrojSati(double ukupanBrojSati) { 
    	this.ukupanBrojSati = ukupanBrojSati;
    }
    
    public double mesecnaPlata() {
		return 0;
	}
    public String tipZaposlenog() {
		return null;
	}
}


class Konobar extends Zaposleni {
    private double prekovremeniSati;

    public Konobar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.prekovremeniSati = prekovremeniSati;
    }
    
    public double getPrekovremeniSati() {return prekovremeniSati;}
    public void setPrekovremeniSati(double sati) {this.prekovremeniSati = sati;}
    
    public double mesecnaPlata() {
        double redovni = ukupanBrojSati * plataPoSatu;
        double prekovremeni = prekovremeniSati * plataPoSatu * 1.2;
        return 4 * (redovni + prekovremeni);
    }
    
    @Override
    public String tipZaposlenog() {return "Konobar";}
}

class Kuvar extends Zaposleni {
    private static final double DODATNI_IZNOS = 1500.0;

    public Kuvar(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
    }

    public double mesecnaPlata() {
        return DODATNI_IZNOS + 4 * ukupanBrojSati * plataPoSatu;
    }

    @Override
    public String tipZaposlenog() {return "Kuvar";}
}




class Menadzer extends Zaposleni {
    private static final double OSNOVICA = 1300.0;
    private double bonus;

    public Menadzer(int id, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.bonus = bonus;
    }
    
    public double getBonus() {return bonus;}
    public void setBonus(double bonus) {this.bonus = bonus;}
    
    public double mesecnaPlata() {
        return OSNOVICA + 4 * ukupanBrojSati * plataPoSatu + bonus;
    }

    @Override
    public String tipZaposlenog() {return "Menadzer";}
}




class Restoran {
    private String naziv;
    private String adresa;
    private String PIB;
    private ArrayList<Zaposleni> zaposleni;

    public Restoran(String naziv, String adresa, String PIB) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.PIB = PIB;
        this.zaposleni = new ArrayList<>();
    }
    
    public String getNaziv() {return naziv;}
    public void setNaziv(String naziv) {this.naziv = naziv;}
    
    public String getAdresa() {return adresa;}
    public void setAdresa(String adresa) {this.adresa = adresa;}
    
    public String getPIB() {return PIB;}
    public void setPIB(String PIB) {this.PIB = PIB;}
    
    
    
    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }
    
    public Zaposleni nadjiPoId(int id) {
        for (Zaposleni z : zaposleni) {
            if (z.getId() == id) return z;
        }
        return null;
    }
    
    
    public double obracunPlate() {
		return 0;
    	
    }
    
}


public class TestRestoran {

	public static void main(String[] args) {
		Restoran restoran = new Restoran("UDG Gurman", "Oktoih 1", "123456789");

        Konobar ko = new Konobar(1, "Marko", "Markovic", 10, 40, 5);
        Kuvar ku = new Kuvar(2, "Jelena", "Jankovic", 15, 38);
        Menadzer me = new Menadzer(3, "Petar", "Petrovic", 20, 35, 500);

        restoran.dodajZaposlenog(ko);
        restoran.dodajZaposlenog(ku);
        restoran.dodajZaposlenog(me);
	}

}
