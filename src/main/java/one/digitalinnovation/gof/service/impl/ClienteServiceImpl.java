package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import one.digitalinnovation.gof.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
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
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
		//TODO - tratar o else, quando o cliente não estiver presente
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);

		//TODO tratar caso o id não esteja presente
	}

	@Override
	public Iterable<Compra> buscarComprasUsandoIdCliente(Long idCliente) {
		//TODO
		return null;
	}

	@Override
	public Iterable<Atendimento> buscarAtendimentosUsandoIdCliente(Long idCliente) {
		//TODO
		return null;
	}

	private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});

		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}

}
