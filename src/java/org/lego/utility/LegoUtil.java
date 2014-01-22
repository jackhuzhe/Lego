package org.lego.utility;

import java.util.LinkedList;
import java.util.List;

import org.lego.element.BlockType;
import org.lego.element.ImageBit;

public class LegoUtil {

	public static List<ImageBit> cover(ImageBit ib, ImageBit[][] list,
			int blockWidth, int blockHeight, BlockType blockType) {
		// TODO Auto-generated method stub
		int baseX = ib.getX();
		int baseY = ib.getY();

		List<ImageBit> coverBits = new LinkedList<ImageBit>();

		for (int i = 0; i < blockWidth; i++) {
			// FIXME
			if ((i + baseX) > 49) {
				return null;
			}
			for (int j = 0; j < blockHeight; j++) {
				// FIXME
				if ((j + baseY) > 49) {
					return null;
				}
				if(list[baseX + i][baseY + j].isCovered()){
					return null;
				}
				if (list[baseX + i][baseY + j].getRGB() == ib.getRGB()) {
					coverBits.add(list[baseX + i][baseY + j]);
				} else {
					return null;
				}
			}
		}

		// FIXME
		if (!coverBits.isEmpty()) {
			for (ImageBit imageBit : coverBits) {
				imageBit.setCovered(true);
				imageBit.setBlockType(blockType);
				// TODO set lego type,size and sequence and save the lego list.
			}
		}

		return coverBits;
	}
}
