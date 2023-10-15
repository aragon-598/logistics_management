package com.ingeneo.logisticmanagement.services;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.models.Envio;
import com.ingeneo.logisticmanagement.models.TipoEnvio;
import com.ingeneo.logisticmanagement.repository.EnvioRepository;

@Service
@Transactional
public class EnvioServiceImp implements EnvioService {

    @Autowired
    EnvioRepository envioRepository;

    @Autowired
    TipoBodegaService tipoBodegaService;

    @Override
    public List<Envio> getEnvios() {
        return envioRepository.findAll();
    }

    @Override
    public List<Envio> getEnviosByTipoEnvio(TipoEnvio tipoEnvio) {
        return envioRepository.findByTipoEnvio(tipoEnvio);
    }

    @Override
    public Envio getById(int idEnvio) {
        return envioRepository.findById(idEnvio).orElse(null);
    }

    @Override
    public Envio saveEnvio(Envio Envio) {
        String idTransporte = generateIdTransporte();
        String numeroGuia = generateNumeroGuia();
        while (envioRepository.existsByNumeroGuia(idTransporte)) {
            idTransporte = generateIdTransporte();
        }
        while (envioRepository.existsByNumeroGuia(numeroGuia)) {
            numeroGuia = generateNumeroGuia();
        }
        Envio.setIdTransporte(idTransporte);
        Envio.setNumeroGuia(numeroGuia);
        
        return envioRepository.save(generateDiscount(Envio));
    }

    @Override
    public boolean deleteEnvioById(int idEnvio) {
        boolean exists = existsEnvio(idEnvio);
        if (exists){
            envioRepository.deleteById(idEnvio);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsEnvio(int idEnvio) {
        return envioRepository.existsById(idEnvio);
    }

    @Override
    public List<Envio> getEnviosByCliente(Cliente cliente) {
        return envioRepository.findByCliente(cliente);
    }

    @Override
    public String generateNumeroGuia() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @Override
    public String generateIdTransporte() {
        Random rand = new Random();
        StringBuilder cadena = new StringBuilder();

        // Generar 3 letras iniciales
        for (int i = 0; i < 3; i++) {
            char letra = (char) (rand.nextInt(26) + 'A');
            cadena.append(letra);
        }

        // Generar 4 números
        for (int i = 0; i < 4; i++) {
            int numero = rand.nextInt(10);
            cadena.append(numero);
        }

        // Generar una letra final
        char letraFinal = (char) (rand.nextInt(26) + 'A');
        cadena.append(letraFinal);

        return cadena.toString();
    }

    @Override
    public Envio generateDiscount(Envio envio){
        String tipoTransporte = envio.getBodega().getTipoBodega().getNombre();
        double precioEnvio = envio.getPrecioEnvio();
        int cantidad = envio.getCantidad();
        double descuento= 0;

        if(cantidad>=10 &&  tipoTransporte.equals("MARITIMO")){
            descuento = 0.03;
        }
        if(cantidad>=10 &&  tipoTransporte.equals("TERRESTRE")){
            descuento = 0.05;
        }
        precioEnvio = precioEnvio -(precioEnvio*descuento);

        envio.setDescuento(descuento);
        envio.setPrecioEnvio(precioEnvio);
        return envio;
    }

    @Override
    public Envio updateEnvio(Envio Envio) {
        return envioRepository.save(generateDiscount(Envio));
    }

    
}
