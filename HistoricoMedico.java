public class HistoricoMedico {

    private Consulta primeiraConsulta;
    private Consulta ultimaConsulta;

    public void adicionarConsulta(String data, String medico, String prontuario) {
        Consulta novaConsulta = new Consulta(data, medico, prontuario);

        if (primeiraConsulta == null) {
            this.primeiraConsulta = novaConsulta;
            this.ultimaConsulta = novaConsulta;
        } else {
            this.ultimaConsulta.setProximaConsulta(novaConsulta);
            this.ultimaConsulta = novaConsulta;
        }
    }

    public void exibirHistorico() {
        if (primeiraConsulta == null) {
            System.out.println("Não há consultas registradas.");
        } else {
            Consulta alvo = primeiraConsulta;

            while (alvo != null) {
                System.out.println("Data: " + alvo.getData());
                System.out.println("Médico: " + alvo.getMedico());
                System.out.println("Prontuário: " + alvo.getProntuario());
                System.out.println();

                alvo = alvo.getProximaConsulta();
            }
        }
    }

    public Consulta buscarConsulta(String data) {
        Consulta alvo = primeiraConsulta;

        while (alvo != null) {
            if (alvo.getData().equals(data)) {
                return alvo;
            } else {
                alvo = alvo.getProximaConsulta();
            }
        }

        System.out.println("Consulta não encontrada.");
        return null;
    }

    public boolean removerConsulta(String data) {
        if (primeiraConsulta == null) {
            return false;
        }

        if (primeiraConsulta.getData().equals(data)) {
            primeiraConsulta = primeiraConsulta.getProximaConsulta();

            if (primeiraConsulta == null) {
                ultimaConsulta = null;
            }

            return true;
        }

        Consulta consultaAnterior = primeiraConsulta;
        Consulta consultaAlvo = consultaAnterior.getProximaConsulta();

        while (consultaAlvo != null) {
            if (consultaAlvo.getData().equals(data)) {
                consultaAnterior.setProximaConsulta(
                        consultaAlvo.getProximaConsulta()
                );

                if (consultaAlvo == ultimaConsulta) {
                    ultimaConsulta = consultaAnterior;
                }

                return true;
            }

            consultaAnterior = consultaAlvo;
            consultaAlvo = consultaAlvo.getProximaConsulta();
        }

        return false;
    }
}