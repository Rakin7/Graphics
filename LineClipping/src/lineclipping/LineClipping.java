/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineclipping;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author sajib
 */
public class LineClipping  implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;
    public static int xmin=0;
    public static int xmax=200;
    public static int ymin=0;
    public static int ymax=100;
    public static int INSIDE = 0;
    public static int LEFT   = 1;
    public static int RIGHT  = 2;
    public static int BOTTOM = 4;
    public static int TOP = 8;
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
        
		drawRectangle(gl, xmin, ymin, xmax, ymax);//draw display
		
        CohenSutherlandLineClipAndDraw(gl,50,-60,-50,75);

        CohenSutherlandLineClipAndDraw(gl,10,50,900,50);
        
        CohenSutherlandLineClipAndDraw(gl,20,-50,70,250);
        
        CohenSutherlandLineClipAndDraw(gl,-100,-50,-50,50);
        
        CohenSutherlandLineClipAndDraw(gl,70,24,60,60);
        
    }
    

    private void drawLine(GL2 gl,int i, int j, int k, int l, int colorx) 
    {   	
    	if(colorx==0) 
        {
    		gl.glColor3d(0, 0, 0);
        }
    	if(colorx==1) 
        {
            gl.glColor3d(0, 255, 0);
        }
        gl.glBegin (GL2.GL_LINES);
        gl.glVertex3f(i, j, 0);
        gl.glVertex3f(k, l, 0);
        gl.glEnd();
		
	}

	@Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }
    
    
    void CohenSutherlandLineClipAndDraw(GL2 gl,int x0, int y0, int x1, int y1){
    	drawLine(gl,x0,y0,x1,y1,0);
    	int outcode0 = computeOutCode(x0, y0);
    	int outcode1 = computeOutCode(x1, y1);
    	//System.out.println("OutCode0: " + outcode0 + ", OutCode1: " + outcode1);
    	boolean accept = false;
     
    	while (true) {
    		if ((outcode0 | outcode1)==0) 
                {
    			accept = true;
    			System.out.println("Accept");
    			break;
    		} 
                else if ((outcode0 & outcode1)!=0) 
                {
    			accept=false; //can avoid as accept is already false
    			System.out.println("Reject");
    			break;
    		} 
                else 
                {
    			System.out.println("Partially accept");
    			int x, y;    			 
    			int outcodeOut = (outcode0 != 0) ? outcode0 : outcode1;
    			if ((outcodeOut & TOP) != 0) 
                        {      			
    				x = x0 + (x1 - x0) * (ymax - y0) / (y1 - y0);
    				y = ymax;
    			} 
                        else if ((outcodeOut & BOTTOM) != 0) 
                        { 		
    				x = x0 + (x1 - x0) * (ymin - y0) / (y1 - y0);
    				y = ymin;
    			} 
                        else if ((outcodeOut & RIGHT) != 0) 
                        {  							
    				y = y0 + (y1 - y0) * (xmax - x0) / (x1 - x0);
    				x = xmax;
    			} else
                        {   
    				y = y0 + (y1 - y0) * (xmin - x0) / (x1 - x0);
    				x = xmin;
    			}
    			 // Now we move outside point to intersection point to clip
    			if (outcodeOut == outcode0) 
                        {
    				x0 = x;
    				y0 = y;
    				outcode0 = computeOutCode(x0, y0);
    			} 
                        else 
                        {
    				x1 =x;
    				y1 = y;
    				outcode1 = computeOutCode(x1, y1);
    			}
    		}
    	}
    	if (accept) 
        {

    		System.out.println(x0+" "+y0+" "+x1+" "+y1);
    		drawLine(gl,x0,y0,x1,y1,1);
    		System.out.println();
    	}
    }

    

    private void drawRectangle(GL2 gl, int xmin0, int ymin0, int xmax0, int ymax0) 
    {
		gl.glPointSize(6.0f);
		gl.glColor3d(50, 100, 50);

		gl.glBegin(GL2.GL_POINTS);
		
		for(int x=xmin0; x<=xmax0; x++) 
                {
	        gl.glVertex2f(x,ymin0);
		}
		for(int x=xmin0; x<=xmax0; x++) 
                {
		      gl.glVertex2f(x,ymax0);
                }
		for(int y=ymin0; y<=ymax0; y++) 
                {
		      gl.glVertex2f(xmin0,y);
                }
		for(int y=ymin0; y<=ymax0; y++) 
                {
		      gl.glVertex2f(xmax0,y);
                }
		gl.glEnd();	
	}

	private int computeOutCode(int x, int y)
        {
		int code = INSIDE;

        if (x < xmin) 
        {
            code |= LEFT;
        } 
        else if (x > xmax) 
        {
            code |= RIGHT;
        }
        if (y < ymin) 
        {
            code |= BOTTOM;
        }
        else if (y > ymax) 
        {
            code |= TOP;
        }

return code;
   }
        
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
    
}

