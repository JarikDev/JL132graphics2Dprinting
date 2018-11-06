package com;

import com.sun.org.apache.bcel.internal.generic.L2D;

import javax.print.PrintException;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, PrintException, PrinterException {

        Printable printable = new Printable() {
            @Override
            public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex == 0) {
                    Graphics2D g2 = (Graphics2D) g;
                    Line2D l2 = new Line2D.Double(0, 0, 100, 100);
                    g2.draw(l2);
                    return PAGE_EXISTS;
                }
                return NO_SUCH_PAGE;
            }
        };
        PrinterJob pJ = PrinterJob.getPrinterJob();
        pJ.setPrintable(printable);
        if (pJ.printDialog()) {
            pJ.print();
        }
    }
}
