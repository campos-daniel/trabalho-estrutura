public class Paciente {

    private int id;
    private String nome;
    private HistoricoMedico prontuario;

    private Paciente esquerda;
    private Paciente direita;

    public Paciente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.prontuario = new HistoricoMedico();
        this.esquerda = null;
        this.direita = null;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public HistoricoMedico getProntuario() {
        return prontuario;
    }

    public Paciente getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Paciente esquerda) {
        this.esquerda = esquerda;
    }

    public Paciente getDireita() {
        return direita;
    }

    public void setDireita(Paciente direita) {
        this.direita = direita;
    }
}
