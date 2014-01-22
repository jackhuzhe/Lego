package org.lego.element;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.lego.process.ImageToLego;
import org.lego.utility.LegoUtil;

public class Lego1and2 extends LegoBlock {
    private List<ImageBit> twoAndOneList = new ArrayList<ImageBit>();
    private List<ImageBit> oneAndTwoList = new ArrayList<ImageBit>();
    
    public Lego1and2(Graphics g) {
        this.blockSize = BlockSize.OneAndTow;
        this.width = 2;
        this.height = 1;
        this.g = g;

        ImageToLego.legoPointMap.put(BlockType.TwoAndOne,
        		twoAndOneList);
        ImageToLego.legoPointMap.put(BlockType.OneAndTwo,
        		oneAndTwoList);
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
                        BlockType.ThreeAndOne);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + ","
                            + ib.getRGB() + "," + ib.isCovered() + ","
                            + ib.getBlockType());
                    twoAndOneList.add(ib);
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
                LegoUtil.cover(ib, list, this.height, this.width, BlockType.OneAndThree);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + "," + ib.getRGB() + ","
                            + ib.isCovered() + "," + ib.getBlockType());
                    oneAndTwoList.add(ib);
                    draw(g, ib, this.height, this.width);
                }

            }
        }
        
    }


}
