public class Block {

	private boolean show;
	private boolean moving;
	private char type;

	public Block() {
		this.show = false;
		this.moving = false;
		this.type = '.';
	}

	public Block(boolean show, boolean moving) {
		this.show = show;
		this.moving = moving;
		this.type = '.';
	}

	public Block(boolean show, boolean moving, char type) {
		this.show = show;
		this.moving = moving;
		this.type = type;
	}

	public void init(char type) {
		this.moving = true;
		this.show = true;
		this.type = type;
	}

	public void stop() {
		this.moving = false;
	}

	public boolean show() {
		return show;
	}

	public boolean moving() {
		return moving;
	}

	public char type() {
		return type;
	}

	@Override
	public Block clone() {
		return new Block(this.show, this.moving, this.type);
	}

}
