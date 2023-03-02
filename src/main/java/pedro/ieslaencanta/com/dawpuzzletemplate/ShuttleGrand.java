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
    private float angulo=0; // angulo depende de imagen de shuttle
//<<<<<<< HEAD
    private static int WIDTH=65; // ancho nuestro shuttle
//=======
//    private static int WIDTH=60 ;
//>>>>>>> 3360aee1f8dbf12c6226056e1e5d5d21619f647a
    private static int HEIGHT=40; // alto nuestro shuttle
    private int ImageX=1; // coordenada x de image
    private int ImageY=1805; // coordenada y de image
    private boolean debug; 
    
    public ShuttleGrand(Point2D posicion) { // constructor 
        this.posicion = posicion;
    }

    public ShuttleGrand() { // constructor
    }

    /**
     * @param debug the debug to set
     */
    public void setDebug(boolean debug) { // set para Debug
        this.debug = debug;
    }
    
    public void paint(GraphicsContext gc) { // metodo pintar nuestro shuttle
            if(this.angulo==0){ // si tenemos angulo 0 tenemos estos condiciones
                this.ImageX=1; // coordenadas x y y para angulo 0, para empezar
                this.ImageY=1805;
            }
            else {
                int count_angulo=(int)(angulo/1.4); // encontramos cantidad pasos
                if(count_angulo<0){ // hacemos, que tenemos negativos valores, hacemos en el otro lado 
                count_angulo=-count_angulo;
                }
                this.ImageX=(count_angulo)*65; // cada paso añadimos ancho
//                this.ImageX=this.ImageX + this.WIDTH;

//                this.ImageY=((int)(((count_angulo/12))*40)+1805);
//                this.ImageX=1+(count_angulo-(((this.ImageY-1805)/65)-1)*12)*65;
                    if(this.ImageX > 716){ // si termina la linea con imagines, volvemos al principio
                        this.ImageX= 1;
                        this.angulo = 0;
                    }
            }      
//        if(this.ImageX > 716){
//            this.ImageX=1;
//            
//        }
        Resources r = Resources.getInstance(); //hacemos objeto
//        
//<<<<<<< HEAD
//=======
//        this.ImageX=1;
//        this.ImageY=1805;
//        
//         Resources r = Resources.getInstance();
//>>>>>>> 3360aee1f8dbf12c6226056e1e5d5d21619f647a
        gc.drawImage(r.getImage("spriters"), // pintamos de nuesto imagin
        //inicio de la posicion
        this.ImageX,
        this.ImageY,
        ShuttleGrand.WIDTH,
        ShuttleGrand.HEIGHT,
        //dibujar en el lienzo (hacemos coordenadas y tamaño, donde esta)
        (this.posicion.getX() - ShuttleGrand.WIDTH/2) * Game.SCALE,
        (this.posicion.getY() - ShuttleGrand.HEIGHT/2) * Game.SCALE,
        ShuttleGrand.WIDTH * Game.SCALE,
        ShuttleGrand.HEIGHT * Game.SCALE);
    }
    
    public void moveLeft(){ // movimiento al presionar Left
        this.angulo-=1.4f; // restar nuesto angulo para el movimiento a la izquierda
    }
    public void moveRight(){ // movimiento al presionar Right
        this.angulo+=1.4f; // restar nuesto angulo para el movimiento a la derecha
    }
    
}
