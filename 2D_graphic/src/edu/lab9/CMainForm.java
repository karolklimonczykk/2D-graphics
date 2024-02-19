package edu.lab9;

import edu.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class CMainForm extends javax.swing.JFrame{
    private JPanel mainPanel;
    private JPanel graphicArea;
    private CDocument document ;

    private void createUIComponents() {
        graphicArea = new CGraphicArea() ;
        mainPanel = new JPanel();
    }
    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        graphicArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                graphicAreaMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                graphicAreaMouseReleased();
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        graphicArea.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                graphicAreaMouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {}
        });
        document = new CDocument((CGraphicArea) graphicArea);
        document.addShape(new CShapeCircle(200, 200, Color.lightGray, Color.BLACK, 70));
        document.addShape(new CShapeCircle(600, 300, Color.YELLOW, Color.BLUE, 90));
        document.addShape(new CPolyRTriangle(500,600,Color.YELLOW,Color.BLUE,200,150));
        document.addShape(new CPolyAngle(300,400,Color.RED,Color.BLACK,150,250));
        document.addShape(new CPolyZBar(800,500, Color.CYAN,Color.BLUE,150,250));
        document.addShape(new CPolyCBar(1000,250, Color.GREEN, Color.BLUE,150,250));
        document.addShape(new CPolyTBar(1000,800, Color.PINK, Color.MAGENTA,150,200));
        document.addShape(new CPolyDoubleTBar(400,700, Color.lightGray, Color.black,150,200));
        document.addShape(new CPolyRPipe(0,800, Color.MAGENTA, Color.BLUE,300,200));
        document.addShape(new CTextShape(100,100,"Lorem Ipsum",Color.RED));

        // RANDOM 200s CIRCLES GENERATOR
        /*
        Random random = new Random();
        for(int i = 0 ; i < 200; i++){
            document.addShape(new CShapeCircle(random.nextInt(1200), random.nextInt(800), new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)),  new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)), random.nextInt(10,120) ));
        }
        */
        document.redraw();
    }



    private void graphicAreaMousePressed(MouseEvent evt){
        if(evt.getButton()==MouseEvent.BUTTON1){
            if(document.selectShape(evt.getX(),evt.getY()))
                document.redraw();
        }
    }
    private void graphicAreaMouseReleased(){
        document.deselectShape();;
        document.redraw();
    }
    private void graphicAreaMouseDragged(MouseEvent evt){
        document.moveSelectedTo(evt.getX(), evt.getY());
        long time = document.redraw();
        if (time > 0)
            setTitle(String.format("Shapes, drawing time %d ms", time));
    }

}
