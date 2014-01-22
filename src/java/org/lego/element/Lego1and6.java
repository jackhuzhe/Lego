package org.lego.element;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.lego.process.ImageToLego;
import org.lego.utility.LegoUtil;

public class Lego1and6 extends LegoBlock {

    private List<ImageBit> sixAndOneList = new ArrayList<ImageBit>();
    private List<ImageBit> oneAndSixList = new ArrayList<ImageBit>();
    
    public Lego1and6(Graphics g) {
        this.blockSize = BlockSize.OneAndSix;
        this.width = 6;
        this.height = 1;
        this.g = g;

        ImageToLego.legoPointMap.put(BlockType.SixAndOne,
                sixAndOneList);
        ImageToLego.legoPointMap.put(BlockType.OneAndSix,
                oneAndSixList);
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
                        BlockType.SixAndOne);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + ","
                            + ib.getRGB() + "," + ib.isCovered() + ","
                            + ib.getBlockType());
                    sixAndOneList.add(ib);
                    draw(g, ib, this.width, this.height);

                }

            }
        }

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                ib = list[i][j];
                if (ib.isCovered()) {
                    continue;
                }
                LegoUtil.cover(ib, list, this.height, this.width, BlockType.OneAndSix);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + "," + ib.getRGB() + ","
                            + ib.isCovered() + "," + ib.getBlockType());
                    oneAndSixList.add(ib);
                    draw(g, ib, this.height, this.width);
                }

            }
        }
        
    }


}
