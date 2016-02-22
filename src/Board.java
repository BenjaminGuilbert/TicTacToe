

public class Board {

	private Token[] _board;
	
	public Board(){
		this._board = new Token[9];
		for(int i=0; i<9; i++){
			this._board[i] = Token.EMPTY;
		}
	}
	
	public void setToken(int index, Players p){
		this._board[index] = p.getToken();
	}
	
	public Token getToken(int index){
		return this._board[index];
	}
	
	
	public boolean isEmpty(int index){
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
