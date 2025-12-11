package Aula06_10.Exemplo01;

public class Fila {

    private Elemento inicio;

    public void enfileirar(Paciente paciente) {
        if (this.inicio == null) {
            this.inicio = new Elemento(paciente);
        } else {
            Elemento e = this.inicio;
            while (e.getProximo() != null) {
                e = e.getProximo();
            }
            e.setProximo(new Elemento(paciente));
        }
    }

    public Paciente desenfileirar() {
        if (this.inicio == null) {
            return null;
        } else {
            Elemento e = this.inicio;
            this.inicio = e.getProximo();
            return e.getPaciente();
        }

    }

    public void listar() {
        int pos = 1;
        if (this.inicio == null) {
            System.out.println("A fila está vazia");
        } else {
            Elemento e = this.inicio;
            System.out.println("POSICAO:" + pos + "\n" + e.toString() + "\n");
            while (e.getProximo() != null) {
                pos++;
                e = e.getProximo();
                System.out.println("POSICAO:" + pos + "\n" + e.toString() + "\n");
            }
        }
    }

    public void mostraPosicao(String info) {
        if (this.inicio == null) {
            System.out.println("A fila está vazia");
        } else {
            Elemento e = this.inicio;
            int pos = 1;
            boolean encontrado = false;

            while (e != null) {
                Paciente pac = e.getPaciente();
                if (pac.getCpf().equals(info)) {
                    System.out.println("Paciente encontrado na posição: " + pos);
                    System.out.println(pac.toString());
                    encontrado = true;
                    break;
                }
                e = e.getProximo();
                pos++;
            }

            if (!encontrado) {
                System.out.println("Paciente com CPF " + info + " não está na fila");
            }
        }
    }

    public void filaPrioritaria(Paciente paciente) {
        Elemento novo = new Elemento(paciente);

        if (inicio == null) {
            inicio = novo;
            return;
        }

        if (paciente.getIdade() >= 60) {
            Elemento atual = inicio;
            Elemento anteriorUltimoIdoso = null;

            while (atual != null) {
                if (atual.getPaciente().getIdade() >= 60) {
                    anteriorUltimoIdoso = atual;
                }
                atual = atual.getProximo();
            }

            if (anteriorUltimoIdoso == null) {
                novo.setProximo(inicio);
                inicio = novo;
            } else {
                novo.setProximo(anteriorUltimoIdoso.getProximo());
                anteriorUltimoIdoso.setProximo(novo);
            }

        } else {
            Elemento atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
    }

}
