package org.jason.backend.controllers;

import org.jason.backend.models.Producto;
import org.jason.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepo;

    @GetMapping("/all")
    public List<Producto> getAll(){
        return productoRepo.findAll();
    }
    @PostMapping("/add")
    public Producto add(@RequestBody Producto p){
        p.setId(null);
        return productoRepo.save(p);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Producto p)
    {
        return productoRepo.findById(id).map(prod -> {
            prod.setNombre(p.getNombre());
            prod.setDescripcion(p.getDescripcion());
            prod.setPrecio(p.getPrecio());
            prod.setImagen(p.getImagen());
            return ResponseEntity.ok(productoRepo.save(prod));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        if(productoRepo.existsById(id))
        {
            productoRepo.deleteById(id);
            return ResponseEntity.ok("Producto eliminado");
        }
        return ResponseEntity.notFound().build();
    }
}
