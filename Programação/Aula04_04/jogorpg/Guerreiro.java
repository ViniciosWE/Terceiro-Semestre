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
public class Guerreiro {

    private String nome;
    private int vida;
    private int ataque;
    String avatar;
    private int vidaMaxima;

    public Guerreiro(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.vidaMaxima = vida;
        this.avatar = "                              _.--\"\"-._                     \n"
                + "  .                         .\"         \".                   \n"
                + " / \\    ,^.         /(     Y             |      )\\          \n"
                + "/   `---. |--'\\    (  \\__..'--   -   -- -'\"\"-.-'  )         \n"
                + "|        :|    >   '.     l_..-------.._l      .'          \n"
                + "|      __l;__ .'      \"-.__.||_.-'v'-._||`\"----\"            \n"
                + " \\  .-' | |  `              l._       _.'                   \n"
                + "  \\/    | |                   l`^^'^^'j                     \n"
                + "        | |                _   \\_____/     _               \n"
                + "        j |               l `--__)-'(__.--' |              \n"
                + "        | |               | /`---``-----'\"1 |  ,-----.     \n"
                + "        | |               )/  `--' '---'   \\'-'  ___  `-.   \n"
                + "        | |              //  `-'  '`----'  /  ,-'   I`.  \\  \n"
                + "      _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\ \n"
                + "     '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :\n"
                + "      `._;/7(-.......'  /        ) (     |  |            | |\n"
                + "      `._;l _'--------_/        )-'/     :  |___.    _._./ ;\n"
                + "        | |                 .__ )-'\\  __  \\  \\  I   1   / / \n"
                + "        `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /  \n"
                + "                           \\__  `-'    __/  `-. `---'',-'   \n"
                + "                              )-._.-- (        `-----'      \n"
                + "                             )(  l\\ o ('..-.               \n"
                + "                       _..--' _'-' '--'.-. |               \n"
                + "                __,,-'' _,,-''            \\ \\              \n"
                + "               f'. _,,-'                   \\ \\             \n"
                + "              ()--  |                       \\ \\            \n"
                + "                \\.  |                       /  \\           \n"
                + "                  \\ \\                      |._  |          \n"
                + "                   \\ \\                     |  ()|          \n"
                + "                    \\ \\                     \\  /           \n"
                + "                     ) `-.                   | |           \n"
                + "                    // .__)                  | |           \n"
                + "                 _.//7'                      | |           \n"
                + "               '---'                         j_| `         \n"
                + "                                            (| |           \n"
                + "                                             |  \\          \n"
                + "                                             |lllj          \n"
                + "                                             |||||";
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void atacar(Mago alvo, int opcaoPoder) {
        int dano;
        String nomePoder;

        switch (opcaoPoder) {
            case 1:
                nomePoder = "Corte Rápido";
                dano = 10;
                break;
            case 2:
                nomePoder = "Golpe Pesado";
                dano = 20;
                break;
            case 3:
                nomePoder = "Fúria da Espada";
                dano = 30;
                break;
            default:
                nomePoder = "Soco Fraco";
                dano = 5;
                break;
        }

        alvo.receberDano(dano);
        System.out.println();
        System.out.println(avatar + "\n" + nome + " usou " + nomePoder + " contra " + alvo.getNome() + " causando " + dano + " de dano!");
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
