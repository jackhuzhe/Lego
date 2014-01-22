package org.lego.service;

import java.awt.image.BufferedImage;

import org.lego.element.ImageBit;
import org.lego.element.Quadrant;

public class ConvertImageToLegoService {


    public ImageBit[][] convertImageToBit(BufferedImage bi, int sequence){

        bi.getMinX();
        bi.getMinY();
        
        Quadrant quadrant = new Quadrant();
        quadrant.setSeq(sequence);
        
        ImageBit imageBitList[][] = new ImageBit[50][50];
        for (int y=0; y<50; y++){
            for (int x=0; x<50; x++){
                imageBitList[x][y] = new ImageBit();
                imageBitList[x][y].setX(x);
                imageBitList[x][y].setY(y);
                imageBitList[x][y].setRGB(bi.getRGB(x, y));
                imageBitList[x][y].setQuadrant(quadrant);
            }            
        }
        
        return imageBitList;
    }

}
