package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.utils.AppMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.service.ClienteService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	public static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		Boolean existeCliente = cliente.isPresent();

		Cliente result = null;

		if (Boolean.TRUE.equals(existeCliente)) {
			result = cliente.get();
		}

		return result;
	}

	@Override
	public void inserir(Cliente cliente) {
		try {
			clienteRepository.save(cliente);
			logger.info(AppMessages.clienteInsertedSuccess(cliente.getNome()));
		} catch (Exception e) {
			logger.error(AppMessages.anErrorHasOcurred(e));
		}
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			clienteRepository.save(cliente);
		} else {
			logger.info(AppMessages.objectNotFoud(cliente.getNome()));
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		try {
			clienteRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(AppMessages.anErrorHasOcurred(e));
		}
	}

}
