

public class Board {

	private Token[] _board;
	
	public Board(){
		this._board = new Token[9];
	}
	
	public void getToken(int x, int y, Token t){
		int index = x+(3*y+1);
		this._board[index] = t;
	}
	
	public Token setToken(int x, int y){
		int index = x+(3*y+1);
		return this._board[index];
	}
	
	public Boolean isEmpty(int x, int y){
		int index = x+(3*y+1);
		return this._board[index].isEmpty();
	}
	
	public Token getWinner(){
		Token winner = Token.EMPTY;

		for(int i=0; i<3; i++){
			if(this._board[3*i].equals(this._board[3*i+1]) && this._board[3*i].equals(this._board[3*i+2]) ){
				winner = this._board[3*i];
			}
			if(this._board[i].equals(this._board[i+3]) && this._board[3*i].equals(this._board[i+6]) ){
				winner = this._board[i];
			}
		}
		if(this._board[0].equals(this._board[4]) && this._board[0].equals(this._board[8]) ){
			winner = this._board[0];
		}
		if(this._board[2].equals(this._board[4]) && this._board[2].equals(this._board[6]) ){
			winner = this._board[2];
		}
		
		return winner;
	}
}
