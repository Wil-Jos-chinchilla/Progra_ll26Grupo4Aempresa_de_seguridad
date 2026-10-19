/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;  

/**
 *
 * @author JOSUE
 */

@RequestScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    @Transactional
    public void create(Cliente nuevoCliente) {
        this.persist(nuevoCliente);
    }

    public List<Cliente> findClientes() {
        try {
            TypedQuery<Cliente> q = getEntityManager().createQuery(
                    "SELECT c FROM Cliente c ORDER BY c.IdCliente DESC", Cliente.class);
            return q.getResultList();
        } catch (Exception e) {
            System.out.println("e-> " + e);
            return null;
        }
    }
}