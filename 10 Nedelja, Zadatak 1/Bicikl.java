
public class Bicikl extends Vozilo implements Ekonomican {

	public Bicikl(String id, double maxBrzina) {
		super(id, 20);
	}
	
	@Override
	public double potrosnjaPoKm() {
		return 0.0;
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		return udaljenostKm / maxBrzina;
	}

}
