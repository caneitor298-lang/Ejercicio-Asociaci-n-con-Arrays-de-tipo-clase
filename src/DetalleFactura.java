public class DetalleFactura {
    private Producto producto;
    private Factura factura;
    private int cantidad;

    public DetalleFactura(Producto producto, int cantidad) {
        this(producto, null, cantidad);
    }

    public DetalleFactura(Producto producto, Factura factura, int cantidad) {
        this.producto = producto;
        this.factura = factura;
        this.cantidad = cantidad;

        if (this.producto != null) {
            this.producto.addDetalle(this);
        }

        if (this.factura != null) {
            this.factura.addDetalle(this);
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        if (producto == null) {
            return 0;
        }
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" +
                "producto=" + producto +
                ", factura=" + factura +
                ", cantidad=" + cantidad +
                '}';
    }
}
