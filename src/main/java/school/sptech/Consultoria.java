package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;


    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        Integer cont = 0;

        if(desenvolvedores.size() < vagas ){

            desenvolvedores.add(desenvolvedor);
        }
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){

        Boolean conferir = false;
        if(desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
            conferir = true;
        }

        return conferir;

    }

    public Double getTotalSalarios(){
        Double total = 0.0;
        for(int i = 0; i < desenvolvedores.size(); i++){

            Desenvolvedor desenvolvedorDaVez = desenvolvedores.get(i);

            total += desenvolvedorDaVez.calcularSalario();
        }

        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){

        Integer total = 0;

        for(int i = 0; i < desenvolvedores.size(); i++){

            Desenvolvedor desenvolvedorDaVez = desenvolvedores.get(i);

            if(desenvolvedorDaVez instanceof DesenvolvedorMobile){
                total++;
            }

        }
        return total;

    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){

        List<Desenvolvedor> achados = new ArrayList<>();

        for(int i = 0; i < desenvolvedores.size(); i++) {

            Desenvolvedor desenvolvedorDaVez = desenvolvedores.get(i);

            if (desenvolvedorDaVez.calcularSalario() >= salario) {
                achados.add(desenvolvedorDaVez);

            }
        }

        return achados;
    }

    public Desenvolvedor buscarMenorSalario(){

        if( desenvolvedores.isEmpty()){
            return null;

        }else{
            Desenvolvedor menor = desenvolvedores.get(0);

            for(int i = 0; i < desenvolvedores.size(); i++) {

                Desenvolvedor desenvolvedorDaVez = desenvolvedores.get(i);

                if (desenvolvedorDaVez.calcularSalario() < menor.calcularSalario()) {

                    menor = desenvolvedorDaVez;

                }
            }

            return menor;
        }

    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){

        List<Desenvolvedor> achados = new ArrayList<>();

        for(int i = 0; i < desenvolvedores.size(); i++) {

            Desenvolvedor desenvolvedorDaVez = desenvolvedores.get(i);

            if(desenvolvedorDaVez instanceof DesenvolvedorMobile){
              if(((DesenvolvedorMobile) desenvolvedorDaVez).getLinguagem().equals(tecnologia) || ((DesenvolvedorMobile) desenvolvedorDaVez).getPlataforma().equals(tecnologia)){

                  achados.add(desenvolvedorDaVez);

                }
            }

            if(desenvolvedorDaVez instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) desenvolvedorDaVez).getSgbd().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedorDaVez).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedorDaVez).getFrontend().equals(tecnologia)){

                    achados.add(desenvolvedorDaVez);

                }
            }

        }
        return achados;

    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){

        List<Desenvolvedor> devs = buscarPorTecnologia(tecnologia);

        Double total = 0.0;

        for(int i = 0; i < devs.size(); i++) {

            Desenvolvedor desenvolvedorDaVez = devs.get(i);

            total += desenvolvedorDaVez.calcularSalario();

        }

        return total;




    }

}
