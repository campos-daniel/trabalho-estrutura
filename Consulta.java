public class Consulta {

    private String data;
    private String medico;
    private String prontuario;
    private Consulta proximaConsulta;

    public Consulta(String data, String medico, String prontuario) {
        this.data = data;
        this.medico = medico;
        this.prontuario = prontuario;
        this.proximaConsulta = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Consulta getProximaConsulta() {
        return proximaConsulta;
    }

    public void setProximaConsulta(Consulta proximaConsulta) {
        this.proximaConsulta = proximaConsulta;
    }
}