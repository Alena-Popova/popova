package popova.collection.вanktransfers.exceptions;

public class TransferError extends RuntimeException{
    public TransferError (String tr) {
        super(tr);
    }
}
