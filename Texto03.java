import java.util.Date;
import java.text.SimpleDateFormat;

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
}
