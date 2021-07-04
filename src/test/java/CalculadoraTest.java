import com.example.cadastroDeAnuncios.Calculadora;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CalculadoraTest {

    @Test
    public void verificaSeAQuantidadeDeVisualizaçõesEhProporcionalAoValorInvestido(){
        Calculadora calculadora = new Calculadora();
        int visualizacoesEsperadas = 300;

        int visualizacoesRecebidas = calculadora.visualizacoesOriginais(10);

        Assert.assertEquals(visualizacoesEsperadas, visualizacoesRecebidas);
    }

    @Test
    public void verificaSeAQuantidadeDeCliquesRecebidosEhProporcionalAoNumeroDeVisualizacoes(){
        Calculadora calculadora = new Calculadora();
        int cliquesEsperados = 24;

        int cliquesRecebidos = calculadora.cliquesRecebidos(200);

        Assert.assertEquals(cliquesEsperados, cliquesRecebidos);
    }

    @Test
    public void verificaSeAQuantidadeDeCompartilhamentosEhProporcionalAQuantidadeDeCliques(){
        Calculadora calculadora = new Calculadora();
        int compartilhamentosEsperados = 6;

        int compartilhamentosRealiazdos = calculadora.compartilhamentosRealizados(40);

        Assert.assertEquals(compartilhamentosEsperados, compartilhamentosRealiazdos);
    }

    @Test
    public void verificaONumeroDeNovasVisualizacoesComBaseNoNumeroDeCompartilhamentos(){
        Calculadora calculadora = new Calculadora();
        int visualizacoesEsperadas = 120;

        int visualizacoesRecebidas = calculadora.novasVisualizacoes(5);

        Assert.assertEquals(visualizacoesEsperadas, visualizacoesRecebidas);
    }

    @Test
    public void retornaONumeroTotalDeVisualizacoes(){
        Calculadora calculadora = new Calculadora();
        int visualizacoesEsperadas = 4500;

        int visualizacoesRecebidas = calculadora.visualiacoesTotais(30);

        Assert.assertEquals(visualizacoesEsperadas, visualizacoesRecebidas);
    }
}