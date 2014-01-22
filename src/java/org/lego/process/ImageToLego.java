package org.lego.process;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.lego.element.BlockType;
import org.lego.element.ImageBit;
import org.lego.element.Lego1and1;
import org.lego.element.Lego1and2;
import org.lego.element.Lego1and3;
import org.lego.element.Lego1and4;
import org.lego.element.Lego1and6;
import org.lego.element.Lego2and2;
import org.lego.element.Lego4and2;
import org.lego.element.LegoBlock;
import org.lego.service.ConvertImageToLegoService;
import org.lego.utility.ImageUtil;

public class ImageToLego {

    public static Map<BlockType, List<ImageBit>> legoPointMap = new HashMap<BlockType, List<ImageBit>>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        BufferedImage bi = ImageUtil.getImageBit("finaldesign.bmp");

        ConvertImageToLegoService convertImageToLegoService = new ConvertImageToLegoService();

        int count = 0;

        List<BufferedImage> subBiList = ImageUtil.getSubImageBits(bi);
        for (BufferedImage subBi : subBiList) {

            BufferedImage image = new BufferedImage(50 * LegoBlock.MULTIPLE_TIMES,
                    50 * LegoBlock.MULTIPLE_TIMES, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();

            g.setColor(Color.white);
            g.fillRect(0, 0, 50 * LegoBlock.MULTIPLE_TIMES, 50 * LegoBlock.MULTIPLE_TIMES);
            
            
            List<LegoBlock> legoBlockList = init(g);

            ImageBit[][] list = convertImageToLegoService.convertImageToBit(subBi, count);
            count = count + 1;
            for (LegoBlock legoBlock : legoBlockList) {
                legoBlock.cover(list);
            }

            try {
                ImageIO.write(image, "bmp", new File(count + ".bmp"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            StringBuilder s = new StringBuilder();
            for (LegoBlock legoBlock : legoBlockList) {
                s.append(legoBlock.getDescription());

            }

            writeFile(count + ".txt", s.toString());

        }

    }

    private static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.append(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static List<LegoBlock> init(Graphics g) {
        List<LegoBlock> blockList = new ArrayList<LegoBlock>();
        blockList.add(new Lego4and2(g));
        blockList.add(new Lego2and2(g));
        blockList.add(new Lego1and6(g));
        blockList.add(new Lego1and4(g));
        blockList.add(new Lego1and3(g));
        blockList.add(new Lego1and2(g));
        blockList.add(new Lego1and1(g));
        return blockList;

    }

}
