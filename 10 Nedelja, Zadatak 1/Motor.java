
public class Motor extends Vozilo implements Ekonomican {

	public Motor(String id, double maxBrzina) {
		super(id, 80);
	}

	@Override
	public double izracunajVrijemeDostave(double udaljenostKm) {
		return udaljenostKm / maxBrzina;
	}

	@Override
	public double potrosnjaPoKm() {
		return 0;
	}

}
