package com.meumenu.rest;

import com.meumenu.controller.ReceitaController;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.velocity.VelocityContext;

/**
 *
 * @author LucasReinaldo
 */
@Path("/")
public class RecursoListagemReceita {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String buscarReceitas(
            @QueryParam("chave") String chave) {
        if (chave == null) {
            chave = "";
        }

        VelocityContext context = new VelocityContext();
        context.put("chave", chave);
        context.put("receitas", ReceitaController.getInstance().buscarReceita(chave));
        return ConfiguracaoVelocity.gerarPagina("resources/listagem-receitas.vm", context);
    }

}
