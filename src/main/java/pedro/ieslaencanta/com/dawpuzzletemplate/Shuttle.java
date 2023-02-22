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
    private float angulo=20;
    private float velocidad = 1f;
    private Bubble next;
    private Bubble actual;
    private static int WIDTH=60 ;
    private static int HEIGHT=60;
    private int ImageX=1040;
    private int ImageY=0;
    

    public Shuttle(Point2D posicion) {
        this.posicion = posicion;
    }

    public Shuttle() {
    }
    
    public void paint(GraphicsContext gc) {
        float count_angulo=angulo/1.4f;
        this.ImageY=(int)(count_angulo/16);
        this.ImageX=(int)(16-(count_angulo/16));
                
        Resources r = Resources.getInstance();
        gc.drawImage(r.getImage("arrow"),
        //inicio de la posicion
        this.ImageX,
        this.ImageY,
        Shuttle.WIDTH,
        Shuttle.HEIGHT,
        //dibujar en el lienzo
        (this.posicion.getX() - Shuttle.WIDTH / 5) * Game.SCALE,
        (this.posicion.getY() - Shuttle.HEIGHT / 5) * Game.SCALE,
        Shuttle.WIDTH * Game.SCALE/3,
        Shuttle.HEIGHT * Game.SCALE/3);
        //si se esta depurando
        
    }
    
    public void moveLeft(){
        this.angulo+=1.4f;
    }

    public void moveRight(){
        this.angulo-=1.4f;
    }
    
}

