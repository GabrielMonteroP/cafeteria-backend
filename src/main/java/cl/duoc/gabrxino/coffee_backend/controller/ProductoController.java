package cl.duoc.gabrxino.coffee_backend.controller;

import cl.duoc.gabrxino.coffee_backend.model.Producto;
import cl.duoc.gabrxino.coffee_backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    // 1. Endpoint para que React obtenga la lista de productos
    @GetMapping
    public Page<Producto> obtenerTodos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String categoria,
            @PageableDefault(size = 10) Pageable pageable) {

        // Filtra por Nombre Y Categoría
        if (nombre != null && !nombre.isEmpty() && categoria != null && !categoria.isEmpty()) {
            return repository.findByNombreContainingIgnoreCaseAndCategoria(nombre, categoria, pageable);
        }

        // Filtra solo por Nombre
        if (nombre != null && !nombre.isEmpty()) {
            return repository.findByNombreContainingIgnoreCase(nombre, pageable);
        }

        //Filtra solo por Categoría
        if (categoria != null && !categoria.isEmpty()) {
            return repository.findByCategoria(categoria, pageable);
        }

        // No hay filtros, devuelve todo
        return repository.findAll(pageable);
    }

    // 2. Endpoint para crear productos
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    // Endpoint para actualizar productos (PUT)
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {

        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));


        producto.setNombre(productoDetalles.getNombre());
        producto.setPrecio(productoDetalles.getPrecio());
        producto.setStock(productoDetalles.getStock());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setImagen(productoDetalles.getImagen());
        producto.setCategoria(productoDetalles.getCategoria());

        return repository.save(producto);
    }


    //Endpoint eliminar productos
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        repository.deleteById(id);
    }

    //Endpoint conseguir productos destacados para el carrusel del home
    @GetMapping("/destacados")
    public List<Producto> obtenerDestacados() {
        return repository.findByDestacadoTrue();
    }

    @PostMapping("/comprar")
    @Transactional
    public void procesarCompra(@RequestBody List<CompraItem> items) {
        for (CompraItem item : items) {
            Producto producto = repository.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (producto.getStock() < item.getCantidad()) {
                throw new RuntimeException("No hay suficiente stock para: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - item.getCantidad());
            repository.save(producto);
        }
    }

}