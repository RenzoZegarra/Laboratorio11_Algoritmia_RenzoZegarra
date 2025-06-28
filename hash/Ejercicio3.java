package hash;

public class Ejercicio3 
{
    public static void main(String[] args) 
    {
        HashO tabla = new HashO(5);

        tabla.insert(new Register(10, "Juan"));
        tabla.insert(new Register(15, "Ana"));
        tabla.insert(new Register(20, "Luis"));
        tabla.insert(new Register(25, "Rosa"));

        System.out.println("Tabla hash con encadenamiento:");
        tabla.printTable();

        System.out.println("\nBuscando clave 20:");
        Register encontrado = tabla.search(20);
        System.out.println(encontrado != null ? encontrado : "No encontrado");

        System.out.println("\nBuscando clave 30:");
        encontrado = tabla.search(30);
        System.out.println(encontrado != null ? encontrado : "No encontrado");
    }
}
