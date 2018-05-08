package com.meumenu.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author david
 */
public class ReceitaCache {

    private static final ReceitaCache INSTANCE = new ReceitaCache();

    private Set<Receita> receitas = new HashSet();

    public static ReceitaCache getInstance() {
        return INSTANCE;
    }

    public void adicionarReceita(Receita receita) {
        if (this.receitas == null) {
            this.receitas = new HashSet();
        }
        this.receitas.add(receita);
    }
    
    public Set<Receita> getReceitas() {
        return receitas;
    }

    public void destroyCache() {
        receitas = new HashSet();
    }
}
