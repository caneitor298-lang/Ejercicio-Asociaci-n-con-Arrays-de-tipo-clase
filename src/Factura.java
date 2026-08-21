import java.util.Arrays;
import java.util.Date;

public class Factura {
    private int numero;
    private Date fecha;
    private String nombreCliente;
    private DetalleFactura[] detalles;

    public Factura(int numero, Date fecha, String nombreCliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.detalles = new DetalleFactura[0];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
        detalle.setFactura(this);
    }

    public double calcularTotal() {
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
        return "Factura{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", detalles=" + Arrays.toString(detalles) +
                '}';
    }
}
