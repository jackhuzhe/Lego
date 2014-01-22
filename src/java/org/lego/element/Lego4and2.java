package org.lego.element;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.lego.process.ImageToLego;
import org.lego.utility.LegoUtil;

public class Lego4and2 extends LegoBlock {

    private List<ImageBit> fourAndTwoList = new ArrayList<ImageBit>();
    private List<ImageBit> twoAndFourList = new ArrayList<ImageBit>();

    public Lego4and2(Graphics g) {
        this.blockSize = BlockSize.TwoAndFour;
        this.width = 4;
        this.height = 2;
        this.g = g;

        ImageToLego.legoPointMap.put(BlockType.FourAndTwo, fourAndTwoList);
        ImageToLego.legoPointMap.put(BlockType.TwoAndFour, twoAndFourList);

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
                LegoUtil.cover(ib, list, this.width, this.height, BlockType.FourAndTwo);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + "," + ib.getRGB() + ","
                            + ib.isCovered() + "," + ib.getBlockType());
                    fourAndTwoList.add(ib);
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
                LegoUtil.cover(ib, list, this.height, this.width, BlockType.TwoAndFour);
                if (ib.isCovered()) {
                    System.out.println(ib.getX() + "," + ib.getY() + "," + ib.getRGB() + ","
                            + ib.isCovered() + "," + ib.getBlockType());
                    twoAndFourList.add(ib);
                    draw(g, ib, this.height, this.width);
                    if (colorNumbers.get(ib.getRGB()) == null) {
                        colorNumbers.put(ib.getRGB(), new ArrayList<ImageBit>());
                    }
                    colorNumbers.get(ib.getRGB()).add(ib);
                }

            }
        }
    }

}
