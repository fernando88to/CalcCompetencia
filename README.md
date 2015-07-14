# CalcCompetencia
Plugin do Grails para trabalhar com datas, principalmente competências, em todos os projetos exista a necessidade de trabalhar com data, por meio desse plugin o trabalho do desenvolvedor fica simplificado.




Conveter String para Date
----------------
      def data = calccompetencia.CalcCompetenciaUtil.converterStringParaData("07/05/2015")
Caso a data seja inválida retorna null


Capturar Competencia
----------------
      def data = calccompetencia.CalcCompetenciaUtil.capturarCompetencia(new Date())
Recebe uma data qualquer, por exemplo 07/08/2015 e retorna a competencia, no caso 01/08/2015

    def data = calccompetencia.CalcCompetenciaUtil.capturarCompetencia("08/07/2015")
Existe outro método com o nome nome só que ele recebe um string, casa a string seja inválida ele retorna null    

Somando competências
----------------
      def daqui5Competencias = calccompetencia.CalcCompetenciaUtil.somarCompetencia(new Date(),5)
Muitas vezes queremos uma data futura, por exemplo daqui a 2 meses, esse método recebe uma data e por meio do parâmetro 'quantidadeMeses' ele soma a quantidade de meses.
    
    
Primeiro Dia do Ano
----------------
      def primeiroDia = calccompetencia.CalcCompetenciaUtil.primeiroDiaAno(2015)
Retorna o primeiro dia do ano no formato Date, muito útil para fazer between.

Último Dia do Ano
----------------
      def ultimoDia = calccompetencia.CalcCompetenciaUtil.ultimoDiaAno(2015)
Retorna o último dia do ano no formato Date, muito útil para fazer between.

Lista de ano
----------------
      def anoLista = calccompetencia.CalcCompetenciaUtil.anoInicial(2012)
Retorna um lista com todos ao anos até a data presente começando pelo ano inicial passado no parâmetro.


      
      
      



