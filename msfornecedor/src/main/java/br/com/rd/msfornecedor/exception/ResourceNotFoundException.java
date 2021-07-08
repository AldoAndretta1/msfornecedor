package br.com.rd.msfornecedor.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7980438940583952544L;
	
	private static final String MESSAGE = "recurso %s não encontrado.";
    private static final String MESSAGE_ID = "recurso %s com identificador %d não encontrado.";

    public ResourceNotFoundException(String entityName) {
        super(entityName);
    }

    public ResourceNotFoundException(String entityName, Throwable causa) {
        super(String.format(MESSAGE, entityName), causa);
    }

    public ResourceNotFoundException(String entityName, Long id) {
        super(String.format(MESSAGE_ID, entityName, id));
    }

    public ResourceNotFoundException(String entityName, Long id, Throwable causa) {
        super(String.format(MESSAGE_ID, entityName, id), causa);
    }

}