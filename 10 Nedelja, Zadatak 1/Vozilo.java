
public abstract class Vozilo {
    
	private String id;
    protected double maxBrzina;

    public Vozilo(String id, double maxBrzina) {
        this.id = id;
        this.maxBrzina = maxBrzina;
    }

	public String getId() {return id;}
	public void setId(String id) {
		this.id = id;
	}

	public double getMaxBrzina() {return maxBrzina;}
	public void setMaxBrzina(double maxBrzina) {
		this.maxBrzina = maxBrzina;
	}
	
	public void info() {
        System.out.println("Vozilo ID: " + id);
        System.out.println("Max brzina: " + maxBrzina + " km/h");
    }
	
	public boolean jeEkonomican() {
	    return this instanceof Ekonomican;
	}
	
	public abstract double izracunajVrijemeDostave(double udaljenostKm);
    
}