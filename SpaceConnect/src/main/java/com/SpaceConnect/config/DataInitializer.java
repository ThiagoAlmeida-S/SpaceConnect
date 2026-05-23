package com.SpaceConnect.config;

import com.SpaceConnect.model.*;
import com.SpaceConnect.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SensorRepository sensorRepository;
    private final ReservatorioRepository reservatorioRepository;
    private final ClimatizacaoRepository climatizacaoRepository;
    private final AlertaRepository alertaRepository;
    private final TripulanteRepository tripulanteRepository;
    private final ConsumoEnergiaRepository consumoEnergiaRepository;

    @Override
    public void run(String... args) throws Exception {

        // Sensores
        Sensor s1 = new Sensor();
        s1.setNome("Sensor de Temperatura - Módulo A");
        s1.setTipo("TEMPERATURA");
        s1.setLocalizacao("Módulo A");
        s1.setAtivo(true);
        s1.setUltimaLeitura(22.5);
        s1.setDataLeitura(LocalDateTime.now());
        s1.setStatus(StatusSensor.OPERACIONAL);
        s1.setLimiteMinimo(15.0);
        s1.setLimiteMaximo(40.0);
        sensorRepository.save(s1);

        Sensor s2 = new Sensor();
        s2.setNome("Sensor de Pressão - Módulo B");
        s2.setTipo("PRESSAO");
        s2.setLocalizacao("Módulo B");
        s2.setAtivo(true);
        s2.setUltimaLeitura(101.3);
        s2.setDataLeitura(LocalDateTime.now());
        s2.setStatus(StatusSensor.OPERACIONAL);
        s2.setLimiteMinimo(90.0);
        s2.setLimiteMaximo(120.0);
        sensorRepository.save(s2);

        Sensor s3 = new Sensor();
        s3.setNome("Sensor de Oxigênio - Módulo C");
        s3.setTipo("OXIGENIO");
        s3.setLocalizacao("Módulo C");
        s3.setAtivo(true);
        s3.setUltimaLeitura(95.0);
        s3.setDataLeitura(LocalDateTime.now());
        s3.setStatus(StatusSensor.OPERACIONAL);
        s3.setLimiteMinimo(80.0);
        s3.setLimiteMaximo(100.0);
        sensorRepository.save(s3);

        // Reservatorios
        Reservatorio r1 = new Reservatorio();
        r1.setNome("Reservatório de Oxigênio - Módulo A");
        r1.setTipo("OXIGENIO");
        r1.setCapacidadeMaxima(1000.0);
        r1.setNivelAtual(750.0);
        r1.setNivelCritico(200.0);
        r1.setPercentualAtual(75.0);
        r1.setUnidade("Litros");
        r1.setStatus("NORMAL");
        reservatorioRepository.save(r1);

        Reservatorio r2 = new Reservatorio();
        r2.setNome("Reservatório de Água - Módulo B");
        r2.setTipo("AGUA");
        r2.setCapacidadeMaxima(500.0);
        r2.setNivelAtual(250.0);
        r2.setNivelCritico(100.0);
        r2.setPercentualAtual(50.0);
        r2.setUnidade("Litros");
        r2.setStatus("NORMAL");
        reservatorioRepository.save(r2);

        // Climatizacao
        Climatizacao c1 = new Climatizacao();
        c1.setSetor("Módulo de Habitação");
        c1.setTemperaturaAtual(22.0);
        c1.setTemperaturaDesejada(21.0);
        c1.setUmidade(50.0);
        c1.setPressaoAtmosferica(101.3);
        c1.setSistemaAtivo(true);
        c1.setStatus("NORMAL");
        climatizacaoRepository.save(c1);

        Climatizacao c2 = new Climatizacao();
        c2.setSetor("Módulo Científico");
        c2.setTemperaturaAtual(18.0);
        c2.setTemperaturaDesejada(20.0);
        c2.setUmidade(45.0);
        c2.setPressaoAtmosferica(101.3);
        c2.setSistemaAtivo(true);
        c2.setStatus("NORMAL");
        climatizacaoRepository.save(c2);

        // Alertas
        Alerta a1 = new Alerta();
        a1.setTitulo("Nível Crítico de Oxigênio");
        a1.setDescricao("Reservatório de oxigênio abaixo do nível crítico");
        a1.setRecursoAfetado("Reservatório de Oxigênio - Módulo A");
        a1.setResolvido(false);
        a1.setResolvidoPor("");
        a1.setDataHora(LocalDateTime.now());
        a1.setNivel(NivelAlerta.CRITICO);
        alertaRepository.save(a1);

        Alerta a2 = new Alerta();
        a2.setTitulo("Temperatura Elevada");
        a2.setDescricao("Sensor de temperatura acima do limite no Módulo A");
        a2.setRecursoAfetado("Sensor de Temperatura - Módulo A");
        a2.setResolvido(false);
        a2.setResolvidoPor("");
        a2.setDataHora(LocalDateTime.now());
        a2.setNivel(NivelAlerta.AVISO);
        alertaRepository.save(a2);

        // Tripulantes
        Tripulante t1 = new Tripulante();
        t1.setNome("João Faria");
        t1.setDataEntrada(LocalDate.now());
        t1.setCargo(CargaTripulante.COMANDANTE);
        t1.setStatusSaude(StatusSaude.BEM);
        tripulanteRepository.save(t1);

        Tripulante t2 = new Tripulante();
        t2.setNome("Maria Silva");
        t2.setDataEntrada(LocalDate.now());
        t2.setCargo(CargaTripulante.CIENTISTA);
        t2.setStatusSaude(StatusSaude.BEM);
        tripulanteRepository.save(t2);

        Tripulante t3 = new Tripulante();
        t3.setNome("Carlos Souza");
        t3.setDataEntrada(LocalDate.now());
        t3.setCargo(CargaTripulante.ENGENHEIRO);
        t3.setStatusSaude(StatusSaude.MONITORAMENTO);
        tripulanteRepository.save(t3);

        // Consumo Energia
        ConsumoEnergia ce1 = new ConsumoEnergia();
        ce1.setNomeSetor("Módulo de Habitação");
        ce1.setConsumoKwh(150.5);
        ce1.setDataRegistro(LocalDateTime.now());
        ce1.setFonte(FonteEnergia.SOLAR);
        consumoEnergiaRepository.save(ce1);

        ConsumoEnergia ce2 = new ConsumoEnergia();
        ce2.setNomeSetor("Módulo Científico");
        ce2.setConsumoKwh(200.0);
        ce2.setDataRegistro(LocalDateTime.now());
        ce2.setFonte(FonteEnergia.NUCLEAR);
        consumoEnergiaRepository.save(ce2);
    }
}