package org.lego.element;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.lego.process.ImageToLego;
import org.lego.utility.LegoUtil;

public class Lego2and2 extends LegoBlock{

	private List<ImageBit> twoAndTwoList = new ArrayList<ImageBit>();
	
	public Lego2and2(Graphics g) {
	    this.blockSize = BlockSize.TwoAndTwo;
		this.width = 2;
		this.height = 2;
		this.g = g;

		ImageToLego.legoPointMap.put(BlockType.TwoAndTwo,
				twoAndTwoList);
	}


	@Override
	public void cover(ImageBit[][] list) {
		ImageBit ib = new ImageBit();
		
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				ib = list[i][j];
				if (ib.isCovered()) {
					continue;
				}
				LegoUtil.cover(ib, list, this.width, this.height,
						BlockType.TwoAndTwo);
				if (ib.isCovered()) {
					System.out.println(ib.getX() + "," + ib.getY() + ","
							+ ib.getRGB() + "," + ib.isCovered() + ","
							+ ib.getBlockType());
					twoAndTwoList.add(ib);
					draw(g, ib, this.width, this.height);


				}

			}
		}
	}

}
