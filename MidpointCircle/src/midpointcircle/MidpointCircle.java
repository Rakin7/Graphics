/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midpointcircle;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author sajib
 */
public class MidpointCircle  implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     * @param gld
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */      
        DrawCircle(gl, 100, 100 , 100);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }
    
    private void DrawCircle(GL2 gl, int xC, int yC, int radius) {
       //write your own code
       gl.glPointSize(8.0f);
       gl.glColor3d(0, 102, 204);
      
       
       gl.glBegin(GL2.GL_POINTS);       
       int d = 5/4-radius;
       int x=radius;
       int y=0;
       //int N=2*y + 3;
       //int NW= -2*x + 2*y + 5;
       while(x>y)
               {
       if(d <= 0)
       {
           d+=2*y + 3;
           y++;
       }
       else
       {
           d+=-2*x + 2*y + 5;
           x--;
           y++;
       }
       draw8SymmetricCurves(gl,xC,yC,x,y);
               }
               
       
       gl.glEnd();
    }
    
    
    
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }

    public void draw8SymmetricCurves(GL2 gl,int xc,int yc,int x,int y) {
      gl.glVertex2d(x+xc, y+yc);
      gl.glVertex2d(y+xc, x+yc);
      gl.glVertex2d(y+xc, -x+yc);
      gl.glVertex2d(x+xc, -y+yc);
      gl.glVertex2d(-x+xc, -y+yc);
      gl.glVertex2d(-y+xc, -x+yc);
      gl.glVertex2d(-y+xc, x+yc);
      gl.glVertex2d(-x+xc, y+yc);
    }
}

