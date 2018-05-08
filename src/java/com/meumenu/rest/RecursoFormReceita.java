package com.meumenu.rest;

import com.meumenu.controller.ReceitaController;
import com.meumenu.model.Receita;
import java.net.URI;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.velocity.VelocityContext;

/**
 *
 * @author david
 */
@Path("/receita/{id}")
public class RecursoFormReceita {
    
    @PathParam("id")
    private Integer id;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String visualizarReceita(
            @QueryParam("editar") Boolean editar) {
        VelocityContext context = new VelocityContext();
        if (id == null) {
            return ConfiguracaoVelocity.gerarPagina("resources/not-found.vm", context);
        }

        context.put("receita", ReceitaController.getInstance().buscarReceitaPorId(id));
        if (editar) {
            return ConfiguracaoVelocity.gerarPagina("resources/form-receita.vm", context);
        }
        return ConfiguracaoVelocity.gerarPagina("resources/receita.vm", context);
    }
    
    @POST
    public Response cadastrar(
            @FormParam("nomeReceita") String titulo,
            @FormParam("receita") String texto) {

        Receita receita = new Receita(ReceitaController.getInstance().getUltimoIdValido(), titulo, texto);
        ReceitaController.getInstance().cadastrarReceita(receita);
        return Response.seeOther(URI.create("/receitas")).build();
    }
}
