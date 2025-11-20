
public class Zadatak1 {
	public static void main(String[] args) {
		Vozilo bicikl = new Bicikl("B01", 20);
        Vozilo motor = new Motor("M01", 60);
        Vozilo auto = new Auto("A01", 180);

        double udaljenost = 60;

        System.out.println("- Bicikl -");
        bicikl.info();
        System.out.println("Vrijeme dostave: " + bicikl.izracunajVrijemeDostave(udaljenost) + " h");
        if (bicikl.jeEkonomican()) {
            System.out.println("Potrošnja po km: %.2f " + ((Ekonomican) bicikl).potrosnjaPoKm());
        }
        
        System.out.println("- Motor -");
        motor.info();
        System.out.println("Vrijeme dostave: %.2f " + motor.izracunajVrijemeDostave(udaljenost) + " h");
        
        System.out.println("- Auto -");
        auto.info();
        System.out.println("Vrijeme dostave: %.2f " + auto.izracunajVrijemeDostave(udaljenost) + " h");
        
        
        
	}

}
