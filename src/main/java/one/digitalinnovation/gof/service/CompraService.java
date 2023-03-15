package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Compra;

public interface CompraService {

    void inserirCompra(Cliente cliente, Compra compra);

    void devolucaoCompra(Cliente cliente, Long idCompra);

}
