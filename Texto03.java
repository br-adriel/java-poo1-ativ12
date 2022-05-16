import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;

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
}
