package cl.duoc.gabrxino.coffee_backend;

import cl.duoc.gabrxino.coffee_backend.model.Producto;
import cl.duoc.gabrxino.coffee_backend.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataLoader(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {
            System.out.println("--- INICIANDO CARGA MASIVA DE DATOS ---");
            cargarCafes();
            cargarPasteleria();
            cargarSandwiches();
            cargarBebidasFrias();
            System.out.println("--- CARGA COMPLETA: 50+ PRODUCTOS CREADOS ---");
        }
    }

    private void cargarCafes() {
        crear("Espresso", "Café intenso y concentrado", 1800, "CAFE", "https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?w=500");
        crear("Espresso Doble", "Doble carga de energía", 2200, "CAFE", "https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?w=500");
        crear("Americano", "Espresso diluido en agua caliente", 2000, "CAFE", "https://images.unsplash.com/photo-1559496417-e7f25cb247f3?w=500");
        crear("Cortado", "Espresso con un toque de leche", 2100, "CAFE", "https://images.unsplash.com/photo-1514432324607-a09d9b4aefdd?w=500");
        crear("Cappuccino Tradicional", "Espresso, leche y mucha espuma", 2800, "CAFE", "https://images.unsplash.com/photo-1572442388796-11668a67e53d?w=500");
        crear("Cappuccino Vainilla", "Con jarabe de vainilla natural", 3200, "CAFE", "https://images.unsplash.com/photo-1572442388796-11668a67e53d?w=500");
        crear("Cappuccino Avellana", "Dulce toque de avellana tostada", 3200, "CAFE", "https://images.unsplash.com/photo-1572442388796-11668a67e53d?w=500");
        crear("Latte Macchiato", "Leche manchada con espresso", 2900, "CAFE", "https://images.unsplash.com/photo-1593443320739-77f74952dabd?w=500");
        crear("Mocaccino", "Café, leche y salsa de chocolate", 3400, "CAFE", "https://images.unsplash.com/photo-1550681566-f1c305a2b376?w=500");
        crear("Flat White", "Doble espresso con capa fina de leche", 3000, "CAFE", "https://images.unsplash.com/photo-1577968897966-3d4325b36b61?w=500");
        crear("Caramel Macchiato", "Vainilla, leche, espresso y caramelo", 3600, "CAFE", "https://images.unsplash.com/photo-1461023058943-48dbf1399f98?w=500");
        crear("Café Irlandés", "Con un toque de whisky y crema", 4500, "CAFE", "https://images.unsplash.com/photo-1518057118035-76b4d32a0c4f?w=500");
        crear("Affogato", "Espresso sobre helado de vainilla", 3800, "CAFE", "https://images.unsplash.com/photo-1593016250795-327c59c5d0b4?w=500");
        crear("Chai Latte", "Té especiado con leche cremosa", 3100, "CAFE", "https://images.unsplash.com/photo-1576092762791-aa9c222faeeb?w=500");
        crear("Dirty Chai", "Chai Latte con un shot de espresso", 3500, "CAFE", "https://images.unsplash.com/photo-1576092762791-aa9c222faeeb?w=500");
    }

    private void cargarPasteleria() {
        crear("Medialuna", "Clásica argentina, dulce y mantecosa", 1200, "PASTELERIA", "https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=500");
        crear("Croissant Francés", "Hojaldre crujiente con mantequilla", 1800, "PASTELERIA", "https://images.unsplash.com/photo-1555507036-ab1f4038808a?w=500");
        crear("Croissant Almendras", "Relleno de crema de almendras", 2400, "PASTELERIA", "https://images.unsplash.com/photo-1509440159596-0249088772ff?w=500");
        crear("Muffin Arándano", "Esponjoso con arándanos frescos", 2000, "PASTELERIA", "https://images.unsplash.com/photo-1607958996333-41aef7caefaa?w=500");
        crear("Muffin Chocolate", "Doble chocolate con chips", 2100, "PASTELERIA", "https://images.unsplash.com/photo-1607958996333-41aef7caefaa?w=500");
        crear("Donut Glaseada", "Clásica dona con glaseado de azúcar", 1500, "PASTELERIA", "https://images.unsplash.com/photo-1551024506-0bccd828d307?w=500");
        crear("Donut Rellena", "Rellena con manjar o crema pastelera", 1800, "PASTELERIA", "https://images.unsplash.com/photo-1551024506-0bccd828d307?w=500");
        crear("Brownie", "Denso, húmedo y con muchas nueces", 2200, "PASTELERIA", "https://images.unsplash.com/photo-1564355808539-22fda35bed7e?w=500");
        crear("Cheesecake Frutos Rojos", "Porción de tarta de queso estilo NY", 3500, "PASTELERIA", "https://images.unsplash.com/photo-1524351199678-941a58a3df50?w=500");
        crear("Pie de Limón", "Base crujiente con merengue italiano", 3200, "PASTELERIA", "https://images.unsplash.com/photo-1519915028121-7d3463d20b13?w=500");
        crear("Torta de Zanahoria", "Con frosting de queso crema y nueces", 3400, "PASTELERIA", "https://images.unsplash.com/photo-1621303837174-89787a7d4729?w=500");
        crear("Galletón de Avena", "Saludable, con pasas y miel", 1500, "PASTELERIA", "https://images.unsplash.com/photo-1499636138143-bd649043ea52?w=500");
        crear("Galletón ChocoChips", "Estilo americano, borde crujiente", 1600, "PASTELERIA", "https://images.unsplash.com/photo-1499636138143-bd649043ea52?w=500");
        crear("Cinnamon Roll", "Rollo de canela con glaseado", 2300, "PASTELERIA", "https://images.unsplash.com/photo-1509365465985-25d11c17e812?w=500");
        crear("Tiramisú", "Postre italiano con café y mascarpone", 3800, "PASTELERIA", "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?w=500");
    }

    private void cargarSandwiches() {
        crear("Aliado", "Clásico jamón y queso caliente", 2500, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Barros Luco", "Carne a la plancha con queso derretido", 4200, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Ave Palta", "Pollo desmenuzado con palta hass", 3800, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Ave Pimiento", "Pasta de pollo con pimentón rojo", 3600, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Vegetariano", "Quesillo, tomate, lechuga y pesto", 3500, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Vegano Hummus", "Hummus, berenjena asada y rúcula", 3900, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Croissant Jamón Queso", "En masa de hoja francesa", 3200, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Tostadas con Palta", "Dos rebanadas con palta abundante", 3000, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Tostadas Mantequilla", "Simples y crujientes", 1800, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
        crear("Bagel Salmón", "Queso crema, salmón ahumado y alcaparras", 5500, "SANDWICH", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=500");
    }

    private void cargarBebidasFrias() {
        crear("Iced Coffee", "Café negro con hielo", 2500, "FRIO", "https://images.unsplash.com/photo-1517701604599-bb29b5c7fa5b?w=500");
        crear("Iced Latte", "Latte frío servido en capas", 3000, "FRIO", "https://images.unsplash.com/photo-1517701604599-bb29b5c7fa5b?w=500");
        crear("Cold Brew", "Infusión en frío por 12 horas", 3200, "FRIO", "https://images.unsplash.com/photo-1517701604599-bb29b5c7fa5b?w=500");
        crear("Frappuccino Café", "Granizado de café con crema", 3800, "FRIO", "https://images.unsplash.com/photo-1517701604599-bb29b5c7fa5b?w=500");
        crear("Frappuccino Moka", "Granizado con chocolate", 4000, "FRIO", "https://images.unsplash.com/photo-1517701604599-bb29b5c7fa5b?w=500");
        crear("Frappuccino Caramelo", "El favorito, muy dulce", 4000, "FRIO", "https://images.unsplash.com/photo-1517701604599-bb29b5c7fa5b?w=500");
        crear("Jugo Naranja", "Recién exprimido", 2800, "FRIO", "https://images.unsplash.com/photo-1600271886742-f049cd451bba?w=500");
        crear("Limonada Menta", "Refrescante y natural", 2800, "FRIO", "https://images.unsplash.com/photo-1513558161293-cdaf765ed2fd?w=500");
        crear("Agua Mineral", "Con o sin gas", 1500, "FRIO", "https://images.unsplash.com/photo-1560706834-bed1cad2a2af?w=500");
        crear("Bebida Lata", "Coca-Cola, Sprite, Fanta", 1500, "FRIO", "https://images.unsplash.com/photo-1622483767028-3f66f32aef97?w=500");
    }

    private void crear(String nombre, String descripcion, int precio, String categoria, String imagen) {
        Producto prod = Producto.builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .imagen(imagen)
                .categoria(categoria)
                .stock((int) (Math.random() * 40) + 10)
                .destacado(Math.random() > 0.7) //
                .build();

        repository.save(prod);
    }
}