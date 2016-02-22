
public class Players {

	private Token token;
	
	public Players(){
		this.token = Token.CROSS;
	}
	
	public void nextPlayer(){
		if(this.token == Token.CROSS){
			this.token = Token.CIRCLE;
		}
		else {
			this.token = Token.CROSS;
		}
		
	}
	
	public Token getToken(){
		return this.token;
	}
	
}
