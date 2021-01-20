package exceptionclass.bank2;

public class LowBalanceBankOperationException extends InvalidBankOperationException {

    public LowBalanceBankOperationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
