import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Game extends BasicGame {
	
	private GameContainer container;
	private Image[] sprites = new Image[2];
    private Rectangle[] uiSquares = new Rectangle[9];
	public static final int CROSS = 0;
	public static final int CIRCLE = 1;

	public Game() {
		super("tic-tac-toe");
		try {
			sprites[Game.CROSS] = new Image("pictures/cross.png");
			sprites[Game.CIRCLE] = new Image("res/circle.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
        for (int i = 0; i < 9; i++) {
            uiSquares[i] = new Rectangle(57 + 130 * (i % 3),
                                         57 + 130 * (i / 3),
                                         105, 105);
        }
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		g.drawLine(45, 175, 435, 175);
        g.drawLine(45, 305, 435, 305);

        g.drawLine(175, 45, 175, 435);
        g.drawLine(305, 45, 305, 435);

        g.drawLine(480, 0, 480, 480);

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;

	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new Game(), 800, 600, false).start();
	}

}
