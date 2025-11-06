import java.util.ArrayList;
import java.util.Scanner;

class EProizvod {
    private String opis;
    private String sifra;
    private double uvoznaCijena;
    
    public EProizvod(String opis, String sifra, double uvoznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.uvoznaCijena = uvoznaCijena;
    }
    
    public String getOpis() {return opis;}
	public void setOpis(String opis) {this.opis = opis;}

	public String getSifra() {return sifra;}
	public void setSifra(String sifra) {this.sifra = sifra;}

	public double getUvoznaCijena() {return uvoznaCijena;}
	public void setUvoznaCijena(double uvoznaCijena) {this.uvoznaCijena = uvoznaCijena;}
	
	public double maloprodajnaCijena() {
        double cijena = uvoznaCijena * 1.05;
        return cijena;
    }
	
	public String tipProizvoda() {
        if (sifra.startsWith("RA")) 
        	return "Racunari";
        if (sifra.startsWith("TE")) 
        	return "Telefoni";
        if (sifra.startsWith("TV")) 
        	return "TV";
        return "Nema tog proizvoda";
    }
	
	@Override
    public String toString() {
        return String.format("%s [sifra=%s, uvoznaCijena=%.2f, maloprodajnaCijena=%.2f]", 
                opis, sifra, uvoznaCijena, maloprodajnaCijena());
    }

}	
	
	
class Racunari extends EProizvod {
    private String procesor;
    private int memorija; 

    public Racunari(String opis, String sifra, double uvoznaCijena, String procesor, int memorija) {
        super(opis, sifra, uvoznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }
	
    public String getProcesor() {return procesor;}
	public void setProcesor(String procesor) {this.procesor = procesor;}
    
	public int getMemorija() {return memorija;}
	public void setMemorija(int memorija) {this.memorija = memorija;}
    
	
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        cijena = cijena * 1.05;
        return cijena;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" [procesor=%s, memorija=%dGB]", procesor, memorija);
    }
    
}
    
    
class Telefoni extends EProizvod {
    private String operativniSistem;
    private double velicinaEkrana;

    public Telefoni(String opis, String sifra, double uvoznaCijena, String os, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.operativniSistem = os;
        this.velicinaEkrana = velicinaEkrana;
    }
    
    public String getOperativniSistem() {return operativniSistem;}
	public void setOperativniSistem(String operativniSistem) {this.operativniSistem = operativniSistem;}
	
	public double getVelicinaEkrana() {return velicinaEkrana;}
	public void setVelicinaEkrana(double velicinaEkrana) {this.velicinaEkrana = velicinaEkrana;}
    
	
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        if (velicinaEkrana > 6) cijena = cijena * 1.03;
        return cijena;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" [OS=%s, ekran=%.2f\"]", operativniSistem, velicinaEkrana);
    }
    
} 
    
    
class TV extends EProizvod {
    private double velicinaEkrana;

    public TV(String opis, String sifra, double uvoznaCijena, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.velicinaEkrana = velicinaEkrana;
    }

    public double getVelicinaEkrana() {return velicinaEkrana;}
	public void setVelicinaEkrana(double velicinaEkrana) {this.velicinaEkrana = velicinaEkrana;}
    
    public double maloprodajnaCijena() {
        double cijena = super.maloprodajnaCijena();
        if (velicinaEkrana > 65) cijena = cijena * 1.10;
        return cijena;
    }
    
	
	@Override
    public String toString() {
        return super.toString() + String.format(" [ekran=%.2f\"]", velicinaEkrana);
    }


}	
	
	
public class TestEProizvodi {

	public static void main(String[] args) {
		ArrayList<EProizvod> proizvodi = new ArrayList<>();
		
		proizvodi.add(new Racunari("Laptop Lenovo", "RA001", 1000, "Intel i5", 16));
		proizvodi.add(new Telefoni("IPhone", "TE100", 800, "IOS", 6.5));
		proizvodi.add(new TV("LG", "TV", 1200, 70));
		
		
        Scanner sc = new Scanner(System.in);
        int izbor;
		
        System.out.println("1. Unos uređaja");
        System.out.println("2. Prikaz svih uređaja");
        System.out.println("3. Prikaz po tipu uređaja");
        System.out.println("0. Izlaz");
        System.out.print("Izbor: ");
        izbor = sc.nextInt();
        
        if (izbor == 1) {
        	System.out.print("Opis: ");
            String opis = sc.nextLine();
            
            System.out.print("\nŠifra: ");
            String sifra = sc.nextLine();
            
            System.out.print("Uvozna cijena: ");
            double cijena = sc.nextDouble();
            
            if (sifra.startsWith("RA")) {
                System.out.print("Procesor: ");
                String procesor = sc.nextLine();
                
                System.out.print("Memorija (GB): ");
                int memorija = sc.nextInt();
                sc.nextLine();
                
                proizvodi.add(new Racunari(opis, sifra, cijena, procesor, memorija));
            } else if (sifra.startsWith("TE")) {
                System.out.print("Operativni sistem: ");
                String os = sc.nextLine();
                
                System.out.print("Ekran (inči): ");
                double ekran = sc.nextDouble();
                sc.nextLine();
                
                proizvodi.add(new Telefoni(opis, sifra, cijena, os, ekran));
            } else if (sifra.startsWith("TV")) {
                System.out.print("Ekran (inči): ");
                double ekran = sc.nextDouble();
                sc.nextLine();
                
                proizvodi.add(new TV(opis, sifra, cijena, ekran));
            } else {
                System.out.println("Nepoznat tip proizvoda!");
            }

        }
        if (izbor == 2) {
        	System.out.println("Prikaz svih uredjaja:");
        	for (EProizvod p : proizvodi) {
                System.out.println(p);
            }
        }
        if (izbor == 3) {
        	System.out.print("Tip uređaja (Racunari/Telefoni/TV): ");
            String tip = sc.nextLine();
            for (EProizvod p : proizvodi) {
                if (p.tipProizvoda().equalsIgnoreCase(tip)) {
                    System.out.println(p);
                }
            }
        }
        
        if (izbor == 0) {
        	System.out.println("Izlaz.");
        }
        
        
        sc.close();
	}

}

