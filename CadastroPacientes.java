
public class CadastroPacientes {

    private Paciente raiz;

    public void inserirPaciente(int id, String nome) {

        Paciente novoPaciente = new Paciente(id, nome);

        if (raiz == null) {
            raiz = novoPaciente;
        } else {
            inserirRecursivo(raiz, novoPaciente);
        }
    }

    private void inserirRecursivo(Paciente atual, Paciente novoPaciente) {

        if (novoPaciente.getId() < atual.getId()) {

            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoPaciente);
            } else {
                inserirRecursivo(atual.getEsquerda(), novoPaciente);
            }

        } else if (novoPaciente.getId() > atual.getId()) {

            if (atual.getDireita() == null) {
                atual.setDireita(novoPaciente);
            } else {
                inserirRecursivo(atual.getDireita(), novoPaciente);
            }

        } else {
            System.out.println("ID de paciente já cadastrado.");
        }
    }

    public Paciente buscarPaciente(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Paciente buscarRecursivo(Paciente atual, int id) {

        if (atual == null) {
            return null;
        }

        if (id == atual.getId()) {
            return atual;

        } else if (id < atual.getId()) {
            return buscarRecursivo(atual.getEsquerda(), id);

        } else {
            return buscarRecursivo(atual.getDireita(), id);
        }
    }

    public void listarPacientes() {
        listarEmOrdem(raiz);
    }

    private void listarEmOrdem(Paciente atual) {

        if (atual != null) {

            listarEmOrdem(atual.getEsquerda());

            System.out.println("ID: " + atual.getId());
            System.out.println("Nome: " + atual.getNome());
            System.out.println();

            listarEmOrdem(atual.getDireita());
        }
    }
}
