package cl.duoc.gabrxino.coffee_backend.repository;

import cl.duoc.gabrxino.coffee_backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    Page<Producto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);


    Page<Producto> findByCategoria(String categoria, Pageable pageable);


    Page<Producto> findByNombreContainingIgnoreCaseAndCategoria(String nombre, String categoria, Pageable pageable);


    List<Producto> findByDestacadoTrue();
}