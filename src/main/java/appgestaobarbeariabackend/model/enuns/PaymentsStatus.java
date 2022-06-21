package appgestaobarbeariabackend.model.enuns;

public enum PaymentsStatus {

    PAGO,
    PENDENTE;

    public static String getPago(){
        return PAGO.toString();
    }

    public static String getPendente(){
        return PENDENTE.toString();
    }
}
