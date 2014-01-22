package org.lego.element;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.lego.process.ImageToLego;
import org.lego.utility.LegoUtil;

public class Lego1and1 extends LegoBlock {
	private List<ImageBit> oneAndOneList = new ArrayList<ImageBit>();
	
	public Lego1and1(Graphics g) {
	    this.blockSize = BlockSize.OneAndOne;
		this.width = 1;
		this.height = 1;
		this.g = g;

		ImageToLego.legoPointMap.put(BlockType.OneAndOne,
				oneAndOneList);
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
						BlockType.OneAndOne);
				if (ib.isCovered()) {
					System.out.println(ib.getX() + "," + ib.getY() + ","
							+ ib.getRGB() + "," + ib.isCovered() + ","
							+ ib.getBlockType());
					oneAndOneList.add(ib);
					draw(g, ib, this.width, this.height);

				}

			}
		}
	}


}
