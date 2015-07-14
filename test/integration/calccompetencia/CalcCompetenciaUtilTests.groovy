package calccompetencia

import static org.junit.Assert.*
import org.junit.*

class CalcCompetenciaUtilTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testarconverterStringParaData(){
        def retorno = CalcCompetenciaUtil.converterStringParaData(null)
        assert  retorno==null

        def data = CalcCompetenciaUtil.converterStringParaData("01/10/2013")
        assert  data != null
        assert data.getClass() == java.util.Date
        assert  data.format("dd") =="01"
        assert data.format("MM")=="10"
        assert  data.format("yyyy")=="2013"

        data = CalcCompetenciaUtil.converterStringParaData("12-15-2013")
        assert  data == null
    }

    @Test
    void testarultimoDiaDomes(){
        def retorno = CalcCompetenciaUtil.ultimoDiaDomes(null)
        assert  retorno == null

        def data = CalcCompetenciaUtil.converterStringParaData("25/08/2016")
        retorno =  CalcCompetenciaUtil.ultimoDiaDomes(data)
        assert  retorno.format('dd') =='31'

        data = CalcCompetenciaUtil.converterStringParaData("14/07/2016")
        retorno =  CalcCompetenciaUtil.ultimoDiaDomes(data)
        assert  retorno.format('dd') =='31'

        data = CalcCompetenciaUtil.converterStringParaData("14/06/2016")
        retorno =  CalcCompetenciaUtil.ultimoDiaDomes(data)
        assert  retorno.format('dd') =='30'

        data = CalcCompetenciaUtil.converterStringParaData("05/02/2015")
        retorno =  CalcCompetenciaUtil.ultimoDiaDomes(data)
        assert  retorno.format('dd') =='28'





    }

    @Test
    void testarproximoMes(){
        def retorno = CalcCompetenciaUtil.proximoMes(null)
        assert  retorno == null
        def competenciaInicial = CalcCompetenciaUtil.converterStringParaData("01/04/2015")
        def proximaCompetencia = CalcCompetenciaUtil.proximoMes(competenciaInicial)
        assert  proximaCompetencia.format('MM')=='05'
        assert proximaCompetencia.format('yyyy')=='2015'
        assert  proximaCompetencia.format('dd')=='01'
    }

    @Test
    void testarCapturarCompetenica() {
        def retorno  = CalcCompetenciaUtil.capturarCompetencia(new Date())
        assert  retorno != null
        def data = CalcCompetenciaUtil.converterStringParaData("25/07/2015")
        retorno  = CalcCompetenciaUtil.capturarCompetencia(data)
        assert  retorno != null
        assert retorno.format('MM')=='07'
        assert  retorno.format('dd')=='01'
        assert  retorno.format('yyyy')=='2015'
    }

    @Test
    void testaranos(){
        def retorno = CalcCompetenciaUtil.anos(null)
        assert  retorno == []
        retorno = CalcCompetenciaUtil.anos(2010)
        def anoAtual = new Integer(new Date().format('yyyy'))
        def quantidadeRegistrosQueDeveTer = anoAtual-2010
        quantidadeRegistrosQueDeveTer++
        assert quantidadeRegistrosQueDeveTer==retorno.size()
        for(ano in retorno){
            assert ano  >=2010
            assert ano <=anoAtual
        }

    }

    @Test
    void testarsomarCompetencia(){
        def competencia = CalcCompetenciaUtil.converterStringParaData('01/05/2015')
        def retorno = CalcCompetenciaUtil.somarCompetencia(competencia,2)
        assert retorno.format('MM')=='07'
        assert  retorno.format('yyyy')=='2015'
        assert  retorno.format('dd')=='01'


        retorno = CalcCompetenciaUtil.somarCompetencia(competencia,null)
        assert retorno ==null

    }

    @Test
    void testarprimeiroDiaAno(){
        def retorno = CalcCompetenciaUtil.primeiroDiaAno(2014)
        assert retorno.format('MM')=='01'
        assert  retorno.format('yyyy')=='2014'
        assert  retorno.format('dd')=='01'

         retorno = CalcCompetenciaUtil.primeiroDiaAno(null)
        assert retorno ==null


         retorno = CalcCompetenciaUtil.primeiroDiaAno(2017)
        assert retorno.format('MM')=='01'
        assert  retorno.format('yyyy')=='2017'
        assert  retorno.format('dd')=='01'
    }

    @Test
    void testarultimoDiaAno(){
        def retorno = CalcCompetenciaUtil.ultimoDiaAno(2014)
        assert retorno.format('MM')=='12'
        assert  retorno.format('yyyy')=='2014'
        assert  retorno.format('dd')=='31'

        retorno = CalcCompetenciaUtil.ultimoDiaAno(null)
        assert retorno ==null

    }
}
