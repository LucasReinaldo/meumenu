package com.meumenu.rest;

import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 *
 * @author LucasReinaldo
 */
class ConfiguracaoVelocity {
    
    public static void inicializarVelocity() {
        Velocity.setProperty(Velocity.RESOURCE_LOADER, "classpath");
        Velocity.setProperty("classpath.resource.loader.class", 
                ClasspathResourceLoader.class.getName());
        Velocity.init();
    }
    
    public static String gerarPagina(String template, VelocityContext context) {
        inicializarVelocity();
        StringWriter writer = new StringWriter();
        Template t = Velocity.getTemplate(template,"UTF-8");
        t.merge(context, writer);
        return writer.toString();
    }
    
}
