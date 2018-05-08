package com.meumenu.controller;

import com.meumenu.model.Receita;
import com.meumenu.model.ReceitaCache;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author david
 */
public class ReceitaController {

    private static final ReceitaController INSTANCE = new ReceitaController();

    public static ReceitaController getInstance() {
        return INSTANCE;
    }

    public void cadastrarReceita(Receita receita) {
        ReceitaCache.getInstance().adicionarReceita(receita);
    }

    public Set<Receita> buscarReceita(String value) {
        Set<Receita> receitas = new HashSet();
        if (value == null) {
            return ReceitaCache.getInstance().getReceitas();
        }
        for (Receita receita : ReceitaCache.getInstance().getReceitas()) {
            if (receita.getTitulo().toLowerCase().contains(value.toLowerCase()) || receita.getTexto().toLowerCase().contains(value.toLowerCase())) {
                receitas.add(receita);
            }
        }

        return receitas;
    }

    public Receita buscarReceitaPorId(Integer id) {
        if (id != null) {
            for (Receita receita : ReceitaCache.getInstance().getReceitas()) {
                if (receita.getId().equals(id)) {
                    return receita;
                }
            }
        }
        return null;
    }

    public Integer getUltimoIdValido() {
        return ReceitaCache.getInstance().getReceitas().size() + 1;
    }
}
