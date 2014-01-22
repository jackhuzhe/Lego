package org.lego.element;

public class ImageBit {

	private int x;

	private int y;

	private int RGB;

	private boolean isCovered = false;

	private BlockType blockType;

	private Quadrant quadrant;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRGB() {
		return RGB;
	}

	public void setRGB(int rGB) {
		RGB = rGB;
	}

	public boolean isCovered() {
		return isCovered;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}

	public BlockType getBlockType() {
		return blockType;
	}

	public void setBlockType(BlockType blockType) {
		this.blockType = blockType;
	}

	/**
	 * @param quadrant
	 *            the quadrant to set
	 */
	public void setQuadrant(Quadrant quadrant) {
		this.quadrant = quadrant;
	}

	/**
	 * @return the quadrant
	 */
	public Quadrant getQuadrant() {
		return quadrant;
	}

	public boolean equals(ImageBit ib) {
		if ((this.getRGB() == ib.getRGB()) && (this.getX() == ib.getX())
				&& (this.getY() == ib.getY())) {

			return true;
		}
		return false;
	}
}
