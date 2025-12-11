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

public class TelaPrincipal extends TApplication {

    ControllerCliente controllerCliente = new ControllerCliente();
    ControllerMecanico controllerMecanico = new ControllerMecanico();
    ControllerServico controllerServico = new ControllerServico();
    ControllerOrdemServico controllerOrdemServico = new ControllerOrdemServico();
    ControllerVeiculo controllerVeiculo = new ControllerVeiculo();
    ControllerServicoRealizado controllerServicoRealizado = new ControllerServicoRealizado();
    TComboBox comboBox;

    public TelaPrincipal() throws Exception {
        super(TApplication.BackendType.SWING);
        menuAdd();
        menuAlt();
        menuExc();
        gerarRelatorio();
        menuSair();
    }

    public void menuAdd() {
        TMenu menu = addMenu("&Incluir");
        menu.addItem(1000, "Cliente");
        menu.addSeparator();
        menu.addItem(1001, "Mecânico");
        menu.addSeparator();
        menu.addItem(1002, "Veiculo");
        menu.addSeparator();
        menu.addItem(1003, "Serviço");
        menu.addSeparator();
        menu.addItem(1004, "Ordem Serviço");
        menu.addSeparator();
        menu.addItem(1005, "Serviço Realizado");
    }

    public void menuAlt() {
        TMenu menu = addMenu("&Alterar");
        menu.addItem(2000, "Cliente");
        menu.addSeparator();
        menu.addItem(2001, "Mecânico");
        menu.addSeparator();
        menu.addItem(2002, "Veiculo");
        menu.addSeparator();
        menu.addItem(2003, "Serviço");
        menu.addSeparator();
        menu.addItem(2004, "Ordem Serviço");
        menu.addSeparator();
        menu.addItem(2005, "Serviço Realizado");
    }

    public void menuExc() {
        TMenu menu = addMenu("&Excluir");
        menu.addItem(3000, "Cliente");
        menu.addSeparator();
        menu.addItem(3001, "Mecânico");
        menu.addSeparator();
        menu.addItem(3002, "Veiculo");
        menu.addSeparator();
        menu.addItem(3003, "Serviço");
        menu.addSeparator();
        menu.addItem(3004, "Ordem Serviço");
        menu.addSeparator();
        menu.addItem(3005, "Serviço Realizado");
    }

    private void gerarRelatorio() {
        TMenu menu = addMenu("&Relatórios");
        menu.addItem(4000, "Clientes");
        menu.addSeparator();
        menu.addItem(4001, "Mecânico");
        menu.addSeparator();
        menu.addItem(4002, "Veiculo");
        menu.addSeparator();
        menu.addItem(4003, "Serviço");
        menu.addSeparator();
        menu.addItem(4004, "OrdemServiço");
        menu.addSeparator();
        menu.addItem(4005, "Serviço Realizado");
        menu.addSeparator();
        menu.addItem(4006, "Relatorio Final Completo");
        
    }

    private void menuSair() {
        TMenu menu = addMenu("&Sistema");
        menu.addItem(9999, "Sair");
    }

    @Override
    public boolean onMenu(TMenuEvent event) {
        switch (event.getId()) {
            // PARTE DE ADICIONAR 
            case 1000:
                telaCadastrarCliente();
                return true;
            case 1001:
                telaCadastrarMecanico();
                return true;
            case 1002:
                telaCadastrarVeiculo();
                return true;
            case 1003:
                telaCadastrarServico();
                return true;
            case 1004:
                telaCadastrarOrdemServico();
                return true;
            case 1005:
                telaCadastrarServicoRealizado();
                return true;
            // PARTE DE ALTERAR
            case 2000:
                telaAlterarCliente();
                return true;
            case 2001:
                telaAlterarMecanico();
                return true;
            case 2002:
                telaAlterarVeiculo();
                return true;
            case 2003:
                telaAlterarServico();
                return true;
            case 2004:
                telaAlterarOrdemServico();
                return true;
            case 2005:
                telaAlterarServicoRealizado();
                return true;
            //PARTE DE EXCLUIR
            case 3000:
                telaExcluirCliente();
                return true;
            case 3001:
                telaExcluirMecanico();
                return true;
            case 3002:
                telaExcluirVeiculo();
                return true;
            case 3003:
                telaExcluirServico();
                return true;
            case 3004:
                telaExcluirOrdemServico();
                return true;
            case 3005:
                telaExcluirServicoRealizado();
                return true;
            //PARTE DE RELATóRIOS
            case 4000:
                Relatorios r = new Relatorios();
                r.relatorioCliente();
                return true;
            case 4001:
                Relatorios m = new Relatorios();
                m.relatorioMecanico();
                return true;
            case 4002:
                Relatorios v = new Relatorios();
                v.relatorioVeiculo();
                return true;
            case 4003:
                Relatorios s = new Relatorios();
                s.relatorioServico();
                return true;
            case 4004:
                Relatorios os = new Relatorios();
                os.relatorioOrdemServico();
                return true;
            case 4005:
                Relatorios sr = new Relatorios();
                sr.relatorioServicoRealizado();
                return true;
            case 4006:
                escolherServicoFinal();
                return true;
            // PARTE DO SISTEMA SAIR
            case 9999:
                exit();
                return true;

            default:
                return false;
        }
    }

