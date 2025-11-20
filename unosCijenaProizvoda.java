import java.util.Scanner;

public class unosCijenaProizvoda {
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);
        boolean losUnos = true;

        while (losUnos) {
            System.out.print("Unesite cijenu proizvoda: ");
            try {
                String tekst = unos.nextLine();
                double cijena = pretvoriIProvjeri(tekst);

                System.out.printf("Unijeli ste validnu cijenu: %.2f\n", cijena);
                losUnos = false; 
            }
            catch (NumberFormatException e) {
                System.out.printf("\nIzuzetak: %s\nMorate unijeti broj (bez teksta).\n\n", e);
            }
            catch (IllegalArgumentException e) {
                System.out.printf("\nIzuzetak: %s\nCijena mora biti veća od 0.\n\n", e);
            }
        }

        System.out.println("Program završen. :-) ");
    }

    public static double pretvoriIProvjeri(String unos) {
        double cijena;

        cijena = Double.parseDouble(unos);

        if (cijena <= 0) {
            throw new IllegalArgumentException("Unesena cijena je manja ili jednaka 0.");
        }

        return cijena;
    }
}