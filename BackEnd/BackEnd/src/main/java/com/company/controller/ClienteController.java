/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.controller;

import com.mycompany.model.Cliente;
import com.mycompany.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author JOSUE
 */

@Path("/api/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @Inject
    ClienteRepository clienteRepo;

    @POST
    public Response saveNewCliente(Cliente nuevoCliente) {
        try {
            clienteRepo.create(nuevoCliente);
            return Response.ok(nuevoCliente).build();
        } catch (Exception e) {
            System.out.println("Error al crear cliente: " + e.getMessage());
            return Response.serverError().build();
        }
    }

    @GET
    public Response findClientes() {
        try {
            List<Cliente> lstCliente = clienteRepo.findClientes();
            return Response.ok(lstCliente).build();
        } catch (Exception e) {
            System.out.println("Error al consultar clientes: " + e.getMessage());
            return Response.serverError().build();
        }
    }

} 