    // CLIENTES
    public void telaCadastrarCliente() {
        TWindow window = new TWindow(this, "Cadastrar Cliente", 50, 15);

        window.addLabel("Nome:", 1, 2);
        TField nome = new TField(window, 10, 2, 30, true, "");

        window.addLabel("Telefone:", 1, 4);
        TField telefone = new TField(window, 10, 4, 30, true, "");

        window.addButton("Incluir", 10, 8, new TAction() {
            public void DO() {
                Cliente cliente = new Cliente();
                cliente.setNome(nome.getText());
                cliente.setTelefone(telefone.getText());
                controllerCliente.inserirCliente(cliente);
                window.getApplication().messageBox("Sucesso", "Cliente cadastrado com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 8, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaAlterarCliente() {
        TWindow window = new TWindow(this, "Alterar Cliente", 50, 20);

        window.addLabel("ID:", 1, 6);
        TField id = new TField(window, 10, 6, 10, false, "");

        window.addLabel("Nome:", 1, 8);
        TField nome = new TField(window, 10, 8, 30, true, "");

        window.addLabel("Telefone:", 1, 10);
        TField telefone = new TField(window, 10, 10, 30, true, "");

        List<String> nomesClientes = new ArrayList<>();
        for (Cliente cliente : controllerCliente.listarClientes()) {
            nomesClientes.add(cliente.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesClientes, 0, 5, new TAction() {
            public void DO() {
                Cliente cliente = controllerCliente.buscarClientePorNome(comboBox.getText());
                if (cliente != null) {
                    id.setText("" + cliente.getId());
                    nome.setText(cliente.getNome());
                    telefone.setText(cliente.getTelefone());
                }
            }
        });

        window.addButton("Alterar", 10, 14, new TAction() {
            public void DO() {

                Cliente clienteOriginal = controllerCliente.buscarClientePorNome(comboBox.getText());
                int idDigitado = Integer.parseInt(id.getText());

                if (clienteOriginal.getId() != idDigitado) {
                    window.getApplication().messageBox("Erro", "O ID não pode ser alterado!");
                    return;
                }

                Cliente clienteAlterado = new Cliente();
                clienteAlterado.setId(idDigitado);
                clienteAlterado.setNome(nome.getText());
                clienteAlterado.setTelefone(telefone.getText());

                controllerCliente.alterarCliente(clienteAlterado);
                window.getApplication().messageBox("Sucesso", "Cliente alterado com sucesso!");

            }
        });

        window.addButton("Fechar", 25, 14, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaExcluirCliente() {
        TWindow window = new TWindow(this, "Excluir Cliente", 50, 15);

        List<String> nomesClientes = new ArrayList<>();
        for (Cliente cliente : controllerCliente.listarClientes()) {
            nomesClientes.add(cliente.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesClientes, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                String nomeSelecionado = comboBox.getText();
                Cliente cliente = controllerCliente.buscarClientePorNome(nomeSelecionado);
                if (cliente != null) {
                    controllerCliente.excluirCliente(cliente.getId());
                    window.getApplication().messageBox("Sucesso", "Cliente excluído com sucesso!");
                    window.getApplication().closeWindow(window);
                } else {
                    window.getApplication().messageBox("Erro", "Cliente não encontrado!");
                }
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    // MECANICOS
    public void telaCadastrarMecanico() {
        TWindow window = new TWindow(this, "Cadastrar Mecânico", 50, 15);

        window.addLabel("Nome:", 1, 2);
        TField nome = new TField(window, 10, 2, 30, true, "");

        window.addButton("Incluir", 10, 6, new TAction() {
            public void DO() {
                Mecanico mecanico = new Mecanico();
                mecanico.setNome(nome.getText());
                controllerMecanico.inserirMecanico(mecanico);
                window.getApplication().messageBox("Sucesso", "Mecânico cadastrado com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaAlterarMecanico() {
        TWindow window = new TWindow(this, "Alterar Mecânico", 50, 20);

        window.addLabel("ID:", 1, 6);
        TField id = new TField(window, 10, 6, 10, false, "");

        window.addLabel("Nome:", 1, 8);
        TField nome = new TField(window, 10, 8, 30, true, "");

        List<String> nomesMecanicos = new ArrayList<>();
        for (Mecanico m : controllerMecanico.listarMecanicos()) {
            nomesMecanicos.add(m.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesMecanicos, 0, 5, new TAction() {
            public void DO() {
                Mecanico mecanico = controllerMecanico.buscarMecanicoPorNome(comboBox.getText());
                if (mecanico != null) {
                    id.setText("" + mecanico.getId());
                    nome.setText(mecanico.getNome());
                }
            }
        });

        window.addButton("Alterar", 10, 12, new TAction() {
            public void DO() {
                Mecanico mecanicoOriginal = controllerMecanico.buscarMecanicoPorNome(comboBox.getText());
                int idDigitado = Integer.parseInt(id.getText());

                if (mecanicoOriginal.getId() != idDigitado) {
                    window.getApplication().messageBox("Erro", "O ID não pode ser alterado!");
                    return;
                }

                Mecanico mecanicoAlterado = new Mecanico();
                mecanicoAlterado.setId(idDigitado);
                mecanicoAlterado.setNome(nome.getText());
                controllerMecanico.alterarMecanico(mecanicoAlterado);
                window.getApplication().messageBox("Sucesso", "Mecânico alterado com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 12, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaExcluirMecanico() {
        TWindow window = new TWindow(this, "Excluir Mecânico", 50, 15);

        List<String> nomesMecanicos = new ArrayList<>();
        for (Mecanico m : controllerMecanico.listarMecanicos()) {
            nomesMecanicos.add(m.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesMecanicos, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                String nomeSelecionado = comboBox.getText();
                Mecanico mecanico = controllerMecanico.buscarMecanicoPorNome(nomeSelecionado);
                if (mecanico != null) {
                    controllerMecanico.excluirMecanico(mecanico.getId());
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

    // VEICULO
    public void telaCadastrarVeiculo() {
        TWindow window = new TWindow(this, "Cadastrar Veículo", 60, 18);

        window.addLabel("Placa:", 1, 4);
        TField placa = new TField(window, 14, 4, 15, true, "");

        window.addLabel("Modelo:", 1, 6);
        TField modelo = new TField(window, 14, 6, 25, true, "");

        window.addLabel("ID Cliente:", 1, 8);
        TField idCliente = new TField(window, 14, 8, 10, true, "");

        window.addButton("Incluir", 10, 10, new TAction() {
            public void DO() {
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(placa.getText());
                veiculo.setModelo(modelo.getText());
                veiculo.setIdCliente(Integer.parseInt(idCliente.getText()));
                controllerVeiculo.inserirVeiculo(veiculo);
                window.getApplication().messageBox("Sucesso", "Veículo cadastrado com sucesso!");
            }
        });

        List<String> nomesClientes = new ArrayList<>();
        for (Cliente cliente : controllerCliente.listarClientes()) {
            nomesClientes.add(cliente.getNome());
        }

        window.addLabel("Cliente dono:", 1, 2);
        comboBox = new TComboBox(window, 14, 2, 30, nomesClientes, 0, 5, new TAction() {
            public void DO() {
                Cliente cliente = controllerCliente.buscarClientePorNome(comboBox.getText());
                if (cliente != null) {
                    idCliente.setText("" + cliente.getId());
                }
            }
        });

        window.addButton("Fechar", 25, 10, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaAlterarVeiculo() {
        TWindow window = new TWindow(this, "Alterar Veículo", 60, 22);

        window.addLabel("ID:", 1, 8);
        TField id = new TField(window, 12, 8, 10, false, "");

        window.addLabel("Placa:", 1, 10);
        TField placa = new TField(window, 12, 10, 15, true, "");

        window.addLabel("Modelo:", 1, 12);
        TField modelo = new TField(window, 12, 12, 25, true, "");

        window.addLabel("Cliente:", 1, 14);

        TField nomeCliente = new TField(window, 12, 14, 10, false, "");

        List<String> placasVeiculos = new ArrayList<>();
        for (Veiculo v : controllerVeiculo.listarVeiculos()) {
            placasVeiculos.add(v.getPlaca());
        }

        window.addLabel("Selecionar Placa:", 1, 4);
        comboBox = new TComboBox(window, 18, 4, 15, placasVeiculos, 0, 5, new TAction() {
            public void DO() {
                Veiculo veiculo = controllerVeiculo.buscarVeiculoPorPlaca(comboBox.getText());
                if (veiculo != null) {
                    id.setText("" + veiculo.getId());
                    placa.setText(veiculo.getPlaca());
                    modelo.setText(veiculo.getModelo());
                    nomeCliente.setText("" + veiculo.getNomeCliente());
                }
            }
        });

        window.addButton("Alterar", 10, 18, new TAction() {
            public void DO() {
                Veiculo veiculo = controllerVeiculo.buscarVeiculoPorPlaca(comboBox.getText());

                int idDigitado = Integer.parseInt(id.getText());
                String nomeClienteDigitado = nomeCliente.getText();

                if (veiculo.getId() != idDigitado) {
                    window.getApplication().messageBox("Erro", "O ID não pode ser alterado!");
                    return;
                }

                if (!veiculo.getNomeCliente().equals(nomeClienteDigitado)) {
                    window.getApplication().messageBox("Erro", "O cliente não pode ser alterado!");
                    return;
                }

                veiculo.setPlaca(placa.getText());
                veiculo.setModelo(modelo.getText());
                controllerVeiculo.alterarVeiculo(veiculo);
                window.getApplication().messageBox("Sucesso", "Veículo alterado com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 18, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaExcluirVeiculo() {
        TWindow window = new TWindow(this, "Excluir Veículo", 50, 15);

        List<String> placasVeiculos = new ArrayList<>();
        for (Veiculo v : controllerVeiculo.listarVeiculos()) {
            placasVeiculos.add(v.getPlaca());
        }

        window.addLabel("Selecionar Placa:", 1, 2);
        comboBox = new TComboBox(window, 18, 2, 15, placasVeiculos, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                String placaSelecionada = comboBox.getText();
                Veiculo veiculo = controllerVeiculo.buscarVeiculoPorPlaca(placaSelecionada);
                if (veiculo != null) {
                    controllerVeiculo.excluirVeiculo(veiculo.getId());
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

    // SERVICO
    public void telaCadastrarServico() {
        TWindow window = new TWindow(this, "Cadastrar Serviço", 50, 18);

        window.addLabel("Nome:", 1, 2);
        TField nome = new TField(window, 12, 2, 30, true, "");

        window.addLabel("Descrição:", 1, 4);
        TField descricao = new TField(window, 12, 4, 50, true, "");

        window.addLabel("Preço:", 1, 6);
        TField preco = new TField(window, 12, 6, 15, true, "");

        window.addButton("Incluir", 10, 10, new TAction() {
            public void DO() {
                Servico servico = new Servico();
                servico.setNome(nome.getText());
                servico.setDescricao(descricao.getText());
                servico.setPreco(Double.parseDouble(preco.getText()));
                controllerServico.inserirServico(servico);
                window.getApplication().messageBox("Sucesso", "Serviço cadastrado com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 10, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaAlterarServico() {
        TWindow window = new TWindow(this, "Alterar Serviço", 50, 23);

        window.addLabel("ID:", 1, 6);

        TField id = new TField(window, 12, 6, 10, false, "");

        window.addLabel("Nome:", 1, 8);
        TField nome = new TField(window, 12, 8, 30, true, "");

        window.addLabel("Descrição:", 1, 10);
        TField descricao = new TField(window, 12, 10, 50, true, "");

        window.addLabel("Preço:", 1, 12);
        TField preco = new TField(window, 12, 12, 15, true, "");

        List<String> nomesServicos = new ArrayList<>();
        for (Servico servico : controllerServico.listarServicos()) {
            nomesServicos.add(servico.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesServicos, 0, 5, new TAction() {
            public void DO() {

                Servico servico = controllerServico.buscarServicoPorNome(comboBox.getText());
                if (servico != null) {
                    id.setText("" + servico.getId());
                    nome.setText(servico.getNome() != null ? servico.getNome() : "");
                    descricao.setText(servico.getDescricao() != null ? servico.getDescricao() : "");
                    preco.setText("" + servico.getPreco());
                }

            }
        });

        window.addButton("Alterar", 10, 16, new TAction() {
            public void DO() {
                Servico servicoOriginal = controllerServico.buscarServicoPorNome(comboBox.getText());
                int idDigitado = Integer.parseInt(id.getText());

                if (servicoOriginal.getId() != idDigitado) {
                    window.getApplication().messageBox("Erro", "O ID não pode ser alterado!");
                    return;
                }

                Servico servico = new Servico();
                servico.setId(idDigitado);
                servico.setNome(nome.getText());
                servico.setDescricao(descricao.getText());
                servico.setPreco(Double.parseDouble(preco.getText()));
                controllerServico.alterarServico(servico);
                window.getApplication().messageBox("Sucesso", "Serviço alterado com sucesso!");

            }
        });

        window.addButton("Fechar", 25, 16, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaExcluirServico() {
        TWindow window = new TWindow(this, "Excluir Serviço", 50, 15);

        List<String> nomesServicos = new ArrayList<>();
        for (Servico servico : controllerServico.listarServicos()) {
            nomesServicos.add(servico.getNome());
        }

        window.addLabel("Selecionar:", 1, 2);
        comboBox = new TComboBox(window, 12, 2, 30, nomesServicos, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                String nomeSelecionado = comboBox.getText();
                Servico servico = controllerServico.buscarServicoPorNome(nomeSelecionado);
                if (servico != null) {
                    controllerServico.excluirServico(servico.getId());
                    window.getApplication().messageBox("Sucesso", "Serviço excluído com sucesso!");
                    window.getApplication().closeWindow(window);
                } else {
                    window.getApplication().messageBox("Erro", "Serviço não encontrado!");
                }
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    // ORDEM SERVICO
    public void telaCadastrarOrdemServico() {
        TWindow window = new TWindow(this, "Cadastrar Ordem de Serviço", 60, 20);

        window.addLabel("Veículo:", 1, 2);
        List<String> placasVeiculos = new ArrayList<>();
        for (Veiculo v : controllerVeiculo.listarVeiculos()) {
            placasVeiculos.add(v.getPlaca());
        }
        TComboBox comboVeiculo = new TComboBox(window, 15, 2, 20, placasVeiculos, 0, 5, null);

        window.addLabel("Mecânico:", 1, 4);
        List<String> nomesMecanicos = new ArrayList<>();
        for (Mecanico m : controllerMecanico.listarMecanicos()) {
            nomesMecanicos.add(m.getNome());
        }
        TComboBox comboMecanico = new TComboBox(window, 15, 4, 20, nomesMecanicos, 0, 5, null);

        window.addLabel("Data:", 1, 6);
        TField dataa = new TField(window, 20, 6, 15, true, "");

        window.addLabel("Descrição:", 1, 8);
        TField descricao = new TField(window, 15, 8, 40, true, "");

        window.addButton("Incluir", 10, 12, new TAction() {
            public void DO() {
                OrdemServico ordem = new OrdemServico();
                Veiculo veiculo = controllerVeiculo.buscarVeiculoPorPlaca(comboVeiculo.getText());
                if (veiculo == null) {
                    window.getApplication().messageBox("Erro", "Veículo inválido!");
                    return;
                }
                ordem.setIdVeiculo(veiculo.getId());

                Mecanico mecanico = controllerMecanico.buscarMecanicoPorNome(comboMecanico.getText());
                if (mecanico == null) {
                    window.getApplication().messageBox("Erro", "Mecânico inválido!");
                    return;
                }
                ordem.setIdMecanico(mecanico.getId());

                ordem.setData(dataa.getText());
                ordem.setDescricao(descricao.getText());

                ordem.setValorTotal(0.0);

                controllerOrdemServico.inserirOrdemServico(ordem);
                window.getApplication().messageBox("Sucesso", "Ordem de Serviço incluída com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 12, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaAlterarOrdemServico() {
        TWindow window = new TWindow(this, "Alterar Ordem de Serviço", 60, 30);

        window.addLabel("ID:", 1, 6);
        TField id = new TField(window, 15, 6, 10, false, "");

        window.addLabel("Veículo:", 1, 8);
        TField placaVeiculo = new TField(window, 15, 8, 20, false, "");

        window.addLabel("Mecânico:", 1, 10);
        TField nomeMecanico = new TField(window, 15, 10, 20, false, "");

        window.addLabel("Data:", 1, 12);
        TField dataa = new TField(window, 20, 12, 15, true, "");

        window.addLabel("Descrição:", 1, 14);
        TField descricao = new TField(window, 15, 14, 40, true, "");

        window.addLabel("Valor Total:", 1, 16);
        TField valorTotal = new TField(window, 15, 16, 15, true, "");

        List<String> idsOrdemServico = new ArrayList<>();
        for (OrdemServico o : controllerOrdemServico.listarOrdensServico()) {
            idsOrdemServico.add(String.valueOf(o.getId()));
        }

        window.addLabel("Selecionar Ordem:", 1, 2);

        TComboBox[] comboOrdem = new TComboBox[1];

        comboOrdem[0] = new TComboBox(window, 18, 2, 10, idsOrdemServico, 0, 5, new TAction() {
            public void DO() {
                String textoSelecionado = comboOrdem[0].getText();
                if (textoSelecionado != null && !textoSelecionado.isEmpty()) {
                    int idSelecionado = Integer.parseInt(textoSelecionado);
                    OrdemServico ordem = controllerOrdemServico.buscarOrdemPorId(idSelecionado);
                    if (ordem != null) {
                        id.setText("" + ordem.getId());

                        Veiculo veiculo = controllerVeiculo.buscarVeiculoPorId(ordem.getIdVeiculo());
                        if (veiculo != null) {
                            placaVeiculo.setText(veiculo.getPlaca());
                        } else {
                            placaVeiculo.setText("");
                        }

                        Mecanico mecanico = controllerMecanico.buscarMecanicoPorId(ordem.getIdMecanico());
                        if (mecanico != null) {
                            nomeMecanico.setText(mecanico.getNome());
                        } else {
                            nomeMecanico.setText("");
                        }

                        dataa.setText(ordem.getData());
                        descricao.setText(ordem.getDescricao());
                        valorTotal.setText("" + ordem.getValorTotal());
                    } else {
                        window.getApplication().messageBox("Erro", "Ordem não encontrada.");
                    }
                }
            }
        });

        window.addButton("Alterar", 10, 18, new TAction() {
            public void DO() {
                int idOrdem = Integer.parseInt(id.getText());
                OrdemServico ordem = controllerOrdemServico.buscarOrdemPorId(idOrdem);
                if (ordem != null) {
                    ordem.setData(dataa.getText());
                    ordem.setDescricao(descricao.getText());
                    ordem.setValorTotal(Double.parseDouble(valorTotal.getText()));

                    controllerOrdemServico.alterarOrdemServico(ordem);

                    window.getApplication().messageBox("Sucesso", "Ordem de serviço alterada com sucesso.");
                } else {
                    window.getApplication().messageBox("Erro", "Ordem não encontrada para alterar.");
                }

            }
        });

        window.addButton("Fechar", 25, 18, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaExcluirOrdemServico() {
        TWindow window = new TWindow(this, "Excluir Ordem de Serviço", 50, 20);

        List<String> idsOrdemServico = new ArrayList<>();
        for (OrdemServico o : controllerOrdemServico.listarOrdensServico()) {
            idsOrdemServico.add(String.valueOf(o.getId()));
        }

        window.addLabel("Selecionar Ordem:", 1, 2);
        comboBox = new TComboBox(window, 18, 2, 10, idsOrdemServico, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {

                int idSelecionado = Integer.parseInt(comboBox.getText());
                OrdemServico ordem = controllerOrdemServico.buscarOrdemPorId(idSelecionado);
                if (ordem != null) {
                    controllerOrdemServico.excluirOrdemServico(ordem.getId());
                    window.getApplication().messageBox("Sucesso", "Ordem de Serviço excluída com sucesso!");
                    window.getApplication().closeWindow(window);
                } else {
                    window.getApplication().messageBox("Erro", "Ordem de Serviço não encontrada!");
                }
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    // SERVICO REALIZADO
    public void telaCadastrarServicoRealizado() {
        TWindow window = new TWindow(this, "Cadastrar Serviço Realizado", 60, 25);

        window.addLabel("Veículo (placa):", 1, 2);
        List<String> placasOrdens = new ArrayList<>();
        List<Integer> idsOrdens = new ArrayList<>();

        for (OrdemServico o : controllerOrdemServico.listarOrdensServico()) {
            Veiculo veiculo = controllerVeiculo.buscarVeiculoPorId(o.getIdVeiculo());
            String placa;
            if (veiculo != null) {
                placa = veiculo.getPlaca();
            } else {
                placa = "desconhecida";
            }
            placasOrdens.add(placa);
            idsOrdens.add(o.getId());
        }

        TComboBox[] comboOrdem = new TComboBox[1];
        comboOrdem[0] = new TComboBox(window, 25, 2, 15, placasOrdens, 0, 5, null);

        window.addLabel("Serviço:", 1, 4);
        List<String> nomesServicos = new ArrayList<>();
        for (Servico s : controllerServico.listarServicos()) {
            nomesServicos.add(s.getNome());
        }

        TComboBox[] comboServico = new TComboBox[1];
        comboServico[0] = new TComboBox(window, 25, 4, 30, nomesServicos, 0, 5, null);

        window.addLabel("Quantidade:", 1, 6);
        TField quantidade = new TField(window, 25, 6, 10, true, "");

        window.addButton("Incluir", 10, 10, new TAction() {
            public void DO() {
                ServicoRealizado sr = new ServicoRealizado();

                String placaSelecionada = comboOrdem[0].getText();
                int indexOrdem = placasOrdens.indexOf(placaSelecionada);
                if (indexOrdem < 0 || indexOrdem >= idsOrdens.size()) {
                    window.getApplication().messageBox("Erro", "Placa não selecionada corretamente!");
                    return;
                }
                int idOrdem = idsOrdens.get(indexOrdem);
                sr.setIdOrdemServico(idOrdem);

                String nomeServicoSelecionado = comboServico[0].getText();
                Servico servico = controllerServico.buscarServicoPorNome(nomeServicoSelecionado);
                if (servico == null) {
                    window.getApplication().messageBox("Erro", "Serviço inválido!");
                    return;
                }
                sr.setIdServico(servico.getId());

                double precoBanco = controllerServicoRealizado.buscarPrecoUnitarioPorIdServico(servico.getId());
                sr.setPrecoUnitario(precoBanco);

                sr.setQuantidade(Integer.parseInt(quantidade.getText()));

                controllerServicoRealizado.inserirServicoRealizado(sr);

                window.getApplication().messageBox("Sucesso",
                        "Serviço Realizado incluído com sucesso!\nPreço Unitário: R$ " + precoBanco);
            }
        });

        window.addButton("Fechar", 25, 10, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaAlterarServicoRealizado() {
        TWindow window = new TWindow(this, "Alterar Serviço Realizado", 60, 25);

        window.addLabel("ID:", 1, 6);
        TField id = new TField(window, 15, 6, 10, false, "");

        window.addLabel("Ordem de Serviço (ID):", 1, 8);
        TField idOrdem = new TField(window, 25, 8, 10, false, "");

        window.addLabel("Serviço:", 1, 10);
        TField nomeServico = new TField(window, 25, 10, 30, false, "");

        window.addLabel("Quantidade:", 1, 12);
        TField quantidade = new TField(window, 25, 12, 10, true, "");

        window.addLabel("Preço Unitário:", 1, 14);
        TField precoUnitario = new TField(window, 25, 14, 15, true, "");

        List<String> idsServicoRealizado = new ArrayList<>();
        for (ServicoRealizado sr : controllerServicoRealizado.listarServicosRealizados()) {
            idsServicoRealizado.add(String.valueOf(sr.getId()));
        }

        window.addLabel("Selecionar Serviço Realizado:", 1, 2);

        TComboBox[] comboSR = new TComboBox[1];
        comboSR[0] = new TComboBox(window, 30, 2, 10, idsServicoRealizado, 0, 5, new TAction() {
            public void DO() {
                String textoSelecionado = comboSR[0].getText();
                int idSelecionado = Integer.parseInt(textoSelecionado);

                ServicoRealizado sr = controllerServicoRealizado.buscarServicoRealizadoPorId(idSelecionado);
                if (sr != null) {
                    id.setText("" + sr.getId());
                    idOrdem.setText("" + sr.getIdOrdemServico());

                    OrdemServico ordem = controllerOrdemServico.buscarOrdemPorId(sr.getIdOrdemServico());
                    Servico servico = controllerServico.buscarServicoPorId(sr.getIdServico());

                    if (servico != null) {
                        nomeServico.setText(servico.getNome());
                    } else {
                        nomeServico.setText("");
                    }

                    quantidade.setText("" + sr.getQuantidade());
                    precoUnitario.setText("" + sr.getPrecoUnitario());
                }
            }
        });

        window.addButton("Alterar", 10, 18, new TAction() {
            public void DO() {
                ServicoRealizado srOriginal = controllerServicoRealizado.buscarServicoRealizadoPorId(Integer.parseInt(id.getText()));
                int idDigitado = Integer.parseInt(id.getText());

                if (srOriginal.getId() != idDigitado) {
                    window.getApplication().messageBox("Erro", "O ID não pode ser alterado!");
                    return;
                }

                srOriginal.setQuantidade(Integer.parseInt(quantidade.getText()));
                srOriginal.setPrecoUnitario(Double.parseDouble(precoUnitario.getText()));

                controllerServicoRealizado.alterarServicoRealizado(srOriginal);
                window.getApplication().messageBox("Sucesso", "Serviço Realizado alterado com sucesso!");
            }
        });

        window.addButton("Fechar", 25, 18, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void telaExcluirServicoRealizado() {
        TWindow window = new TWindow(this, "Excluir Serviço Realizado", 50, 20);

        List<String> idsServicoRealizado = new ArrayList<>();
        for (ServicoRealizado sr : controllerServicoRealizado.listarServicosRealizados()) {
            idsServicoRealizado.add(String.valueOf(sr.getId()));
        }

        window.addLabel("Selecionar Serviço Realizado:", 1, 2);
        comboBox = new TComboBox(window, 30, 2, 10, idsServicoRealizado, 0, 5, null);

        window.addButton("Excluir", 10, 6, new TAction() {
            public void DO() {
                int idSelecionado = Integer.parseInt(comboBox.getText());
                ServicoRealizado sr = controllerServicoRealizado.buscarServicoRealizadoPorId(idSelecionado);
                if (sr != null) {
                    controllerServicoRealizado.excluirServicoRealizado(sr.getId());
                    window.getApplication().messageBox("Sucesso", "Serviço Realizado excluído com sucesso!");
                    window.getApplication().closeWindow(window);
                } else {
                    window.getApplication().messageBox("Erro", "Serviço Realizado não encontrado!");
                }
            }
        });

        window.addButton("Fechar", 25, 6, new TAction() {
            public void DO() {
                window.getApplication().closeWindow(window);
            }
        });
    }

    public void escolherServicoFinal() {
    TWindow window = new TWindow(this, "Gerar Relatório", 50, 20);
    Relatorios r = new Relatorios();

    List<String> idsOrdemServico = new ArrayList<>();
    for (OrdemServico o : controllerOrdemServico.listarOrdensServico()) {
        idsOrdemServico.add(String.valueOf(o.getId()));
    }

    window.addLabel("Selecionar Ordem de serviço:", 1, 2);
    comboBox = new TComboBox(window, 18, 2, 10, idsOrdemServico, 0, 5, null);

    window.addButton("Gerar Relatório", 10, 6, new TAction() {
        public void DO() {
            try {
                int idSelecionado = Integer.parseInt(comboBox.getText());
                r.relatorioFinal(idSelecionado);

                window.getApplication().messageBox("Sucesso", "Relatório gerado com sucesso!");
                window.getApplication().closeWindow(window);

            } catch (Exception e) {
                window.getApplication().messageBox("Erro", "Erro ao gerar relatório: " + e.getMessage());
            }
        }
    });

    window.addButton("Fechar", 30, 6, new TAction() {
        public void DO() {
            window.getApplication().closeWindow(window);
        }
    });
}



    public static void main(String[] args) throws Exception {
        TelaPrincipal app = new TelaPrincipal();
        app.run();
    }
}
