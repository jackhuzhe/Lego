package org.lego.process;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.util.List;

import org.junit.Test;
import org.lego.element.ImageBit;
import org.lego.service.ConvertImageToLegoService;
import org.lego.utility.ImageUtil;

public class ImageToLegoTest {

	@Test
	public void testMain() {
		BufferedImage originBi = ImageUtil
				.getImageBit("src/resource/finaldesign.bmp");
		
		BufferedImage resultBi = ImageUtil
				.getImageBit("2.bmp");
		
		ConvertImageToLegoService convertImageToLegoService = new ConvertImageToLegoService();

		int count = 0;
		List<BufferedImage> subBiList = ImageUtil.getSubImageBits(originBi);
		for (BufferedImage subBi : subBiList) {

			ImageBit[][] originBiList = convertImageToLegoService.convertImageToBit(
					subBi, count);
			
			ImageBit[][] resultBiList = convertImageToLegoService.convertImageToBit(
					resultBi, count);

			for (int i=0;i<50;i++){
				for(int j=0;j<50;j++){
					if(!originBiList[i][j].equals(resultBiList[i][j])){
						fail("Wrong");
					}
					
				}
			}
		}
	}

}
