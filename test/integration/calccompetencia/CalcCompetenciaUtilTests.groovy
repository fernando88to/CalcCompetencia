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
    void testarCapturarCompetenica() {
        def retorno  = CalcCompetenciaUtil.capturarCompetencia(new Date())
        assert  retorno != null
    }
}
