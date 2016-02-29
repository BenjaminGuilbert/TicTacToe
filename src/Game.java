import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Game extends BasicGame {
	
    private Rectangle[] uiSquares = new Rectangle[9];
    private Image[] sprites = new Image[2];
    private Image fond;
    private Board board;
	private GameContainer container;
	private Players player;
	private String errorMessage="";
	
	//Constructor
	public Game(){
		super("tic-tac-toe");		
		this.player = new Players();
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		//display lines
		fond.draw(0,0);
		g.drawLine(45, 175, 435, 175);
        g.drawLine(45, 305, 435, 305);
        g.drawLine(175, 45, 175, 435);
        g.drawLine(305, 45, 305, 435);
        g.drawLine(480, 0, 480, 480);
        
        
        //display cross or circle in board
        for(int i=0; i<9; i++){
        	if(!this.board.isEmpty(i)){
        		int row = (i<3)?45:(i<6)?175:305;
        		sprites[this.board.getToken(i).ordinal()].draw(130*(i%3)+46,row+1);
        	}
        }
        
        //display some informations
        g.drawString("esc : quit\ni : init", 500, 20);        
        g.drawString("Turn: " + this.player.getToken(), 500, 90);
        g.drawString(this.errorMessage, 500, 140);
        
        //display the winner
        Token winner = this.board.getWinner();
        if(!winner.isEmpty())
        	g.drawString("The winner is "+ winner.toString()+".", 500, 200);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		this.board = new Board();
		sprites[Token.CROSS.ordinal()] = new Image("pictures/cross.png");
        sprites[Token.CIRCLE.ordinal()] = new Image("pictures/circle.png");
        fond = new Image("pictures/fond.png");
		
        for (int i = 0; i < 9; i++) {
            uiSquares[i] = new Rectangle(57 + 130 * (i % 3),
                                         57 + 130 * (i / 3),
                                         105, 105);
        }
        
        
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	//method to check is the place is empty before to put a token
	private void checkAndSetToken(int index){
		if(this.board.isEmpty(index)){
    		this.board.setToken(index, this.player);
    		this.errorMessage="";
    		this.player.nextPlayer();
    	}
    	else {
    		this.errorMessage = "This location is already check by\n -> "+this.board.getToken(index)+".\n Choose another place.";
    	}
	}
	
	//method to read the mouse event
	public void mousePressed(int Button, int y, int x){
		int index=-1;
		if(Button == 0){
			if(x>45 && x<175){
				index=0;				
			}else if(x>175 && x<305){
				index=3;
			}else if(x>305 && x<435){
				index=6;
			}
			
			if(y>45 && y<175){
				index+=0;				
			}else if(y>175 && y<305){
				index+=1;
			}else if(y>305 && y<435){
				index+=2;
			}
			
			if(index>-1)this.checkAndSetToken(index);
		}		
	}
	
	//method to read the event keyboard
    @Override
    public void keyReleased(int key, char c) {

        switch(key){
        case Input.KEY_ESCAPE:
        	container.exit();
        	break;
        case Input.KEY_E:
        	this.checkAndSetToken(0);
        	break;
        case Input.KEY_R:
        	this.checkAndSetToken(1);
        	break;
        case Input.KEY_T:
        	this.checkAndSetToken(2);
        	break;
        case Input.KEY_D:
        	this.checkAndSetToken(3);
        	break;
        case Input.KEY_F:
        	this.checkAndSetToken(4);
        	break;
        case Input.KEY_G:
        	this.checkAndSetToken(5);
        	break;
        case Input.KEY_C:
        	this.checkAndSetToken(6);
        	break;
        case Input.KEY_V:
        	this.checkAndSetToken(7);
        	break;
        case Input.KEY_B:
        	this.checkAndSetToken(8);
        	break;
        case Input.KEY_I:
        	try {
				this.init(this.container);
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        }
        
    }
	
    // main method
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new Game(), 800, 600, false).start();
	}

}
