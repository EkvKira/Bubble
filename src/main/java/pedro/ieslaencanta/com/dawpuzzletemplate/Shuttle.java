/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawpuzzletemplate;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static pedro.ieslaencanta.com.dawpuzzletemplate.Bubble.HEIGHT;
import static pedro.ieslaencanta.com.dawpuzzletemplate.Bubble.WIDTH;

/**
 *
 * @author kirae
 */
public class Shuttle { // se llama Shuttle, pero esto flecha
    private Point2D posicion; 
    private float angulo=0;
    private float velocidad = 1f;
    private Bubble next;
    private Bubble actual;
//<<<<<<< HEAD
//    private static int WIDTH=64 ;
//    private static int HEIGHT=64;
//    private int ImageX=1;
//=======
    private static int WIDTH=62;
    private static int HEIGHT=60;
    private int ImageX=2;
//>>>>>>> 3360aee1f8dbf12c6226056e1e5d5d21619f647a
    private int ImageY=1548;
    private boolean debug;
    private Bubble ball;

    private Rectangle2D game_zone;
    public Shuttle(Point2D posicion, Rectangle2D game_zone) {
        this.posicion = posicion;
        this.game_zone = game_zone;
    }

    public Bubble getBall() {
        return ball;
    }

    public void setBall(Bubble ball) {
        this.ball = ball;
    }

    public Shuttle() {
    }
    
    public void setDebug(boolean debug){
        this.debug= debug;
            }
    public void paint(GraphicsContext gc) {
        if(this.angulo==0){
        this.ImageX=2;
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
            this.ImageX-= 1040;
        }
        
        }
        if(this.ImageY > 1744){
            if (angulo >= 0) {
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
        (this.posicion.getX() - Shuttle.WIDTH / 2) * Game.SCALE,
        (this.posicion.getY() - Shuttle.HEIGHT / 2) * Game.SCALE,
        Shuttle.WIDTH * Game.SCALE,
        Shuttle.HEIGHT * Game.SCALE);
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
        (this.posicion.getX() - Shuttle.WIDTH / 2) * Game.SCALE,
        (this.posicion.getY() - Shuttle.HEIGHT / 2) * Game.SCALE,
        Shuttle.WIDTH * Game.SCALE,
        Shuttle.HEIGHT * Game.SCALE);
        //si se esta depurando
        }
    }
    
    public void moveLeft(){
        this.angulo-=1.4f;
    }

    public void moveRight(){
        this.angulo+=1.4f;
    }

    public void shoot() {
        this.ball = new Bubble();
        this.ball.setDebug(debug);
        //se coloca el tipo de forma aleatorioa
        this.ball.setBalltype(BubbleType.values()[(int) (Math.random() * BubbleType.values().length)]);
        //se pone la posición (centro) y ángulo aleatorio
        this.ball.init(new Point2D((this.game_zone.getMaxX() - this.game_zone.getWidth() / 2),
                (this.game_zone.getMaxY() - 18)), (float) (angulo-90));
        this.ball.play();
    }
}

