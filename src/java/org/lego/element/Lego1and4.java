package org.lego.element;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.lego.process.ImageToLego;
import org.lego.utility.LegoUtil;

public class Lego1and4 extends LegoBlock {

    private List<ImageBit> fourAndOneList = new ArrayList<ImageBit>();
    private List<ImageBit> oneAndFourList = new ArrayList<ImageBit>();
    
    public Lego1and4(Graphics g) {
        this.blockSize = BlockSize.OneAndFour;
        this.width = 4;
        this.height = 1;
        this.g = g;

        ImageToLego.legoPointMap.put(BlockType.FourAndOne,
        		fourAndOneList);
        ImageToLego.legoPointMap.put(BlockType.OneAndFour,
        		oneAndFourList);
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
                        BlockType.FourAndOne);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + ","
                            + ib.getRGB() + "," + ib.isCovered() + ","
                            + ib.getBlockType());
                    fourAndOneList.add(ib);
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
                LegoUtil.cover(ib, list, this.height, this.width, BlockType.OneAndFour);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + "," + ib.getRGB() + ","
                            + ib.isCovered() + "," + ib.getBlockType());
                    oneAndFourList.add(ib);
                    draw(g, ib, this.height, this.width);
                }

            }
        }
        
    }

}
