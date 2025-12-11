package Aula04_25.betdaads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    public void arqTimes(String nome) {
        try (FileOutputStream arquivo = new FileOutputStream("times.csv", true);
                DataOutputStream insere = new DataOutputStream(arquivo)) {
            insere.writeBytes(nome + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar o time: " + e.getMessage());
        }
    }

    public boolean existeTime(String time) {
        File arq = new File("times.csv");
        if (!arq.exists()) {
            return false;
        }

        try (BufferedReader ler = new BufferedReader(new FileReader(arq))) {
            String linha;
            while ((linha = ler.readLine()) != null) {
                if (linha.equals(time)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao verificar o time: " + e.getMessage());
        }
        return false;
    }

    public boolean arqPartidas(String nome1, int gols1, String nome2, int gols2) {
        if (existeTime(nome1) && existeTime(nome2)) {
            try (FileOutputStream arquivo = new FileOutputStream("partidas.csv", true);
                    DataOutputStream insere = new DataOutputStream(arquivo)) {
                String partida = nome1 + ";" + gols1 + ";" + nome2 + ";" + gols2 + "\n";
                insere.writeBytes(partida);
                return true;
            } catch (IOException e) {
                System.out.println("Erro ao registrar a partida: " + e.getMessage());
            }
        }
        return false;
    }

    public void mostraPartidas() {
        File arq = new File("partidas.csv");
        if (!arq.exists()) {
            System.out.println("Nenhuma partida registrada.");
            return;
        }

        try (BufferedReader ler = new BufferedReader(new FileReader(arq))) {
            String linha;
            while ((linha = ler.readLine()) != null) {
                String temp[] = linha.split(";");
                System.out.println(temp[0]+" "+temp[1]+" X "+temp[2]+" "+temp[3] );
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de partidas: " + e.getMessage());
        }
    }
}
