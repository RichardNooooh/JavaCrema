package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import org.ideaman.calculus_espresso.CalculusEspresso;

import java.math.BigDecimal;
import java.util.HashMap;

public class Controller
{
    static void drawFunction(GraphicsContext gc, Canvas canvas, String equation)
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //TODO refactor this portion to an initializing function or something
        //background
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //grid lines
        int centerGraphX = (int)canvas.getWidth() / 2;
        int centerGraphY = (int)canvas.getHeight() / 2;
        gc.setStroke(Color.BLACK);
        gc.strokeLine(centerGraphX, 0, centerGraphX, canvas.getHeight());
        gc.strokeLine(0, centerGraphY, canvas.getWidth(), centerGraphY);

        CalculusEspresso ce = new CalculusEspresso(equation);
        HashMap variableMap = new HashMap();

        int N = 10000;
        double delX_pixels = canvas.getWidth() / N;
        Color lineColor = Color.RED;
        PixelWriter pixelWriter = gc.getPixelWriter();
        for (int i = 0; i < N; i++)
        {
            //TODO setPixels() would be better for efficiency I think, and I should use a thread to make it better.
            variableMap.put("x", new BigDecimal(-centerGraphX + delX_pixels * i));
            double y;
            try {
                y = ce.evaluate(variableMap);
            } catch (Exception e)
            {
                y = 0;
            }
            pixelWriter.setColor((int)(delX_pixels * i), (int)(centerGraphY - y), lineColor);
        }


    }
}
