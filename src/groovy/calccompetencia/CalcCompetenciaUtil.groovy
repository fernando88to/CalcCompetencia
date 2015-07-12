package calccompetencia

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by fernando on 11/07/15.
 */
class CalcCompetenciaUtil {

    /**
     * Retorna o último dia do mês
     * @param data
     * @return
     */
    static Date ultimoDiaDomes(Date data) {
        if (data.month >= 9) {
            //janeiro = 0
            return new Date().parse("dd/MM/yyyy", "01/${data.month + 2}/${data.format("yyyy")}").minus(1)
        } else {
            return new Date().parse("dd/MM/yyyy", "01/0${data.month + 2}/${data.format("yyyy")}").minus(1)
        }
    }

    /**
     * Retorna a próxima competência da data passada
     * @param data
     * @return
     */
    static Date proximoMes(Date data) {
        data = capturarCompetencia(data.format("MM/yyyy"))
        def calendario = Calendar.getInstance()
        calendario.setTime(data)
        calendario.add(Calendar.MONTH, 1)
        return calendario.getTime()


    }

    /**
     * Capturar a competência da data passada, exemplo:  data = 26/02/2015 retorna 01/02/2015
     * @param data
     * @return
     */
    static Date capturarCompetencia(Date data) {
        if (data.month >= 9) {
            return new Date().parse("dd/MM/yyyy", "01/${data.month + 1}/${data.format("yyyy")}")
        } else {
            return new Date().parse("dd/MM/yyyy", "01/0${data.month + 1}/${data.format("yyyy")}")
        }

    }

/**
 * Capturar a competência da data passada, exemplo:  data = 26/02/2015 retorna 01/02/2015
 * @param data
 * @return
 */
    static Date capturarCompetencia(String competencia) {

        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            sd.lenient = false
            return sd.parse("01/" + competencia)
        } catch (ParseException e) {
            return null
        }

        return null


    }

    static Date capturarCompentenciaComExcessao(String competencia) throws ParseException {

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        sd.lenient = false
        return sd.parse("01/" + competencia)


    }

    /**
     * Conveter uma string para uma data
     * @param data
     * @return
     */
    static Date converterStringParaData(String data) {

        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            sd.lenient = false
            return sd.parse(data)
        } catch (ParseException e) {
            return null
        }

        return null

    }

    /**
     * Converte uma string para data, se a data passada for inválida
     * lança uma excessão
     * @param data
     * @return
     * @throws ParseException
     */
    static Date converterStringParaDataComExcessao(String data) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        sd.lenient = false
        return sd.parse(data)

    }

    /**
     * Recebe uma ano inicial e retorna uma lista com todos os anos até a data
     * presente, exemplo: anoInicial 2010, hoje=2015 então retorna = [2010,2011,2012,2013,2014,2015]
     * @param anoInicial
     * @return
     */
    static List<Integer> anos(Integer anoInicial) {
        if (anoInicial) {
            Set<Integer> anos = new TreeSet<Integer>()

            def anoAtual = new Integer(new Date().format("yyyy"))
            while (anoAtual >= anoInicial) {
                anos += anoAtual
                anoAtual--
            }

            return anos.asList()
        }

        return []

    }

    /* public Date competenciaDoMesAnterior(Date data){
     if(data.month>=9){
         //o month começa com zero dessa forma month é a mesma coisa que o mes -1
         return new Date().parse("dd/MM/yyyy", "01/${data.month}/${data.format("yyyy")}")
     }else{
         return new Date().parse("dd/MM/yyyy",  "01/0${data.month}/${data.format("yyyy")}")
     }


 }  */

    /**
     * Captura a competência da data passada e soma a quantidades de meses a comptencia, por
     * exemplo: outubro de 2015 + 2 meses = dezembro de 2015
     * @param data
     * @param quantidadeMeses
     * @return
     */
    static Date somarCompetencia(Date data, Integer quantidadeMeses) {
        if(data && quantidadeMeses>0){
            def calendario = Calendar.getInstance()
            calendario.setTime(data)
            calendario.add(Calendar.MONTH, quantidadeMeses)
            return calendario.getTime()
        }

        return null

    }
}
