public class Block {

	private boolean show;
	private boolean moving;

	public Block() {
		this.show = false;
		this.moving = false;
	}

	public Block(boolean show, boolean moving) {
		this.show = show;
		this.moving = moving;
	}

	public void init() {
		this.moving = true;
		this.show = true;
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

}
