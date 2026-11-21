package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MemberProxyTest {

    @Test
    void deveRetornarDadosPessoaisSocio() {
        Database.addMember(new MemberRecord(1, "Marco", "Juiz de Fora", "Livro A", "Livro B"));
        MemberProxy socio = new MemberProxy(1);

        assertEquals(Arrays.asList("Marco", "Juiz de Fora"), socio.obterDadosPessoais());
    }

    @Test
    void deveRetornarHistoricoSocio() {
        Database.addMember(new MemberRecord(2, "Ana", "Juiz de Fora", "Livro C", "Livro D"));
        Employee funcionario = new Employee("Joana", true);
        MemberProxy socio = new MemberProxy(2);

        assertEquals(Arrays.asList("Livro C", "Livro D"), socio.obterHistorico(funcionario));
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizadoConsultarHistoricoSocio() {
        try {
            Database.addMember(new MemberRecord(2, "Ana", "Juiz de Fora", "Livro C", "Livro D"));
            Employee funcionario = new Employee("Pedro", false);
            MemberProxy socio = new MemberProxy(2);

            socio.obterHistorico(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}
