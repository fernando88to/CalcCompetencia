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
    


      
      
      



