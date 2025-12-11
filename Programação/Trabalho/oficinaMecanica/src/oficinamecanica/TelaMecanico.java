package oficinamecanica;

import java.util.ArrayList;
import java.util.List;
import jexer.TAction;
import jexer.TApplication;
import jexer.TComboBox;
import jexer.TField;
import jexer.TWindow;
import jexer.event.TMenuEvent;
import jexer.menu.TMenu;

public class TelaMecanico extends TApplication {

    ControllerMecanico controller = new ControllerMecanico();
    TComboBox comboBox = null;

    public TelaMecanico() throws Exception {
        super(TApplication.BackendType.SWING);
        menuMecanico();
        menuSair();
    }

    private void menuMecanico() {
        TMenu menu = addMenu("&Mecânico");
        menu.addItem(1100, "Incluir Mecânico");
        menu.addSeparator();
        menu.addItem(1101, "Alterar Mecânico");
        menu.addSeparator();
        menu.addItem(1102, "Excluir Mecânico");
        menu.addSeparator();
        menu.addItem(1103, "Listar Mecânicos");
    }

    private void menuSair() {
        TMenu menu = addMenu("&Sistema");
        menu.addItem(9999, "Sair");
    }

    @Override
    public boolean onMenu(TMenuEvent event) {
        switch (event.getId()) {
            case 1100:
                telaCadastrarMecanico();
                return true;
            case 1101:
                telaAlterarMecanico();
                return true;
            case 1102:
                telaExcluirMecanico();
                return true;
            case 1103:
                telaListarMecanicos();
                return true;
            case 9999:
                exit();
                return true;
            default:
                return false;
        }
    }

    private void telaCadastrarMecanico() {
        TWindow window = new TWindow(this, "Cadastrar Mecânico", 50, 15);

        window.addLabel("Nome:", 1, 2);
        TField nome = new TField(window, 10, 2, 30, true, "");

        window.addButton("Incluir", 10, 6, new TAction() {
            public void DO() {
                Mecanico mecanico = new Mecanico();
                mecanico.setNome(nome.getText());
                controller.inserirMecanico(mecanico);
                window.getApplication().messageBox("Sucesso", "Mecânico incluído com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    private void telaAlterarMecanico() {
        TWindow window = new TWindow(this, "Alterar Mecânico", 50, 20);

        window.addLabel("ID:", 1, 6);
        TField id = new TField(window, 10, 6, 10, true, "");

        window.addLabel("Nome:", 1, 8);
        TField nome = new TField(window, 10, 8, 30, true, "");

        List<String> nomesMecanicos = new ArrayList<>();
        for (Mecanico m : controller.listarMecanicos()) {
            nomesMecanicos.add(m.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesMecanicos, 0, 5, new TAction() {
            public void DO() {
                Mecanico mecanico = controller.buscarMecanicoPorNome(comboBox.getText());
                if (mecanico != null) {
                    id.setText("" + mecanico.getId());
                    nome.setText(mecanico.getNome());
                }
            }
        });

        window.addButton("Alterar", 10, 12, new TAction() {
            public void DO() {
                try {
                    Mecanico mecanico = new Mecanico();
                    mecanico.setId(Integer.parseInt(id.getText()));
                    mecanico.setNome(nome.getText());
                    controller.alterarMecanico(mecanico);
                    window.getApplication().messageBox("Sucesso", "Mecânico alterado com sucesso!");
                } catch (NumberFormatException e) {
                    window.getApplication().messageBox("Erro", "ID inválido!");
                }
            }
        });

        window.addButton("Fechar", 25, 12, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    private void telaExcluirMecanico() {
        TWindow window = new TWindow(this, "Excluir Mecânico", 50, 15);

        List<String> nomesMecanicos = new ArrayList<>();
        for (Mecanico m : controller.listarMecanicos()) {
            nomesMecanicos.add(m.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesMecanicos, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                String nomeSelecionado = comboBox.getText();
                Mecanico mecanico = controller.buscarMecanicoPorNome(nomeSelecionado);
                if (mecanico != null) {
                    controller.excluirMecanico(mecanico.getId());
                    window.getApplication().messageBox("Sucesso", "Mecânico excluído com sucesso!");
                    window.getApplication().closeWindow(window);
                } else {
                    window.getApplication().messageBox("Erro", "Mecânico não encontrado!");
                }
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    private void telaListarMecanicos() {
        TWindow window = new TWindow(this, "Lista de Mecânicos", 60, 20);

        List<Mecanico> mecanicos = controller.listarMecanicos();

        int linha = 2;
        window.addLabel("ID", 1, 1);
        window.addLabel("Nome", 6, 1);

        for (Mecanico m : mecanicos) {
            window.addLabel("" + m.getId(), 1, linha);
            window.addLabel(m.getNome(), 6, linha);
            linha++;
        }

        window.addButton("Fechar", 25, linha + 2, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }
}
