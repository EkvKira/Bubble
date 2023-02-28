/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawpuzzletemplate;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static pedro.ieslaencanta.com.dawpuzzletemplate.Bubble.HEIGHT;
import static pedro.ieslaencanta.com.dawpuzzletemplate.Bubble.WIDTH;

/**
 *
 * @author kirae
 */
public class Shuttle {
    private Point2D posicion;
    private float angulo=0;
    private float velocidad = 1f;
    private Bubble next;
    private Bubble actual;
    private static int WIDTH=65 ;
    private static int HEIGHT=64;
    private int ImageX=1;
    private int ImageY=1548;
    private boolean debug;
  

    public Shuttle(Point2D posicion) {
        this.posicion = posicion;
    }

    public Shuttle() {
    }
    
    public void setDebug(boolean debug){
        this.debug= debug;
            }
    public void paint(GraphicsContext gc) {
        if(this.angulo==0){
        this.ImageX=1;
        this.ImageY=1548;
        }
//        else if (this.angulo<0){
//             int count_angulo=(int)(angulo/1.4);
//        this.ImageY=(int)((count_angulo/16))*64;
//        this.ImageX=1040+(count_angulo-((this.ImageY/60)-1)*16)*65;
//        if(this.ImageX > 2020){
//            ImageX-= 1040;
//        }
//        }
//        else {
//        int count_angulo=(int)(angulo/1.4);
//        this.ImageY=(int)((count_angulo/16))*60;
//        this.ImageX=1040+(count_angulo-((this.ImageY/60)-1)*16)*65;
//        if(this.ImageX > 2080){
//            ImageX-= 1040;
//        }
        else {
        int count_angulo=(int)(angulo/1.4);
        if(count_angulo<0){
        count_angulo=-count_angulo;
        }
        this.ImageY=((int)(((count_angulo/16))*65)+1548);
        this.ImageX=1+(count_angulo-(((this.ImageY-1548)/65)-1)*16)*65;
        if(this.ImageX > 1040){
            ImageX-= 1040;
        }
        
        }
        if(this.ImageY > 1744){
            if (angulo > 0) {
                this.ImageX = 976;
                this.ImageY = 1743;
                this.angulo = 91;
            }else {
                this.ImageX = 976;
                this.ImageY = 1743;
                this.angulo = -91;
            }
        }
        
        Resources r = Resources.getInstance();
        if (this.angulo>=0){
        gc.drawImage(r.getImage("spriters"),
        //inicio de la posicion
        this.ImageX,
        this.ImageY,
        Shuttle.WIDTH,
        Shuttle.HEIGHT,
        //dibujar en el lienzo
        (this.posicion.getX() - Shuttle.WIDTH / 3) * Game.SCALE,
        (this.posicion.getY() - Shuttle.HEIGHT / 3) * Game.SCALE,
        Shuttle.WIDTH * Game.SCALE/2,
        Shuttle.HEIGHT * Game.SCALE/2);
        //si se esta depurando
        }
        else {
         int hg = this.ImageX+64;
         int ccv = this.ImageY;
         int hgg =  -Shuttle.WIDTH;
         gc.drawImage(r.getImage("spriters"),
        //inicio de la posicion
        hg,
        this.ImageY,
        hgg,
        Shuttle.HEIGHT,
        //dibujar en el lienzo
        (this.posicion.getX() - Shuttle.WIDTH / 3) * Game.SCALE,
        (this.posicion.getY() - Shuttle.HEIGHT / 3) * Game.SCALE,
        Shuttle.WIDTH * Game.SCALE/2,
        Shuttle.HEIGHT * Game.SCALE/2);
        //si se esta depurando
        }
    }
    
    public void moveLeft(){
        this.angulo-=1.4f;
    }

    public void moveRight(){
        this.angulo+=1.4f;
    }
    
}

