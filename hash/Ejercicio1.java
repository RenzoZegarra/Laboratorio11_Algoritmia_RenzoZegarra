package hash;

public class Ejercicio1 
{
    public static void main(String[] args) 
    {
        HashC tabla = new HashC(7);

        tabla.insert(new Register(3, "Valor1"));
        tabla.insert(new Register(10, "Valor2"));
        tabla.insert(new Register(17, "Valor3"));
        tabla.insert(new Register(24, "Valor4"));

        System.out.println("Tabla hash abierta sin colisiones:");
        tabla.printTable();
    }
}
