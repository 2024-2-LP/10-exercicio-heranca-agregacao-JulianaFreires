package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor{
    private String plataforma;
    private String linguagem;
    private Integer horasPrototipacao;

    public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora, Integer horasPrototipacao, String plataforma, String linguagem) {
        super(nome, qtdHoras, valorHora);
        this.horasPrototipacao = horasPrototipacao;
        this.plataforma = plataforma;
        this.linguagem = linguagem;
    }

    public DesenvolvedorMobile() {
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasPrototipacao) {
        this.horasPrototipacao = horasPrototipacao;
    }


    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + horasPrototipacao * 200.00;
    }
}



