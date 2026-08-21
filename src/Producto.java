import java.util.Arrays;

public class Producto {
    
    private String nombre;
    private String codigo;
    private double precio;
    private DetalleFactura[] detalles;

    public Producto(String nombre, String codigo, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.detalles = new DetalleFactura[0];
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public DetalleFactura[] getDetalles() {
        return detalles;
    }

    public void setDetalles(DetalleFactura[] detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(DetalleFactura detalle) {
        if (detalle == null) {
            return;
        }

        for (DetalleFactura item : detalles) {
            if (item == detalle) {
                return;
            }
        }

        DetalleFactura[] nuevo = Arrays.copyOf(detalles, detalles.length + 1);
        nuevo[detalles.length] = detalle;
        detalles = nuevo;
    }

    public double calcularIngresosTotales() {
        double total = 0;
        for (DetalleFactura detalle : detalles) {
            if (detalle != null) {
                total += detalle.calcularSubtotal();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", detalles=" + Arrays.toString(detalles) +
                '}';
    }

}