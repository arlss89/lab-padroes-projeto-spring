package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Atendimento;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.AtendimentoService;

public class AtendimentoServiceImpl implements AtendimentoService {

    @Override
    public void inserirAtendimento(Cliente cliente, Atendimento atendimenteo) {
        //TODO
    }

    @Override
    public Boolean atendimentoFinalizado(Cliente cliente, Long id) {
        //TODO
        return false;
    }

    @Override
    public Boolean resolverAtendimento(Long id) {
        //TODO
        return false;
    }

    @Override
    public void feedbackDoCliente(Atendimento atendimento, Long idAtendimento) {
        //TODO
    }
}
