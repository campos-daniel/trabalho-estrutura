public class Main {

    public static void main(String[] args) {

        System.out.println("===== CADASTRO DE PACIENTES =====");

        CadastroPacientes cadastro = new CadastroPacientes();

        cadastro.inserirPaciente(50, "Carlos");
        cadastro.inserirPaciente(30, "Ana");
        cadastro.inserirPaciente(70, "João");
        cadastro.inserirPaciente(20, "Maria");
        cadastro.inserirPaciente(40, "Pedro");
        cadastro.inserirPaciente(60, "Lucas");
        cadastro.inserirPaciente(80, "Julia");

        System.out.println("\n--- Todos os pacientes ---");
        cadastro.listarPacientes();

        System.out.println("--- Busca de paciente ---");

        Paciente joao = cadastro.buscarPaciente(70);

        if (joao != null) {
            System.out.println("Paciente encontrado: " + joao.getNome());
        } else {
            System.out.println("Paciente não encontrado.");
        }




        System.out.println("\n===== PRONTUÁRIO MÉDICO =====");


        joao.getProntuario().adicionarConsulta(
                "10/01/2026",
                "Dr. Carlos",
                "Paciente relatou dores de cabeça."
        );

        joao.getProntuario().adicionarConsulta(
                "20/02/2026",
                "Dra. Ana",
                "Paciente retornou com melhora."
        );

        joao.getProntuario().adicionarConsulta(
                "15/03/2026",
                "Dr. João",
                "Exames solicitados."
        );

        System.out.println("\n--- Histórico de João ---");
        joao.getProntuario().exibirHistorico();


        System.out.println("--- Busca de consulta ---");

        Consulta consultaEncontrada =
                joao.getProntuario().buscarConsulta("20/02/2026");

        if (consultaEncontrada != null) {
            System.out.println("Consulta encontrada: "
                    + consultaEncontrada.getProntuario());
        }

        System.out.println("\n--- Removendo consulta ---");

        boolean removida =
                joao.getProntuario().removerConsulta("10/01/2026");

        if (removida) {
            System.out.println("Consulta removida com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }

        joao.getProntuario().exibirHistorico();


        System.out.println("\n===== FILA DE EMERGÊNCIA =====");

        FilaEmergencia fila = new FilaEmergencia(5);

        fila.adicionarPaciente(new Paciente(101, "Roberto"));
        fila.adicionarPaciente(new Paciente(102, "Fernanda"));
        fila.adicionarPaciente(new Paciente(103, "Marcos"));

        System.out.println("\n--- Pacientes aguardando ---");
        fila.listarPacientes();

        System.out.println("\n--- Chamando paciente ---");

        Paciente chamado = fila.chamarPaciente();

        System.out.println("Paciente chamado: " + chamado.getNome());

        System.out.println("\n--- Fila atualizada ---");
        fila.listarPacientes();

        System.out.println("\nQuantidade aguardando: " + fila.tamanho());

        System.out.println("Fila vazia? " + fila.estaVazia());
        System.out.println("Fila cheia? " + fila.estaCheia());
    }
}
