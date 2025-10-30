import java.util.ArrayList;

public class Vozilo {
	private String proizvodjac;
	private int godinaProizvodnje;
	private int kubikaza;
	private String boja;
	
	public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.kubikaza = kubikaza;
		this.boja = boja;
	}
	//g i s
	public String getProizvodjac() { return proizvodjac; }
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
		}
	public int getGodinaProizvodnje() { return godinaProizvodnje; }
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
		}
	public int getKubikaza() { return kubikaza; }
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
		}
	public String getBoja() { return boja; }
	public void setboja(String boja) {
		this.boja = boja;
		}
	

class Automobil extends Vozilo {
	private int brojVrata;
	private String tipMotora;
	public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int brojVrata, String tipMotora) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.brojVrata = brojVrata;
		this.tipMotora = tipMotora;
	}
	//get i sss
	public int getBrojVrata() { return brojVrata; }
	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
		}
	public String getTipMotora() { return tipMotora; }
	public void setTipMotora(String tipMotora) {
		this.tipMotora = tipMotora;
		}
	//met
	public double cijenaRegistracije() {
		double cijena = 100;
		if (godinaProizvodnje < 2010)
			cijena += 30;
		if (kubikaza > 2000)
			cijena += 50;
		if (tipMotora.equalsIgnoreCase("dizel"))
			cijena += 20;
		return cijena;
		}
	@Override
	public String toString() {
		return String.format("Automobil [proizvodjac=%s, godina=%d, kubikaza=%d, boja=%s, vrata=%d, tipMotora=%s, cijenaRegistracije=%.2f€]",
				proizvodjac, godinaProizvodnje, kubikaza, boja, brojVrata, tipMotora, cijenaRegistracije());
	
}

class Kamion extends Vozilo {
	private int kapacitetTereta;
	private boolean prikolica;
	public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetTereta, boolean prikolica) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetTereta = kapacitetTereta;
		this.prikolica = prikolica;
	}
	//get i sett
	public int getKapacitetTereta() { return kapacitetTereta; }
	public void setKapacitetTereta(int kapacitetTereta) {
		this.kapacitetTereta = kapacitetTereta;
	}
	public boolean getPrikolica() { return prikolica; }
	public void setPrikolica(boolean prikolica) {
		this.prikolica = prikolica;
	}
	//mett
	public double cijenaRegistracije() {
		double cijena = 100;
		if (godinaProizvodnje < 2010)
			cijena += 30;
		if (kubikaza > 2000)
			cijena += 50;
		if (prikolica)
			cijena += 50;
		return cijena;
		}
	@Override
	public String toString() {
		return String.format("Kamion [proizvodjac=%s, godina=%d, kubikaza=%d, boja=%s, kapacitet=%d, prikolica=%s, cijenaRegistracije=%.2f€]",
				proizvodjac, godinaProizvodnje, kubikaza, boja, kapacitetTereta, prikolica ? "da" : "ne", cijenaRegistracije());
	
}

class Kombi extends Vozilo {
	private int kapacitetPutnika;
	public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetPutnika) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetPutnika = kapacitetPutnika;
	}
	public int getKapacitetPutnika() { return kapacitetPutnika; }
	public void setKapacitetPutnika(int kapacitetPutnika) {
		this.kapacitetPutnika = kapacitetPutnika;
	}
	//metoda
	public double cijenaRegistracije() {
		double cijena = 100;
		if (godinaProizvodnje < 2010)
			cijena += 30;
		if (kubikaza > 2000)
			cijena += 50;
		if (kapacitetPutnika > 8)
			cijena += 30;
		return cijena;
		}
	@Override
	public String toString() {
		return String.format("Kombi [proizvodjac=%s, godina=%d, kubikaza=%d, boja=%s, kapacitetPutnika=%d, cijenaRegistracije=%.2f€]",
				proizvodjac, godinaProizvodnje, kubikaza, boja, kapacitetPutnika, cijenaRegistracije());
	
	
} 


	public static void main(String[] args) {
		ArrayList<Object> vozila = new ArrayList<>();
		vozila.add(new Kombi("MERCEDES", 2020, 2000, "siva", 9) );
		
		
	}

}
