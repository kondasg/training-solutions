package exceptionclass.bank2;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException {

    public InvalidAccountNumberBankOperationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
