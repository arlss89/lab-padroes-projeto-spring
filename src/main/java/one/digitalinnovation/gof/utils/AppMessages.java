package one.digitalinnovation.gof.utils;

public interface AppMessages {

    public static String anErrorHasOcurred() {
        return "An error occurred!";
    }

    public static String anErrorHasOcurred(Exception e) {
        return "An error occurred! " + e.getMessage();
    }

    public static String clienteInsertedSuccess() {
        return "Cliente inserido com sucesso";
    }

    public static String clienteInsertedSuccess(String name) {
        return "Cliente inserido com sucesso: " + name;
    }

    public static String clienteUpdatedSuccess() {
        return "Cliente atualizado com sucesso";
    }

    public static String clienteUpdatedSuccess(String name) {
        return "Cliente atualizado com sucesso: " + name;
    }

    public static String objectNotFoud(String name) {
        return name + "object not found.";
    }

    static String sendedToKafka(String nome) {
        return "Cliente adicionado: " + nome;
    }
}
