package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Atendimento;
import one.digitalinnovation.gof.model.Cliente;

public interface AtendimentoService {

    void inserirAtendimento(Cliente cliente, Atendimento atendimenteo);

    void feedbackDoCliente(Atendimento atendimento, Long idAtendimento);

    Boolean atendimentoFinalizado(Cliente cliente, Long id);

    Boolean resolverAtendimento(Long id);

}
