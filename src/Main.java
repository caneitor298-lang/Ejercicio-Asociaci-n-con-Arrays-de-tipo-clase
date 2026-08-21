import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Leche", "P001", 12.50);
        Producto producto2 = new Producto("Manzanas", "P002", 7.25);
        Producto producto3 = new Producto("Cereal", "P003", 18.00);
        Producto producto4 = new Producto("Carne", "P004", 42.75);
        Producto producto5 = new Producto("Salsa de tomate", "P005", 15.30);

        Producto[] catalogo = {producto1, producto2, producto3, producto4, producto5};

        Factura factura1 = new Factura(1001, new Date(), "Juan Pérez");
        Factura factura2 = new Factura(1002, new Date(), "Ana López");
        Factura factura3 = new Factura(1003, new Date(), "Carlos Ruiz");

        factura1.addDetalle(new DetalleFactura(producto1, factura1, 2));
        factura1.addDetalle(new DetalleFactura(producto3, factura1, 1));

        factura2.addDetalle(new DetalleFactura(producto2, factura2, 5));
        factura2.addDetalle(new DetalleFactura(producto4, factura2, 2));

        factura3.addDetalle(new DetalleFactura(producto1, factura3, 1));
        factura3.addDetalle(new DetalleFactura(producto2, factura3, 3));
        factura3.addDetalle(new DetalleFactura(producto3, factura3, 4));
        factura3.addDetalle(new DetalleFactura(producto5, factura3, 2));

        System.out.println("=== Facturas ===");
        for (Factura factura : new Factura[] {factura1, factura2, factura3}) {
            System.out.println("Factura " + factura.getNumero() + " - Cliente: " + factura.getNombreCliente());
            for (DetalleFactura detalle : factura.getDetalles()) {
                System.out.println("  - " + detalle.getProducto().getNombre() +
                        " | Cantidad: " + detalle.getCantidad() +
                        " | Subtotal: Q" + detalle.calcularSubtotal());
            }
            System.out.println("  Total: Q" + factura.calcularTotal());
            System.out.println();
        }

        System.out.println("=== Producto con menor ingreso ===");
        Producto productoMenorIngreso = catalogo[0];
        double menorIngreso = productoMenorIngreso.calcularIngresosTotales();

        for (Producto producto : catalogo) {
            double ingresos = producto.calcularIngresosTotales();
            if (ingresos < menorIngreso) {
                menorIngreso = ingresos;
                productoMenorIngreso = producto;
            }
        }

        System.out.println(productoMenorIngreso.getNombre() + " generó Q" + menorIngreso);

        System.out.println("=== Factura mayor ===");
        Factura facturaMayor = factura1;
        double mayorTotal = factura1.calcularTotal();

        for (Factura factura : new Factura[] {factura2, factura3}) {
            if (factura.calcularTotal() > mayorTotal) {
                mayorTotal = factura.calcularTotal();
                facturaMayor = factura;
            }
        }

        System.out.println("Factura " + facturaMayor.getNumero() + " con total de Q" + facturaMayor.calcularTotal());
    }
}