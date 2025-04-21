package org.jason.backend.services;


import org.jason.backend.models.Producto;
import org.jason.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepo;

    public List<Producto> obtenerTodo()
    {
        return productoRepo.findAll();
    }
    public Optional<Producto> obtenerPorId(Long id)
    {
        return productoRepo.findById(id);
    }
    public Producto guardar(Producto p)
    {
        return productoRepo.save(p);
    }
    public boolean eliminar(Long id)
    {
        productoRepo.deleteById(id);
        return true;
    }
    public Producto actualizar(Producto p) {
        return productoRepo.save(p);
    }
}
