package br.com.imd.cadwork.core.localizavel.service;

import br.com.imd.cadwork.CadworkapiApplication;
import br.com.imd.cadwork.core.localizacao.domain.EstadosEnum;
import br.com.imd.cadwork.core.localizacao.domain.Municipio;
import br.com.imd.cadwork.core.localizacao.service.MunicipioService;
import br.com.imd.cadwork.core.service.exception.GenericServiceException;
import br.com.imd.cadwork.core.service.exception.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindingResult;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@TestPropertySource(locations="classpath:application.properties")
@ContextConfiguration(classes = {CadworkapiApplication.class})
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = {"br.com.imd.cadwork.core.resources","br.com.imd.cadwork.core.config"}))
public class MunicipioServiceTests {

    @Autowired
    MunicipioService municipioService;

    @Test
    public void testSalvarMunicipio() throws GenericServiceException {

        Municipio municipio = new Municipio();

        municipio.setNome("Natal");
        municipio.setEstado(EstadosEnum.TOCANTINS);

        BindingResult bindingResultMock = Mockito.mock(BindingResult.class);
        Mockito.when(bindingResultMock.hasErrors()).thenReturn(false);

        municipioService.salvar(municipio,bindingResultMock);

        Assert.assertFalse(municipioService.listar().isEmpty());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testSalvarMunicipio_ComErrosNoCadastro() throws GenericServiceException {

        Municipio municipio = new Municipio();

        municipio.setNome("Natalondon");
        municipio.setEstado(EstadosEnum.TOCANTINS);

        BindingResult bindingResultMock = Mockito.mock(BindingResult.class);
        Mockito.when(bindingResultMock.hasErrors()).thenReturn(true);

        municipioService.salvar(municipio,bindingResultMock);

    }

}
