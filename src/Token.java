
public enum Token {
	CROSS,
	CIRCLE,
	EMPTY;
	
	public boolean isEmpty(){
		return this == Token.EMPTY;
	}

}
