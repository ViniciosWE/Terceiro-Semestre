package minhaPrimeiraTela;

import jexer.*;
import jexer.event.TMenuEvent;
import jexer.menu.TMenu;
import minhaprimeiratela.ControllerOuvintes;
import minhaprimeiratela.Ouvintes;

public class minhaPrimeiraTela extends TApplication {

    public minhaPrimeiraTela() throws Exception {
        super(TApplication.BackendType.SWING);
        criarMenu();
        Principal();
    }

    public void Principal() {
        TMenu tileMenu = addMenu("&Gerenciamento");
        tileMenu.addItem(5000, "&Sair");
    }

    private void criarMenu() {
        TMenu menu = addMenu("&Ouvintes");
        menu.addItem(1000, "&Adicionar");
        menu.addItem(1001, "&Excluir");
        menu.addItem(1002, "&Alterar");
    }

    private void abrirJanela(String acao) {
        TWindow window = new TWindow(this, acao + " Usuário", 50, 15);

        window.addLabel("ID:", 2, 2);
        TField idField = new TField(window, 8, 2, 10, true);

        TField nomeField = null;
        TField emailField = null;

        // Mostrar nome e email somente para Adicionar e Alterar
        if (!acao.equals("Excluir")) {
            window.addLabel("Nome:", 2, 4);
            nomeField = new TField(window, 8, 4, 30, true);

            window.addLabel("Email:", 2, 6);
            emailField = new TField(window, 8, 6, 30, true);
        }

        TField finalNomeField = nomeField;
        TField finalEmailField = emailField;

        window.addButton("Confirmar", 10, 10, new TAction() {
            public void DO() {
                String idText = idField.getText().trim();
                String nome = finalNomeField != null ? finalNomeField.getText().trim() : "";
                String email = finalEmailField != null ? finalEmailField.getText().trim() : "";

                ControllerOuvintes controller = new ControllerOuvintes();

                try {
                    if (acao.equals("Adicionar")) {
                        if (nome.isEmpty() || email.isEmpty()) {
                            messageBox("Erro", "Nome e Email são obrigatórios para adicionar.");
                            return;
                        }
                        Ouvintes ouv = new Ouvintes();
                        ouv.setNome(nome);
                        ouv.setEmail(email);
                        controller.inserirOuvinte(ouv);
                        messageBox("Sucesso", "Inclusão realizada com sucesso!");
                    } else if (acao.equals("Excluir")) {
                        if (idText.isEmpty()) {
                            messageBox("Erro", "ID é obrigatório para excluir.");
                            return;
                        }
                        int id = Integer.parseInt(idText);
                        controller.excluirOuvinte(id);
                        messageBox("Sucesso", "Exclusão realizada com sucesso!");
                    } else if (acao.equals("Alterar")) {
                        if (idText.isEmpty() || nome.isEmpty() || email.isEmpty()) {
                            messageBox("Erro", "ID, Nome e Email são obrigatórios para alterar.");
                            return;
                        }
                        int id = Integer.parseInt(idText);
                        if (!controller.existeId(id)) {
                            messageBox("Erro", "ID informado não existe no banco.");
                            return;
                        }
                        Ouvintes ouv = new Ouvintes();
                        ouv.setId(id);
                        ouv.setNome(nome);
                        ouv.setEmail(email);
                        controller.alterarOuvinte(ouv);
                        messageBox("Sucesso", "Alteração realizada com sucesso!");
                    }
                } catch (NumberFormatException e) {
                    messageBox("Erro", "ID inválido, deve ser um número.");
                } catch (Exception e) {
                    messageBox("Erro", "Erro inesperado: " + e.getMessage());
                }
                closeWindow(window);
            }
        });

        window.addButton("Cancelar", 30, 10, new TAction() {
            public void DO() {
                closeWindow(window);
            }
        });
    }

    @Override
    public boolean onMenu(TMenuEvent event) {
        switch (event.getId()) {
            case 1000:
                abrirJanela("Adicionar");
                return true;
            case 1001:
                abrirJanela("Excluir");
                return true;
            case 1002:
                abrirJanela("Alterar");
                return true;
            case 5000:
                System.out.println("Saindo");
                exit();
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        minhaPrimeiraTela app = new minhaPrimeiraTela();
        app.run();
    }
}
