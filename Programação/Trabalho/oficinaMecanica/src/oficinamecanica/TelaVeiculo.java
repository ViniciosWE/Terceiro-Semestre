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

public class TelaVeiculo extends TApplication {

    ControllerVeiculo controller = new ControllerVeiculo();
    TComboBox comboBox = null;

    public TelaVeiculo() throws Exception {
        super(TApplication.BackendType.SWING);
        menuVeiculo();
        menuSair();
    }

    private void menuVeiculo() {
        TMenu menu = addMenu("&Veículo");
        menu.addItem(2000, "Incluir Veículo");
        menu.addSeparator();
        menu.addItem(2001, "Alterar Veículo");
        menu.addSeparator();
        menu.addItem(2002, "Excluir Veículo");
        menu.addSeparator();
        menu.addItem(2003, "Listar Veículos");
    }

    private void menuSair() {
        TMenu menu = addMenu("&Sistema");
        menu.addItem(9999, "Sair");
    }

    @Override
    public boolean onMenu(TMenuEvent event) {
        switch (event.getId()) {
            case 2000:
                telaCadastrarVeiculo();
                return true;
            case 2001:
                telaAlterarVeiculo();
                return true;
            case 2002:
                telaExcluirVeiculo();
                return true;
            case 2003:
                telaListarVeiculos();
                return true;
            case 9999:
                exit();
                return true;
            default:
                return false;
        }
    }

    private void telaCadastrarVeiculo() {
        TWindow window = new TWindow(this, "Cadastrar Veículo", 60, 18);

        window.addLabel("Placa:", 1, 2);
        TField placa = new TField(window, 12, 2, 15, true, "");

        window.addLabel("Modelo:", 1, 4);
        TField modelo = new TField(window, 12, 4, 25, true, "");

        window.addLabel("ID Cliente:", 1, 6);
        TField idCliente = new TField(window, 12, 6, 10, true, "");

        window.addButton("Incluir", 10, 10, new TAction() {
            public void DO() {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(placa.getText());
                veiculo.setModelo(modelo.getText());
                try {
                    veiculo.setIdCliente(Integer.parseInt(idCliente.getText()));
                    controller.inserirVeiculo(veiculo);
                    window.getApplication().messageBox("Sucesso", "Veículo incluído com sucesso!");
                } catch (NumberFormatException e) {
                    window.getApplication().messageBox("Erro", "ID Cliente inválido!");
                }
            }
        });

        window.addButton("Fechar", 25, 10, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    private void telaAlterarVeiculo() {
        TWindow window = new TWindow(this, "Alterar Veículo", 60, 22);

        window.addLabel("ID:", 1, 8);
        TField id = new TField(window, 12, 8, 10, true, "");

        window.addLabel("Placa:", 1, 10);
        TField placa = new TField(window, 12, 10, 15, true, "");

        window.addLabel("Modelo:", 1, 12);
        TField modelo = new TField(window, 12, 12, 25, true, "");

        window.addLabel("ID Cliente:", 1, 14);
        TField idCliente = new TField(window, 12, 14, 10, true, "");

        List<String> placasVeiculos = new ArrayList<>();
        for (Veiculo v : controller.listarVeiculos()) {
            placasVeiculos.add(v.getPlaca());
        }

        window.addLabel("Selecionar Placa:", 1, 4);
        comboBox = new TComboBox(window, 18, 4, 15, placasVeiculos, 0, 5, new TAction() {
            public void DO() {
                Veiculo veiculo = controller.buscarVeiculoPorPlaca(comboBox.getText());
                if (veiculo != null) {
                    id.setText("" + veiculo.getId());
                    placa.setText(veiculo.getPlaca());
                    modelo.setText(veiculo.getModelo());
                    idCliente.setText("" + veiculo.getIdCliente());
                }
            }
        });

        window.addButton("Alterar", 10, 18, new TAction() {
            public void DO() {
                try {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setId(Integer.parseInt(id.getText()));
                    veiculo.setPlaca(placa.getText());
                    veiculo.setModelo(modelo.getText());
                    veiculo.setIdCliente(Integer.parseInt(idCliente.getText()));
                    controller.alterarVeiculo(veiculo);
                    window.getApplication().messageBox("Sucesso", "Veículo alterado com sucesso!");
                } catch (NumberFormatException e) {
                    window.getApplication().messageBox("Erro", "ID ou ID Cliente inválido!");
                }
            }
        });

        window.addButton("Fechar", 25, 18, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    private void telaExcluirVeiculo() {
        TWindow window = new TWindow(this, "Excluir Veículo", 50, 15);

        List<String> placasVeiculos = new ArrayList<>();
        for (Veiculo v : controller.listarVeiculos()) {
            placasVeiculos.add(v.getPlaca());
        }

        window.addLabel("Selecionar Placa:", 1, 2);
        comboBox = new TComboBox(window, 18, 2, 15, placasVeiculos, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                String placaSelecionada = comboBox.getText();
                Veiculo veiculo = controller.buscarVeiculoPorPlaca(placaSelecionada);
                if (veiculo != null) {
                    controller.excluirVeiculo(veiculo.getId());
                    window.getApplication().messageBox("Sucesso", "Veículo excluído com sucesso!");
                    window.getApplication().closeWindow(window);
                } else {
                    window.getApplication().messageBox("Erro", "Veículo não encontrado!");
                }
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    private void telaListarVeiculos() {
        TWindow window = new TWindow(this, "Lista de Veículos", 70, 20);

        List<Veiculo> veiculos = controller.listarVeiculos();

        int linha = 2;
        window.addLabel("ID", 1, 1);
        window.addLabel("Placa", 6, 1);
        window.addLabel("Modelo", 25, 1);
        window.addLabel("ID Cliente", 50, 1);

        for (Veiculo v : veiculos) {
            window.addLabel("" + v.getId(), 1, linha);
            window.addLabel(v.getPlaca(), 6, linha);
            window.addLabel(v.getModelo(), 25, linha);
            window.addLabel("" + v.getIdCliente(), 50, linha);
            linha++;
        }

        window.addButton("Fechar", 25, linha + 2, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }
}
