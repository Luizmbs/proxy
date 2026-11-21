package org.example;

import java.util.List;

public interface Member {
    List<String> obterDadosPessoais();
    List<String> obterHistorico(Employee funcionario);
}
