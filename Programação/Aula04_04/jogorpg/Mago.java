/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula04_04.jogorpg;

import java.util.Random;

/**
 *
 * @author admin
 */
public class Mago {

    private String nome;
    private int vida;
    private int ataque;
    String avatar;
    private int vidaMaxima;

    public Mago(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.vidaMaxima = vida;
        this.avatar =
      "             _            _.,----,                         \n" +
      " __  _.-._ / '-.        -  ,._  \\\\)                       \n" +
      "|  `-)_   '-.   \\       / < _ )/\" }                      \n" +
      "/__    '-.   \\   '-, ___(c-(6)=(6)                      \n" +
      " , `'.    `._ '.  _,'   >\\    \"  )                      \n" +
      " :;;,,'-._   '---' (  ( \"/`. -='/                      \n" +
      ";:;;:;;,  '..__    ,`-.`)'- '--'                        \n" +
      ";';:;;;;;'-._ /'._|   Y/   _/' \\                         \n" +
      "      '''\"._ F    |  _/ _.'._   `\\                      \n" +
      "             L    \\   \\/     '._  \\                    \n" +
      "      .-,-,_ |     `.  `'---,  \\_ _|                    \n" +
      "      //    'L    /  \\,   (\"--',=`)7                   \n" +
      "     | `._       : _,  \\  /'`-._L,_'-._                \n" +
      "     '--' '-.\\__/ _L   .`'         './/               \n" +
      "                 [ (  /                                  \n" +
      "                  ) `{                                    \n" +
      "                  \\__)                                   ";

    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void atacar(Guerreiro alvo, int opcaoPoder) {
        int dano;
        String nomePoder;

        switch (opcaoPoder) {
            case 1:
                nomePoder = "Bola de Fogo";
                dano = 15;
                break;
            case 2:
                nomePoder = "Raio Congelante";
                dano = 25;
                break;
            case 3:
                nomePoder = "Explosão Arcana";
                dano = 35;
                break;
            default:
                nomePoder = "Magia Fraca";
                dano = 5;
                break;
        }

        alvo.receberDano(dano);
        System.out.println("");
        System.out.println(avatar + "\n" + nome + " lançou " + nomePoder + " em " + alvo.getNome() + " causando " + dano + " de dano!");
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println("\n" + nome + " agora tem " + vida + " de vida.");
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
