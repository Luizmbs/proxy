package org.example;

import java.util.List;

public class MemberProxy implements Member {

    private MemberRecord socio;

    private Integer codigo;

    public MemberProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.socio == null) {
            this.socio = new MemberRecord(this.codigo);
        }
        return this.socio.obterDadosPessoais();
    }

    @Override
    public List<String> obterHistorico(Employee funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.socio == null) {
            this.socio = new MemberRecord(this.codigo);
        }
        return this.socio.obterHistorico(funcionario);
    }
}
