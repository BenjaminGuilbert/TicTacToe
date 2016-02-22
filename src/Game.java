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
    private Board board;
	private GameContainer container;
	private Players player;
	

	public Game(){
		super("tic-tac-toe");
		this.board = new Board();
		this.player = new Players();
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		g.drawLine(45, 175, 435, 175);
        g.drawLine(45, 305, 435, 305);

        g.drawLine(175, 45, 175, 435);
        g.drawLine(305, 45, 305, 435);

        g.drawLine(480, 0, 480, 480);
        /*
        for(int i=0; i<9; i++){
        	if(!this.board.isEmpty(i)){
        		sprites[this.player.getToken().ordinal()].draw(100*i,100+i);
        	}
        }*/
        sprites[Token.CROSS.ordinal()].draw(100,100);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		sprites[Token.CROSS.ordinal()] = new Image("pictures/cross.png");
        sprites[Token.CIRCLE.ordinal()] = new Image("pictures/circle.png");
		
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
	
    @Override
    public void keyReleased(int key, char c) {

        switch(key){
        case Input.KEY_ESCAPE:
        	container.exit();
        	break;
        case Input.KEY_A:
        	this.board.setToken(0, this.player);
        	break;
        case Input.KEY_Z:
        	this.board.setToken(1, this.player);
        	break;
        case Input.KEY_E:
        	this.board.setToken(2, this.player);
        	break;
        }
        this.player.nextPlayer();
    }
	
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new Game(), 800, 600, false).start();
	}

}
