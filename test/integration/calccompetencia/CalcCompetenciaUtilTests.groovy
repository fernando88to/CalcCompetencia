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
    }
}
