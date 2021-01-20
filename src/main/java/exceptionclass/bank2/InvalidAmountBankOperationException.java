package exceptionclass.bank2;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {

    public InvalidAmountBankOperationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
