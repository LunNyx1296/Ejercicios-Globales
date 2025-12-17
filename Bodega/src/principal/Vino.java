package principal;

public class Vino extends Articulo {

    private String color;
    private String Origen;
    private int año;
    private String uva;

    public Vino(String codigo, String nombre, String marca, double precio, int stock,
                String color, String Origen, int año, String uva) {

        super(codigo, nombre, marca, precio, stock);
        this.color = color;
        this.Origen = Origen;
        this.año = año;
        this.uva = uva;
    }

    @Override
    public void printCaracteristicas() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Marca: " + marca);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Color: " + color);
        System.out.println("Origen: " + Origen);
        System.out.println("Año: " + año);
        System.out.println("Uva: " + uva);
    }

    @Override
    public boolean sano() {
        return Origen.equalsIgnoreCase("rioja");
    }
}
