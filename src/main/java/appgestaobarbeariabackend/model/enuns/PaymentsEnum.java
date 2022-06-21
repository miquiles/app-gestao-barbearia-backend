package appgestaobarbeariabackend.model.enuns;

public enum PaymentsEnum {
    CASH,
    PIX,
    CREDITCARD,
    DEBITCARD;

    public static String getCash(){
        return CASH.toString();
    }

    public static String getPix(){
        return PIX.toString();
    }


    public static String getCreditCard(){
        return CREDITCARD.toString();
    }


    public static String getDebitCard(){
        return DEBITCARD.toString();
    }
}
