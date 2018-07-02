package br.com.imd.cadwork.core.localizavel.service;

import br.com.imd.cadwork.CadworkapiApplication;
import br.com.imd.cadwork.core.localizacao.domain.Endereco;
import br.com.imd.cadwork.core.localizacao.domain.EstadosEnum;
import br.com.imd.cadwork.core.localizacao.domain.Municipio;
import br.com.imd.cadwork.core.localizacao.domain.TipoLocalizacaoEnum;
import br.com.imd.cadwork.core.localizacao.service.EnderecoService;
import br.com.imd.cadwork.core.localizacao.service.MunicipioService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindingResult;

import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestPropertySource(locations="classpath:application.properties")
@ContextConfiguration(classes = {CadworkapiApplication.class})
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = {"br.com.imd.cadwork.core.resources","br.com.imd.cadwork.core.config"}))
public class EnderecoServiceTests {

    @Autowired
    EnderecoService enderecoService;

    @Mock
    BindingResult bindingResultMock;

    @Mock
    Municipio municipio;

    @Autowired
    MunicipioService municipioService;

    @Before
    public void insereMunicipio() throws GenericServiceException {
        Municipio municipio = new Municipio();

        municipio.setNome("Natal");
        municipio.setEstado(EstadosEnum.TOCANTINS);

        municipioService.salvar(municipio,bindingResultMock);

    }

    @Test
    public void testSalvarEndereco() throws GenericServiceException {

        List<Municipio> listar = municipioService.listar();

        Endereco endereco = new Endereco();
        endereco.setBairro("Teste");
        endereco.setCep("Teste");
        endereco.setComplemento("Teste");
        endereco.setLatitude(0d);
        endereco.setLongitude(0);
        endereco.setLogradouro("Teste");
        endereco.setTipoLocalizacao(TipoLocalizacaoEnum.Urbana);
        endereco.setNumero("467");

        Mockito.when(municipio.getId()).thenReturn(1l);

        endereco.setMunicipio(municipio);

        Mockito.when(bindingResultMock.hasErrors()).thenReturn(false);

        enderecoService.salvar(endereco,bindingResultMock);

        Assert.assertFalse(enderecoService.listar().isEmpty());
    }

    @Test(expected = GenericServiceException.class)
    public void testSalvarMunicipio_ComErrosNoCadastro() throws GenericServiceException {

        Endereco endereco = new Endereco();

        Mockito.when(bindingResultMock.hasErrors()).thenReturn(true);

        enderecoService.salvar(endereco,bindingResultMock);

    }

}
