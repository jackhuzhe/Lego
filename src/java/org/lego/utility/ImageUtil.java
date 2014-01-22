package org.lego.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageUtil {

	private static int WIDTH_UNIT = 5;
	private static int HEIGHT_UNIT = 3;
	private static int BASE_PIXEL_UNIT = 50;

	public static BufferedImage getImageBit(String FileName) {
		File file = new File(FileName);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bi;
	}

	public static BufferedImage getSubImageBit(BufferedImage bi) {

		// TODO 0,0,50,50 means 2500
		return bi.getSubimage(0, 0, 50, 50);
	}

	public static List<BufferedImage> getSubImageBits(BufferedImage bi) {
		List<BufferedImage> list = new ArrayList<BufferedImage>();

		for (int i = 0; i < WIDTH_UNIT; i++) {
			for (int j = 0; j < HEIGHT_UNIT; j++) {
				list.add(bi.getSubimage(i * BASE_PIXEL_UNIT, j
						* BASE_PIXEL_UNIT, BASE_PIXEL_UNIT, BASE_PIXEL_UNIT));
			}
		}
		// TODO 0,0,50,50 means 2500
		// list.add(bi.getSubimage(0, 0, 50, 50));
		// bi.getSubimage(0, 0, 50, 50);
		List<BufferedImage> cloneList = new ArrayList<BufferedImage>();

		cloneList.addAll(list);
		return cloneList;
	}
}
