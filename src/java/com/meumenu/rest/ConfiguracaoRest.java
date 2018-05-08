package com.meumenu.rest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author LucasReinaldo
 */

@ApplicationPath("receitas")
public class ConfiguracaoRest extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        Collections.addAll(classes, 
                RecursoFormReceita.class,
                RecursoListagemReceita.class);
        return classes;
       
    }
}