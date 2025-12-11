package oficinamecanica;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class Relatorios {

    public void relatorioCliente() {
        Connection conn = Conexao.abrirConexao();
        ControllerCliente cliente = new ControllerCliente(conn);
        Document documento = new Document();
        try {
            PdfWriter objpdf = PdfWriter.getInstance(documento, new FileOutputStream("RelatorioClientes.pdf"));
            documento.open();
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 4, 2});
            table.addCell("ID");
            table.addCell("Nome");
            table.addCell("telefone");

            documento.add(new Paragraph("Relação de todos os clientes"));
            String linha = "";
            documento.add(new Paragraph("\n"));
            for (Cliente c : cliente.listarClientes()) {
                table.addCell(String.valueOf(c.getId()));
                table.addCell(String.valueOf(c.getNome()));
                table.addCell(String.valueOf(c.getTelefone()));

            }

            documento.add(table);
            documento.close();
            objpdf.close();
            abreArquivoPdf("RelatorioClientes.pdf");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void relatorioMecanico() {
        Connection conn = Conexao.abrirConexao();
        ControllerMecanico mecanico = new ControllerMecanico(conn);
        Document documento = new Document();
        try {
            PdfWriter objpdf = PdfWriter.getInstance(documento, new FileOutputStream("RelatorioMecanico.pdf"));
            documento.open();
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 4});
            table.addCell("ID");
            table.addCell("Nome");

            documento.add(new Paragraph("Relação de todos os mecânicos"));
            String linha = "";
            documento.add(new Paragraph("\n"));
            for (Mecanico m : mecanico.listarMecanicos()) {
                table.addCell(String.valueOf(m.getId()));
                table.addCell(String.valueOf(m.getNome()));

            }

            documento.add(table);
            documento.close();
            objpdf.close();
            abreArquivoPdf("RelatorioMecanico.pdf");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void relatorioVeiculo() {
        Connection conn = Conexao.abrirConexao();
        ControllerVeiculo veiculo = new ControllerVeiculo(conn);
        Document documento = new Document();
        try {
            PdfWriter objpdf = PdfWriter.getInstance(documento, new FileOutputStream("RelatorioVeiculo.pdf"));
            documento.open();
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 2, 4});
            table.addCell("ID Veiculo");
            table.addCell("Modelo");
            table.addCell("Placa");
            table.addCell("Dono");

            documento.add(new Paragraph("Relação de todos os Veiculos"));
            String linha = "";
            documento.add(new Paragraph("\n"));
            for (Veiculo v : veiculo.listarVeiculos()) {
                table.addCell(String.valueOf(v.getId()));
                table.addCell(String.valueOf(v.getModelo()));
                table.addCell(String.valueOf(v.getPlaca()));
                table.addCell(String.valueOf(v.getNomeCliente()));

            }

            documento.add(table);
            documento.close();
            objpdf.close();
            abreArquivoPdf("RelatorioVeiculo.pdf");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void abreArquivoPdf(String arquivopdf) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(arquivopdf);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
            }
        }
    }

    public void relatorioServico() {
        Connection conn = Conexao.abrirConexao();
        ControllerServico servico = new ControllerServico(conn);
        Document documento = new Document();
        try {
            PdfWriter objpdf = PdfWriter.getInstance(documento, new FileOutputStream("RelatorioServico.pdf"));
            documento.open();
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 4, 2, 6});
            table.addCell("ID");
            table.addCell("Nome");
            table.addCell("Preço");
            table.addCell("Descrição");

            documento.add(new Paragraph("Relação de todos os Serviços"));
            documento.add(new Paragraph("\n"));
            for (Servico s : servico.listarServicos()) {
                table.addCell(String.valueOf(s.getId()));
                table.addCell(s.getNome());
                table.addCell(String.format("R$ %.2f", s.getPreco()));
                table.addCell(s.getDescricao());
            }

            documento.add(table);
            documento.close();
            objpdf.close();
            abreArquivoPdf("RelatorioServico.pdf");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void relatorioOrdemServico() {
        Connection conn = Conexao.abrirConexao();
        ControllerOrdemServico ordem = new ControllerOrdemServico(conn);
        ControllerVeiculo veiculoCtrl = new ControllerVeiculo(conn);
        Document documento = new Document();
        try {
            PdfWriter objpdf = PdfWriter.getInstance(documento, new FileOutputStream("RelatorioOrdemServico.pdf"));
            documento.open();
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 2, 3, 5, 2});
            table.addCell("ID");
            table.addCell("Data");
            table.addCell("Veículo");
            table.addCell("Descrição");
            table.addCell("Valor Total");

            documento.add(new Paragraph("Relação de todas as Ordens de Serviço"));
            documento.add(new Paragraph("\n"));

            for (OrdemServico o : ordem.listarOrdensServico()) {
                table.addCell(String.valueOf(o.getId()));
                table.addCell(o.getData());

                Veiculo v = veiculoCtrl.buscarVeiculoPorId(o.getIdVeiculo());
                String placa = (v != null) ? v.getPlaca() : "Desconhecido";
                table.addCell(placa);

                table.addCell(o.getDescricao());
                table.addCell(String.format("R$ %.2f", o.getValorTotal()));
            }

            documento.add(table);
            documento.close();
            objpdf.close();
            abreArquivoPdf("RelatorioOrdemServico.pdf");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void relatorioServicoRealizado() {
        Connection conn = Conexao.abrirConexao();
        ControllerServico servico = new ControllerServico(conn);
        Document documento = new Document();
        try {
            PdfWriter objpdf = PdfWriter.getInstance(documento, new FileOutputStream("RelatorioServico.pdf"));
            documento.open();
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1, 4, 2, 6});
            table.addCell("ID");
            table.addCell("Nome");
            table.addCell("Preço");
            table.addCell("Descrição");

            documento.add(new Paragraph("Relação de todos os Serviços"));
            documento.add(new Paragraph("\n"));
            for (Servico s : servico.listarServicos()) {
                table.addCell(String.valueOf(s.getId()));
                table.addCell(s.getNome());
                table.addCell(String.format("R$ %.2f", s.getPreco()));
                table.addCell(s.getDescricao());
            }

            documento.add(table);
            documento.close();
            objpdf.close();
            abreArquivoPdf("RelatorioServico.pdf");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   public void relatorioFinal(int idOrdemServico) {
    Connection conn = Conexao.abrirConexao();
    ControllerOrdemServico ordemController = new ControllerOrdemServico(conn);
    ControllerVeiculo veiculoController = new ControllerVeiculo(conn);
    ControllerMecanico mecanicoController = new ControllerMecanico(conn);
    ControllerServicoRealizado servicoRealizadoController = new ControllerServicoRealizado(conn);
    ControllerServico servicoController = new ControllerServico(conn);

    Document documento = new Document();
    try {
        PdfWriter.getInstance(documento, new FileOutputStream("RelatorioFinal.pdf"));
        documento.open();

        OrdemServico ordem = ordemController.buscarOrdemPorId(idOrdemServico);
        if (ordem == null) {
            documento.add(new Paragraph("Ordem de serviço não encontrada."));
            documento.close();
            abreArquivoPdf("RelatorioFinal.pdf");
            return;
        }

        Veiculo veiculo = veiculoController.buscarVeiculoPorId(ordem.getIdVeiculo());
        String placa = " ";
        String nomeCliente = " ";
        if (veiculo != null) {
            placa = veiculo.getPlaca();
            nomeCliente = veiculo.getNomeCliente();
        }

        Mecanico mecanico = mecanicoController.buscarMecanicoPorId(ordem.getIdMecanico());
        String nomeMecanico = "N/A";
        if (mecanico != null) {
            nomeMecanico = mecanico.getNome();
        }

        documento.add(new Paragraph("Relatorio ordem servico Nº " + idOrdemServico));
        documento.add(new Paragraph("Cliente: " + nomeCliente));
        documento.add(new Paragraph("Placa: " + placa));
        documento.add(new Paragraph("Mecanico: " + nomeMecanico));
        documento.add(new Paragraph("\n"));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{5, 2, 2});

        table.addCell("Servico Realizado");
        table.addCell("Quantidade");
        table.addCell("Valor");

        double total = 0;

        List<ServicoRealizado> listaSR = servicoRealizadoController.listarServicosRealizadosPorOrdem(idOrdemServico);
        if (listaSR != null) {
            for (ServicoRealizado sr : listaSR) {
                Servico s = servicoController.buscarServicoPorId(sr.getIdServico());
                String nomeServico = "Serviço não encontrado";
                if (s != null) {
                    nomeServico = s.getNome();
                }

                int quantidade = sr.getQuantidade();
                double valor = sr.getPrecoUnitario();

                table.addCell(nomeServico);
                table.addCell(String.valueOf(quantidade));
                table.addCell(String.format("R$ %.2f", valor));
                total += quantidade * valor;
            }
        } else {
            table.addCell("Nenhum serviço realizado encontrado.");
        }

        documento.add(table);
        documento.add(new Paragraph("\nTotal da os: R$ " + String.format("%.2f", total)));

        documento.close();

        abreArquivoPdf("RelatorioFinal.pdf");

    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
