/* 
Lucas Josaphat 
6/2/2024

In the assignment, I made a few colors to help make the art I wanted to make and after that, I made an array that holds the colors for me to call upon later.
 After that, I made a 2d array to map out where every single pixel would be in the pixel art that I made.
Once I was done with that, I made a loop and a nested loop to set the color based on the number used in the 2d array, 
how big the rectangles will be to make the pixels, 
and where the position the pixels will be based on the starting position defined earlier in the code along with where the color is in the 2d array.
*/

import java.awt.*;

public class ArtProject {
    public static void main(String[] args) {
        // assign pixel size and where the art starts
        int pixelSize = 4;
        
        int startPos1 = 200;
        
        int startPos2 = 200;
        
        DrawingPanel panel = new DrawingPanel(500, 500);
        panel.setBackground(Color.WHITE);
        Graphics g = panel.getGraphics();
        
        // Establish colors and make colors needed
        Color brown = new Color(192, 128, 64);
        Color yellows = new Color(225, 224, 141); 
        Color[] colors = {
            Color.WHITE, 
            Color.black, 
            Color.red, 
            Color.DARK_GRAY, 
            Color.gray, 
            Color.lightGray, 
            Color.yellow, 
            Color.orange, 
            brown, 
            yellows, 
            Color.cyan
        };
        
        // Make the outline for the Pixel Art
        int[][] pixelArt = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0 ,0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 8, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 8, 1, 0, 0, 0, 0, 0, 0, 1, 1, 9, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 8, 3, 8, 1, 0, 0, 0, 0, 1, 9, 9, 9, 9, 1, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
            {0, 0, 2, 2, 0, 1, 8, 3, 8, 1, 2, 0, 0, 1, 8, 9, 9, 8, 3, 1, 0, 0, 0, 0, 2, 7, 2, 0, 0, 0, 0, 0},
            {0, 0, 2, 6, 2, 1, 8, 8, 8, 1, 7, 2, 1, 8, 9, 9, 8, 3, 1, 0, 0, 0, 0, 2, 7, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 7, 2, 1, 8, 1, 1, 1, 2, 1, 9, 9, 9, 9, 9, 1, 0, 0, 0, 0, 2, 9, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 7, 2, 1, 1, 2, 1, 8, 1, 9, 9, 9, 9, 8, 3, 1, 0, 0, 0, 0, 2, 7, 7, 2, 0, 0, 2, 0, 0},
            {0, 0, 2, 7, 9, 2, 1, 2, 2, 1, 8, 3, 9, 9, 9, 9, 9, 1, 0, 0, 0, 0, 0, 0, 2, 7, 2, 0, 2, 7, 2, 0},
            {0, 2, 7, 7, 2, 0, 1, 2, 2, 1, 3, 9, 9, 9, 2, 2, 9, 1, 0, 0, 0, 0, 0, 0, 2, 7, 2, 0, 2, 7, 2, 0},
            {0, 2, 6, 2, 0, 0, 1, 2, 2, 2, 3, 9, 9, 1, 2, 1, 8, 1, 0, 0, 0, 0, 0, 2, 9, 7, 2, 0, 2, 7, 2, 0},
            {2, 6, 6, 2, 0, 0, 1, 2, 2, 3, 9, 9, 1, 6, 2, 1, 8, 1, 0, 0, 0, 0, 2, 7, 9, 2, 0, 0, 2, 7, 7, 2},
            {2, 6, 6, 2, 0, 0, 0, 1, 2, 3, 9, 3, 10, 6, 2, 2, 1, 8, 1, 0, 0, 0, 2, 9, 9, 2, 0, 0, 2, 7, 9, 2},
            {2, 6, 6, 6, 2, 0, 2, 1, 2, 2, 2, 2, 6, 2, 2, 1, 9, 0, 1, 0, 1, 1, 2, 2, 9, 2, 0, 2, 7, 7, 7, 2},
            {0, 2, 6, 6, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 9, 9, 2, 1, 2, 2, 1, 1, 9, 2, 2, 7, 7, 7, 2, 0},
            {0, 0, 2, 6, 6, 1, 1, 3, 3, 1, 1, 2, 2, 1, 1, 9, 1, 2, 2, 2, 2, 2, 3, 5, 1, 2, 7, 7, 7, 2, 0, 0},
            {0, 0, 0, 2, 1, 5, 1, 3, 1, 1, 5, 1, 1, 9, 9, 9, 9, 1, 2, 2, 1, 1, 5, 3, 5, 1, 7, 7, 7, 2, 0, 0},
            {0, 0, 0, 0, 1, 3, 1, 1, 0, 0, 1, 8, 8, 1, 1, 9, 9, 9, 1, 1, 0, 0, 1, 5, 5, 1, 7, 2, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 1, 8, 1, 2, 1, 9, 9, 9, 9, 1, 0, 1, 5, 3, 9, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 1, 9, 1, 0, 0, 0, 1, 9, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0 ,0 ,0 ,0 ,0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 8, 1, 0, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        // Start painting the pixel art made above
        for (int y = 0; y < pixelArt.length; y++) {
            for (int x = 0; x < pixelArt[y].length; x++) {
                g.setColor(colors[pixelArt[y][x]]);
                g.fillRect(startPos1 + x * pixelSize, startPos2 + y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
}
