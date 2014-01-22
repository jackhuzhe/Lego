package org.lego.element;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LegoBlock {

    protected BlockSize blockSize;

    protected int width;

    protected int height;

    protected Graphics g;

    protected Map<Integer, List<ImageBit>> colorNumbers = new HashMap<Integer, List<ImageBit>>();

    public static final int MULTIPLE_TIMES = 10;

    
    
    public abstract void cover(ImageBit[][] list);

    

    public StringBuilder getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.blockSize.getDesc() + "\n");
        for (Integer key : this.colorNumbers.keySet()) {
            List<ImageBit> ibList = this.colorNumbers.get(key);
            int n = ibList.size();
            if (n > 0) {
                
                sb.append("     " + getColor(key) + ":" + n + "\n");
            }
        }
        sb.append("\n");
        return sb;
    }
    
    
    protected void draw(Graphics g, ImageBit ib, int width, int height) {

        g.setColor(new Color(ib.getRGB()));
        
        g.fillRect(ib.getX() * LegoBlock.MULTIPLE_TIMES, ib.getY() * LegoBlock.MULTIPLE_TIMES, width
                * LegoBlock.MULTIPLE_TIMES, height * LegoBlock.MULTIPLE_TIMES);

        g.setColor(Color.gray);
        g.drawRect(ib.getX() * LegoBlock.MULTIPLE_TIMES, ib.getY() * LegoBlock.MULTIPLE_TIMES, width
                * LegoBlock.MULTIPLE_TIMES, height * LegoBlock.MULTIPLE_TIMES);

        System.out.println("Drawing:" + ib.getX() + "," + ib.getY());
        if (colorNumbers.get(ib.getRGB()) == null) {
            colorNumbers.put(ib.getRGB(), new ArrayList<ImageBit>());
        }
        colorNumbers.get(ib.getRGB()).add(ib);
    }
    

    private String getColor(Integer value) {
        switch (value) {
            case -16777216:
                return "Black";
            case -1:
                return "White";
            case -988381:
                return "Yellow";
            case -14803236:
                return "Blue";
            case -65536:
                return "Red";
            default:
                break;
        }
        return null;
    }

}
