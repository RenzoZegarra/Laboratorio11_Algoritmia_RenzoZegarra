package hash;

public class Ejercicio4 
{
    public static void main(String[] args) 
    {
        HashC tabla = new HashC(7);
        System.out.println("Se insertaron las claves: 5,12,19");
        tabla.insert(new Register(5, "Cinco"));
        tabla.insert(new Register(12, "Doce")); 
        tabla.insert(new Register(19, "Diecinueve"));
        System.out.println("Tabla Hash Closed: ");
        tabla.printTable();
        tabla.delete(12);
        System.out.println("Se eliminó la clave 12: ");
        tabla.printTable();
    }
}
