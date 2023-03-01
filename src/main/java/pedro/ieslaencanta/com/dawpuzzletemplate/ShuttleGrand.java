/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawpuzzletemplate;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author kirae
 */
public class ShuttleGrand {
    private Point2D posicion;
    private float angulo=0;
    private float velocidad = 1f;
    private Bubble next;
    private Bubble actual;
    private static int WIDTH=65;
    private static int HEIGHT=40;
    private int ImageX=1;
    private int ImageY=1805;
    private boolean debug;
    
    public ShuttleGrand(Point2D posicion) {
        this.posicion = posicion;
    }

    public ShuttleGrand() {
    }

    /**
     * @param debug the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    public void paint(GraphicsContext gc) {
            if(this.angulo==0){
                this.ImageX=1;
                this.ImageY=1805;
            }
            else {
                int count_angulo=(int)(angulo/1.4);
                if(count_angulo<0){
                count_angulo=-count_angulo;
                }
                this.ImageY=((int)(((count_angulo/16))*40)+1805);
                this.ImageX=1+(count_angulo-(((this.ImageY-1805)/65)-1)*16)*65;
                    if(this.ImageX > 716){
                        ImageX-= 716;
                    }
            }      
//        if(this.ImageX > 716){
//            if (angulo > 0) {
//                this.ImageX = 976;
//                this.ImageY = 1743;
//                this.angulo = 91;
//            }else {
//                this.ImageX = 976;
//                this.ImageY = 1743;
//                this.angulo = -91;
//            }
//        }
        Resources r = Resources.getInstance();
        
        gc.drawImage(r.getImage("spriters"),
        //inicio de la posicion
        this.ImageX,
        this.ImageY,
        ShuttleGrand.WIDTH,
        ShuttleGrand.HEIGHT,
        //dibujar en el lienzo
        (this.posicion.getX() - ShuttleGrand.WIDTH/2) * Game.SCALE,
        (this.posicion.getY() - ShuttleGrand.HEIGHT/2) * Game.SCALE,
        ShuttleGrand.WIDTH * Game.SCALE,
        ShuttleGrand.HEIGHT * Game.SCALE);
    }
    
    public void moveLeft(){
        this.angulo-=1.4f;
    }
    public void moveRight(){
        this.angulo+=1.4f;
    }
    
}
