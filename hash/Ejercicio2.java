package hash;

public class Ejercicio2 
{
    public static void main(String[] args) 
    {
        HashC tabla = new HashC(6);

        System.out.println("Insertando valores con posibles colisiones con HashC:");
        tabla.insert(new Register(12, "Doce"));   // 12 % 6 = 0
        tabla.insert(new Register(18, "Dieciocho")); // 18 % 6 = 0 → colisión
        tabla.insert(new Register(24, "Veinticuatro")); // 24 % 6 = 0 → colisión
        tabla.insert(new Register(30, "Treinta")); // 30 % 6 = 0 → colisión

        System.out.println("\nTabla final:");
        tabla.printTable();
    }
}
