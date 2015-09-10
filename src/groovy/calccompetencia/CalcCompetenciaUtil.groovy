package calccompetencia

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * @author fernando
 */
class CalcCompetenciaUtil {

    /**
     * Retorna o último dia do mês
     */
    static Date ultimoDiaDomes(Date data) {
        if(data){
            Calendar calendario = calendarFor(data)
            calendario.set(Calendar.DATE, calendario.getActualMaximum(Calendar.DATE))
            return calendario.time
        }
    }

    /**
     * Retorna a próxima competência da data passada
     */
    static Date proximoMes(Date data) {
        if(data){
            data = capturarCompetencia(data.format("MM/yyyy"))
            def calendario = calendarFor(data)
            calendario.add(Calendar.MONTH, 1)
            return calendario.time
        }
    }

    /**
     * Capturar a competência da data passada, exemplo:  data = 26/02/2015 retorna 01/02/2015
     */
    static Date capturarCompetencia(Date data) {
        if(data){
            def competencia = data.getAt(Calendar.MONTH)
            competencia++
            return  converterStringParaData("01/$competencia/${data.format('yyyy')}")
        }
    }

    /**
     * Capturar a competência da data passada, exemplo:  data = 26/02/2015 retorna 01/02/2015
     */
    static Date capturarCompetencia(String competencia) {
        try {
            return capturarCompentenciaComExcessao(competencia)
        } catch (ParseException ignored) {
        }
    }

    static Date capturarCompentenciaComExcessao(String competencia) throws ParseException {
        return dateFormatter().parse("01/" + competencia)
    }

    /**
     * Conveter uma string para uma data
     */
    static Date converterStringParaData(String data) {
        if(data){
            try {
                return converterStringParaDataComExcessao(data)
            } catch (ParseException ignored) {
            }
        }
    }

    /**
     * Converte uma string para data, se a data passada for inválida
     * lança uma excessão
     * @throws ParseException
     */
    static Date converterStringParaDataComExcessao(String data) throws ParseException {
        return dateFormatter().parse(data)
    }

    /**
     * Recebe uma ano inicial e retorna uma lista com todos os anos até a data
     * presente, exemplo: anoInicial 2010, hoje=2015 então retorna = [2010,2011,2012,2013,2014,2015]
     */
    static List<Integer> anos(Integer anoInicial) {
        if (!anoInicial) {
            return []
        }

        Set<Integer> anos = new TreeSet<Integer>()

        int anoAtual = Calendar.instance.get(Calendar.YEAR)
        while (anoAtual >= anoInicial) {
            anos << anoAtual
            anoAtual--
        }

        return anos as List
    }


    /**
     * Captura a competência da data passada e soma a quantidades de meses a comptencia, por
     * exemplo: outubro de 2015 + 2 meses = dezembro de 2015
     */
    static Date somarCompetencia(Date data, Integer quantidadeMeses) {
        if(data && quantidadeMeses!=null){
            def calendario = calendarFor(data)
            if(quantidadeMeses>=0){
                calendario.add(Calendar.MONTH, quantidadeMeses)
            }

            return calendario.time
        }
    }

    static Date primeiroDiaAno(Integer ano){
        if(ano){
            return converterStringParaData("01/01/$ano")
        }
    }

    static Date ultimoDiaAno(Integer  ano){
        if(ano){
            def data = converterStringParaData("01/01/${ano+1}")//proximo ano
            return data - 1
        }
    }

    private static SimpleDateFormat dateFormatter() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy")
        sd.lenient = false
        sd
    }

    private static Calendar calendarFor(Date data) {
        Calendar calendario = Calendar.instance
        calendario.time = data
        calendario
    }
}
