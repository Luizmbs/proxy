package org.example;

import java.util.Arrays;
import java.util.List;

public class MemberRecord implements Member {

    private Integer codigo;
    private String nome;
    private String cidade;
    private String livro1;
    private String livro2;

    public MemberRecord(int codigo) {
        this.codigo = codigo;
        MemberRecord objeto = Database.getMember(codigo);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.livro1 = objeto.livro1;
        this.livro2 = objeto.livro2;
    }

    public MemberRecord(Integer codigo, String nome, String cidade, String livro1, String livro2) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.livro1 = livro1;
        this.livro2 = livro2;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<String> obterHistorico(Employee funcionario) {
        return Arrays.asList(this.livro1, this.livro2);
    }
}
