
public class Auto extends Vozilo implements Ekonomican {

	public Auto(String id, double maxBrzina) {
		super(id, 240);
	}

	@Override
	public double potrosnjaPoKm() {
		return 0;
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		return udaljenostKm / maxBrzina;
	}

}
