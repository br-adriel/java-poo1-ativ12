import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Resolução da Lista 2 da unidade 1
 * 
 * @author Adriel Faria dos Santos
 * @version 16/05/2022
 */
public class Texto03
{
    /**
     * Obter a data atual do sistema e retorná-la na forma de String.
     */
    public String exercicio3_01() {
        return new Date().toString();
    }
    
    /**
     * Receber uma data (como String) no formato dd/mm/aaaa e retornar
     * a mesma data (como String) no formato "<dia da semana>, <dia> de
     * <nome do mês> de <ano>"
     */
    public String exercicio3_02(String data) {
        SimpleDateFormat formatadorString = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
        SimpleDateFormat formatadorDate = new SimpleDateFormat("dd/MM/yyyy");
        
        Date novaData = null;
        try {
            novaData = formatadorDate.parse(data);
        } catch (java.text.ParseException pe) {
            pe.printStackTrace();
        }
        return formatadorString.format(novaData);
    }
    
    /*
     * Receber um caminho de diretório como parâmetro e retornar um vetor
     * com todos os itens do diretório. Dica: objetos da classe File podem
     * ser usados para realizar operações sobre diretórios, entre várias
     * outras coisas. Analise a documentação da classe File para saber além
     * do que já foi descrito no conteúdo deste texto.
     */
    public File[] exercicio3_03(String caminho) {
        File pasta = new File(caminho);
        return pasta.listFiles();
    }
    
    /*
     * Receber um caminho de diretório como parâmetro e retornar um vetor
     * com todos os itens do diretório. Cada item do vetor retornado deve
     * estar precedido por "[A]", caso seja arquivo, e "D", caso seja
     * diretório. Retorne um valor nulo caso o String recebido como
     * parâmetro não corresponda a um diretório existente no disco. Mais
     * uma vez, você precisará de um objeto da classe File para fazer o
     * trabalho sujo para você.
     */
    public String[] exercicio3_04(String caminho) {
        File arquivos[] = exercicio3_03(caminho);
        
        if (arquivos == null) return null;
        
        String nomesArquivos[] = new String[arquivos.length];
        
        for (int i=0; i<arquivos.length; i++) {
            if (arquivos[i].isFile()) {
                nomesArquivos[i] = "[A] " + arquivos[i].getName();
            } else if (arquivos[i].isDirectory()) {
                nomesArquivos[i] = "D " + arquivos[i].getName();
            } else {
                nomesArquivos[i] = arquivos[i].getName();
            }
        }
        return nomesArquivos;
    }
    
    /*
     * Receber um caminho para um arquivo como parâmetro e deletar o arquivo
     */
    public void exercicio3_05(String caminho) {
        File arq = new File(caminho);
        if (arq != null) arq.delete();
    }
    
    /*
     * Escreva um programa que mostre uma janela com dois menus - Arquivo
     * e Editar. Dica: você deverá utilizar objetos das classes JFrame,
     * JMenuBar e JMenu)
     */
    public void exercicio3_06() {
        // Itens da barra de menu       
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuEditar = new JMenu("Editar");
        
        // Configuarcao da barra de menu
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(menuArquivo);
        barraMenu.add(menuEditar);
        
        // Configuracao da janela
        JFrame janela = new JFrame("Questao 6");
        janela.setMinimumSize(new Dimension(500, 400));
        janela.setJMenuBar(barraMenu);
        janela.setVisible(true);
    }
    
    /*
     * Escreva um método que receba como parâmetro um String representando
     * um caminho para um arquivo executável e execute tal arquivo. Dica:
     * pesquise no google "java como executar programas externos" (SEM as
     * aspas) e seja feliz (você pode ter que escrever código que não vai
     * entender bem - a ideia aqui é que você desenrole a solução
     * independentemente de entender o que está acontecendo. Acredite,
     * isso lhe será muito útil em sua vida de programador) 
     */
    public void exercicio3_07(String caminho) {
        String comando = "cmd /c \"" + caminho + "\"";
        try {
            Runtime.getRuntime().exec(comando);
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /*
     * Escreva um método que receba o caminho de um arquivo de texto (txt)
     * e abra o arquivo no bloco de notas (notepad no windows ou qualquer
     * gedit no Ubuntu). Dica: você vai precisar apenas da solução da questão
     * anterior e de um real a mais de esperteza.
     */
    public void exercicio3_08(String caminho) {
        String comando = "notepad \"" + caminho + "\"";
        try {
            Runtime.getRuntime().exec(comando);
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /*
     * Faça um método que mostre uma Janela (vazia) do tamanho da tela.
     * O programa deve funcionar em monitores com diferentes resoluções.
     * Dica de professor: a classe ToolKit pode prover o tamanho da tela.
     * Dica de MÃE: pesquise "como criar uma janela tela cheia em java"
     * (sem aspas, pelo amor de Deus) e seja feliz.
     */
    public void exercicio3_09() {
        JFrame janela = new JFrame("Questao 9");
        janela.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        janela.setVisible(true);
    }
    
    /*
     * Receber duas datas como parâmetro e retornar a mais recente
     */
    public String exericio3_10(String data1, String data2) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = null, d2 = null;
        try {
            d1 = formatador.parse(data1);
            d2 = formatador.parse(data2);
        } catch (java.text.ParseException pe) {
            pe.printStackTrace();
        }
        return d1.after(d2) ? formatador.format(d1) : formatador.format(d2);
    }
    
    /* 
     * Receber um array de Dates e modificar o array de forma que fique
     * em ordem cronológica. Dica: use o método compareTo da classe Date
     */
    public Date[] exercicio3_11(Date[] datas) {
        int trocas = 0;
        do {
            trocas = 0;
            for (int i=0; i<datas.length-1; i++) {
                if (datas[i].compareTo(datas[i+1]) > 0) {
                    Date aux = datas[i];
                    datas[i] = datas[i+1];
                    datas[i+1] = aux;
                    trocas++;
                }
            }
        } while (trocas > 0);
        return datas;
    }
}
