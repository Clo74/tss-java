/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.services;

import it.ciacformazione.nostalciac.business.CorsoStore;
import it.ciacformazione.nostalciac.business.SedeStore;
import it.ciacformazione.nostalciac.entity.Corso;
import it.ciacformazione.nostalciac.entity.Sede;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("corsi")
public class CorsiResource {

    @Inject
    CorsoStore store;

    @Inject
    SedeStore sedeStore;
    
    @GET
    public List<Corso> findAll() {
        return store.findAll();
    }

    @GET
    @Path("{id}")
    public Corso find(@PathParam("id") Integer id) {
        return store.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Corso c) {
        Sede sede = sedeStore.find(c.getIdSede());
        c.setSede(sede);
        store.save(c);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") Integer id,Corso c) {
        c.setId(id);
        c.setSede(sedeStore.find(c.getIdSede()));
        store.save(c);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        store.remove(id);
    }
}
