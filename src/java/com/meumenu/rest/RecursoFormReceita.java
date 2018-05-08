package com.meumenu.rest;

import com.meumenu.controller.ReceitaController;
import com.meumenu.model.Receita;
import java.net.URI;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.velocity.VelocityContext;

/**
 *
 * @author david
 */
@Path("/receita")
public class RecursoFormReceita {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String visualizarReceita(
            @QueryParam("id") Integer id) {
        VelocityContext context = new VelocityContext();
        if (id == null) {
            return ConfiguracaoVelocity.gerarPagina("resources/form-receita.vm", context);
        }

        context.put("receita", ReceitaController.getInstance().buscarReceitaPorId(id));
        return ConfiguracaoVelocity.gerarPagina("resources/receita.vm", context);
    }

    @POST
    public Response cadastrar(
            @FormParam("titulo") String titulo,
            @FormParam("texto") String texto) {

        Receita receita = new Receita(ReceitaController.getInstance().getUltimoIdValido(), titulo, texto);
        ReceitaController.getInstance().cadastrarReceita(receita);
        return Response.seeOther(URI.create("/meumenu/")).build();
    }
}
